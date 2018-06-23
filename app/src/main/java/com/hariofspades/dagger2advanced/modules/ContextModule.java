package com.hariofspades.dagger2advanced.modules;

import android.content.Context;

import com.hariofspades.dagger2advanced.adapter.RandomUserAdapter;
import com.hariofspades.dagger2advanced.interfaces.annotations.ApplicationContextAnnotation;
import com.hariofspades.dagger2advanced.interfaces.annotations.MainActivityScopeAnnotation;
import com.hariofspades.dagger2advanced.interfaces.annotations.RandomUserApplicationScopeAnnotation;
import com.squareup.picasso.Picasso;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hari on 23/11/17.
 */
@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @RandomUserApplicationScopeAnnotation
    @Provides
    public Context getContext() {
        return context;
    }

    @ApplicationContextAnnotation
    @Provides
    public Context getApplicationContext() {
        return context.getApplicationContext();
    }

    @Provides
    @MainActivityScopeAnnotation
    public RandomUserAdapter randomUserAdapter(Picasso picasso){
        return new RandomUserAdapter(picasso);
    }
}
