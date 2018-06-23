package com.hariofspades.dagger2advanced.module;

import android.content.Context;

import com.hariofspades.dagger2advanced.interfaces.ApplicationContextAnnotation;
import com.hariofspades.dagger2advanced.interfaces.RandomUserApplicationScopeAnnotation;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hari on 23/11/17.
 */
@Module
public class ContextModule {

    Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @ApplicationContextAnnotation
    @RandomUserApplicationScopeAnnotation
    @Provides
    public Context context(){ return context.getApplicationContext(); }
}
