package com.hariofspades.dagger2advanced.model.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


/*
*
* You must perform queries on worker thread,
* otherwise your application will crash.
*
* */
@Database(entities = {ResultEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

   private static AppDatabase instance = null;

   public abstract ResultDao resultDao();

   public static AppDatabase getAppDatabase(Context context) {
      if (instance == null) {
         instance = Room.databaseBuilder(
              context.getApplicationContext(),
              AppDatabase.class,
              "app-database")
              .allowMainThreadQueries()
              .build();
      }
      return instance;
   }

   public static void destroyInstance() {
      instance = null;
   }

}
