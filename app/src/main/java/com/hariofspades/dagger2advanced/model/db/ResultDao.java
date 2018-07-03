package com.hariofspades.dagger2advanced.model.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ResultDao {

   @Query("SELECT * FROM result")
   List<ResultEntity> getAll();

   @Query("SELECT * FROM result WHERE id = :id")
   ResultEntity findByid(int id);

   @Query("SELECT * FROM result WHERE name LIKE :name")
   ResultEntity findByName(String name);

   @Query("SELECT COUNT(*) from result")
   int countResult();

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   void insert(ResultEntity... entity);

   @Delete
   void delete(ResultEntity entity);

}
