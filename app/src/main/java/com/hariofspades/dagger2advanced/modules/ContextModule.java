package com.hariofspades.dagger2advanced.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.hariofspades.dagger2advanced.adapter.RandomUserAdapter;
import com.hariofspades.dagger2advanced.interfaces.annotations.ApplicationContextAnnotation;
import com.hariofspades.dagger2advanced.preferences.AppSharedPreferences;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hari on 23/11/17.
 *
 * Review by Pep on 23/06/18
 */
@Module
public class ContextModule {

   private Context context;

   public ContextModule(Context context) {

      this.context = context;
   }

   @ApplicationContextAnnotation
   @Provides
   public Context getContext() {

      return context;
   }

   @Provides
   public RandomUserAdapter getRandomUserAdapter(Picasso picasso) {
      return new RandomUserAdapter(picasso);
   }

   @Provides
   public AppSharedPreferences getSharedPreferences() {
      return new AppSharedPreferences(context);
   }

}
