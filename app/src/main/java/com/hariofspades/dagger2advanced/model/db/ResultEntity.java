package com.hariofspades.dagger2advanced.model.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "result")
public class ResultEntity {

   @PrimaryKey(autoGenerate = true)
   private int id;

   @ColumnInfo(name = "name")
   private String name;

   @ColumnInfo(name = "email")
   private String email;

}
