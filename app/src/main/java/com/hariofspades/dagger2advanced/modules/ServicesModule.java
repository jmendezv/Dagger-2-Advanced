package com.hariofspades.dagger2advanced.modules;

import android.content.Context;
import android.os.Vibrator;

import com.hariofspades.dagger2advanced.adapter.RandomUserAdapter;
import com.hariofspades.dagger2advanced.interfaces.annotations.ApplicationContextAnnotation;
import com.hariofspades.dagger2advanced.services.AppSharedPreferences;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ContextModule.class})
public class ServicesModule {

   @Provides
   public RandomUserAdapter getRandomUserAdapter(Picasso picasso) {
      return new RandomUserAdapter(picasso);
   }

   @Provides
   public AppSharedPreferences getSharedPreferences(@ApplicationContextAnnotation Context context) {
      return new AppSharedPreferences(context);
   }

   @Provides
   public Vibrator providesVibrator(@ApplicationContextAnnotation Context context) {
      return ((Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE));
   }

}
