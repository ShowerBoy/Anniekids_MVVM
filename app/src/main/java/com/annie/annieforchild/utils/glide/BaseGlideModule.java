package com.annie.annieforchild.utils.glide;


import android.content.Context;
import android.util.Log;


import com.annie.annieforchild.R;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.target.ViewTarget;


@GlideModule
public class BaseGlideModule extends AppGlideModule {
    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        super.applyOptions(context, builder);
        ViewTarget.setTagId(R.id.glide_tag_id);
        builder.setLogLevel(Log.ERROR);
    }

}
