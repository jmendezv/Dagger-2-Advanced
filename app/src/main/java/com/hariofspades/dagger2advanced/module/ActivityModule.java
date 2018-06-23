package com.hariofspades.dagger2advanced.module;

import android.app.Activity;
import android.content.Context;

import com.hariofspades.dagger2advanced.interfaces.RandomUserApplicationScopeAnnotation;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hari on 23/11/17.
 */
@Module
public class ActivityModule {

    private final Context context;

    ActivityModule(Activity context){
        this.context = context;
    }

    @Named("activity_context")
    @RandomUserApplicationScopeAnnotation
    @Provides
    public Context context(){ return context; }
}
