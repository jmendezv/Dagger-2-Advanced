package com.hariofspades.dagger2advanced.module;

import android.content.Context;

import com.hariofspades.dagger2advanced.interfaces.ApplicationContextAnnotation;
import com.hariofspades.dagger2advanced.interfaces.RandomUserApplicationScopeAnnotation;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Hari on 23/11/17.
 */
@Module(includes = OkHttpClientModule.class)
public class PicassoModule {

    @RandomUserApplicationScopeAnnotation
    @Provides
    public Picasso picasso(@ApplicationContextAnnotation Context context, OkHttp3Downloader okHttp3Downloader){
        return new Picasso.Builder(context).
                downloader(okHttp3Downloader).
                build();
    }

    @Provides
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient){
        return new OkHttp3Downloader(okHttpClient);
    }

}
