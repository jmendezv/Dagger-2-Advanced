package com.hariofspades.dagger2advanced.application;

import android.app.Activity;
import android.app.Application;

import com.hariofspades.dagger2advanced.components.DaggerRandomUserComponent;
import com.hariofspades.dagger2advanced.components.RandomUserComponent;
import com.hariofspades.dagger2advanced.modules.ContextModule;

import timber.log.Timber;

/**
 * Created by Hari on 20/12/17.
 * <p>
 * Important: add application name in Manifest file!
 */

public class RandomUserApplication extends Application {

   private RandomUserComponent randomUserComponent;

   public static RandomUserApplication get(Activity activity) {
      return (RandomUserApplication) activity.getApplication();
   }

   @Override
   public void onCreate() {
      super.onCreate();
      Timber.plant(new Timber.DebugTree());

      randomUserComponent =
           DaggerRandomUserComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build();
   }

   public RandomUserComponent getRandomUserComponent() {
      return randomUserComponent;
   }
}
