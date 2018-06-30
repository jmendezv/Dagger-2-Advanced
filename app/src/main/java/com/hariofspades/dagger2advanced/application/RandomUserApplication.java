package com.hariofspades.dagger2advanced.application;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by Hari on 20/12/17.
 * <p>
 * Important: add application name in Manifest file!
 */

public class RandomUserApplication extends Application {

   @Override
   public void onCreate() {
      super.onCreate();
      Timber.plant(new Timber.DebugTree());
      Timber.d("in RandomUserApplication.onCrete()");
   }

}
