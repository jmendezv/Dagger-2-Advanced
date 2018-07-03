package com.hariofspades.dagger2advanced.model.db;

import android.content.Context;

import com.hariofspades.dagger2advanced.model.json.Result;

import java.util.ArrayList;
import java.util.List;

public class ResultRepository {

   private AppDatabase database;
   // JSON results
   private List<Result> results;

   public ResultRepository(Context context, List<Result> results) {
      database = AppDatabase.getAppDatabase(context);
      this.results = results;
   }

   public void saveResult() {

      ResultDao dao = database.resultDao();
      database.clearAllTables();
      for (Result result : results) {
         ResultEntity entity = new ResultEntity();
         entity.setName(result.getName().getFirst());
         entity.setEmail(result.getEmail());
         dao.insert(entity);
      }

   }

   public List<ResultEntity> getResults() {

      List<ResultEntity> resultEntities = new ArrayList<>();

      for (Result result : results) {
         ResultEntity entity = new ResultEntity();
         entity.setName(result.getName().getFirst());
         entity.setEmail(result.getEmail());
         resultEntities.add(entity);
      }

      return resultEntities;
   }

}
