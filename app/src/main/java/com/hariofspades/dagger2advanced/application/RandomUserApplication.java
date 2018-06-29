package com.hariofspades.dagger2advanced.application;

import android.app.Activity;
import android.app.Application;

import com.hariofspades.dagger2advanced.components.ApplicationComponent;
import com.hariofspades.dagger2advanced.components.DaggerApplicationComponent;
import com.hariofspades.dagger2advanced.modules.ContextModule;
import com.hariofspades.dagger2advanced.modules.OkHttpClientModule;
import com.hariofspades.dagger2advanced.modules.PicassoModule;
import com.hariofspades.dagger2advanced.modules.RandomUsersApiModule;

import timber.log.Timber;

/**
 * Created by Hari on 20/12/17.
 * <p>
 * Important: add application name in Manifest file!
 */

public class RandomUserApplication extends Application {

   private ApplicationComponent applicationComponent;

   public static RandomUserApplication get(Activity activity) {
      return (RandomUserApplication) activity.getApplication();
   }

   @Override
   public void onCreate() {
      super.onCreate();
      Timber.plant(new Timber.DebugTree());
      Timber.d("in RandomUserApplication.onCrete()");

      applicationComponent =
           DaggerApplicationComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build();
   }

   public ApplicationComponent getApplicationComponent() {

      return applicationComponent;
   }
}
