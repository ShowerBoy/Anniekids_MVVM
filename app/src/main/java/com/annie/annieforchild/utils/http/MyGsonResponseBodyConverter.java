package com.annie.annieforchild.utils.http;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import me.goldze.mvvmhabit.http.BaseResponse;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import static okhttp3.internal.Util.UTF_8;

public class MyGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    MyGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();

//自定义解析实体类，只解析数据最外层，如code message
        BaseResponse re = gson.fromJson(response, BaseResponse.class);

        //关注的重点，自定义响应码中非1的情况，一律抛出ApiException异常。
        //这样，我们就成功的将该异常交给onError()去处理了。
        if (re.getStatus() != 0) {
            value.close();
//            throw new ApiException(re.getCode(), re.getMessage());
        }

        /**
         * 自定义返回结果解析
         * 在返回结果里提取data
         */
        JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
        int status = jsonObject.get("status").getAsInt();
        if (status != 0) {
            value.close();
            throw new ApiException(status, jsonObject.get("msg").getAsString());
        }
        String jsonString = jsonObject.get("data").toString();


//如果是1（数据正常返回），我们正常解析
        MediaType mediaType = value.contentType();
        Charset charset = mediaType != null ? mediaType.charset(UTF_8) : UTF_8;
        /**
         * 方式一：统一只解析data，先判断status
         */
//        ByteArrayInputStream bis = new ByteArrayInputStream(jsonString.getBytes());
        /**
         * 方式二：不管返回什么全部解析
         */
        ByteArrayInputStream bis = new ByteArrayInputStream(response.getBytes());
        InputStreamReader reader = new InputStreamReader(bis, charset);
        JsonReader jsonReader = gson.newJsonReader(reader);
        try {
            return adapter.read(jsonReader);
        } finally {
            value.close();
        }
    }
}
