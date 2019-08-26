package com.annie.annieforchild.utils;

import android.text.TextUtils;

import org.greenrobot.essentials.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import okhttp3.HttpUrl;

public class UrlUtil {

    public static class Query {
        public String key;
        public String value;

        public Query(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static HashMap<String, String> getQueryMap(String url) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(url)){
            HttpUrl httpUrl = HttpUrl.parse(url);
            Set<String> keySet = httpUrl.queryParameterNames();
            for (String key : keySet) {
                hashMap.put(key, httpUrl.queryParameterValues(key).get(0));
            }
        }

        return hashMap;
    }

    public static ArrayList<Query> getQueries(String url) {
        ArrayList<Query> list = new ArrayList<>();
        HttpUrl httpUrl = HttpUrl.parse(url);
        Set<String> keySet = httpUrl.queryParameterNames();
        for (String key : keySet) {
            Query query = new Query(key, httpUrl.queryParameterValues(key).get(0));
            list.add(query);
        }
        return list;
    }

    public static String appendQuery(String url, String param, String value) {
        HttpUrl httpUrl = HttpUrl.parse(url);
        if (httpUrl != null && httpUrl.queryParameter(param) == null) {
            return appendQueryToUrl(url, param + "=" + value);
        } else {
            return url;
        }
    }

    public static String appendQueryToUrl(String url, String query) {
        String fullUrl = null;
        if (url.contains("?")) {
            fullUrl = url + "&" + query;
        } else {
            fullUrl = url + "?" + query;
        }
        return fullUrl;
    }

    public static String changeScheme2Http(String url) {
        if (url.startsWith("https")) {
            return url.replaceFirst("https", "http");
        } else {
            return url;
        }
    }

    public static boolean isPathIgnoreCaseEndsWith(String url, String suffix) {
        HttpUrl httpUrl = HttpUrl.parse(url);
        if (httpUrl == null) {
            return false;
        }
        List<String> segments = httpUrl.pathSegments();
        if (segments != null && segments.size() > 0) {
            String lastPath = segments.get(segments.size() - 1);
            String lowerLastPath = lastPath.toLowerCase();
            String lowerSuffix = suffix.toLowerCase();
            if (lowerLastPath.endsWith(lowerSuffix)) {
                return true;
            }
        }
        return false;
    }

    public static String getSuffix(String url) {
        HttpUrl httpUrl = HttpUrl.parse(url);
        if (httpUrl == null) {
            return null;
        }
        List<String> segments = httpUrl.pathSegments();
        if (segments != null && segments.size() > 0) {
            String lastPath = segments.get(segments.size() - 1);
            return lastPath.toLowerCase();
        } else {
            return null;
        }
    }

    public static String[] getUrlSegments(String url) {
        String[] segments = new String[5];
        StringBuilder sb = new StringBuilder();
        HttpUrl httpUrl = HttpUrl.parse(url);
        segments[0] = httpUrl.scheme();
        segments[1] = httpUrl.host();
        segments[2] = httpUrl.port() + "";
        pathSegmentsToString(sb, httpUrl.pathSegments());
        segments[3] = sb.toString();
        segments[4] = httpUrl.query();
        return segments;
    }

    public static int[] getImageWidthHeight(String url) {
        HttpUrl httpUrl = HttpUrl.parse(url);
        String sizeParam = httpUrl.queryParameter("size");
        if (TextUtils.isEmpty(sizeParam)) {
            return null;
        } else {
            String[] size = StringUtils.split(sizeParam, 'x');
            if (size != null && size.length == 2) {
                int[] sizeInt = new int[2];
                sizeInt[0] = String2Integer(size[0]);
                sizeInt[1] = String2Integer(size[1]);
                return sizeInt;
            } else {
                return null;
            }
        }
    }

    private static void pathSegmentsToString(StringBuilder out, List<String> pathSegments) {
        for (int i = 0, size = pathSegments.size(); i < size; i++) {
            out.append('/');
            out.append(pathSegments.get(i));
        }
    }

    public static int String2Integer(String str) {
        int i = 0;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
        }
        return i;
    }
}
