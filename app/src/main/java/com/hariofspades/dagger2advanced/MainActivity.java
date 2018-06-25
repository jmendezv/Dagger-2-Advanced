package com.hariofspades.dagger2advanced;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hariofspades.dagger2advanced.adapter.RandomUserAdapter;
import com.hariofspades.dagger2advanced.application.RandomUserApplication;
import com.hariofspades.dagger2advanced.interfaces.RandomUsersApi;
import com.hariofspades.dagger2advanced.model.RandomUsers;
import com.hariofspades.dagger2advanced.modules.ContextModule;
import com.hariofspades.dagger2advanced.components.*;
import com.hariofspades.dagger2advanced.preferences.AppSharedPreferences;

import java.util.Date;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
// an API for Android’s Log class
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

   private RecyclerView recyclerView;

   @Inject
   RandomUsersApi randomUsersApi;

   @Inject
   RandomUserAdapter mAdapter;

   @Inject
   AppSharedPreferences mAppSharedPreferences;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Timber.d("In MainActivity.onCreate()");
      setContentView(R.layout.activity_main);
      initViews();
      setupComponents();
      populateUsers();
   }

   @Override
   protected void onStart() {
      super.onStart();
      mAppSharedPreferences.storeString("last_edit", new Date().toString());
   }

   private void setupComponents() {
      DaggerMainActivityComponent
           .builder()
           .contextModule(new ContextModule(this))
           .applicationComponent(RandomUserApplication.get(this)
                .getApplicationComponent())
           .build()
           .inject(this);
   }

   private void initViews() {
      recyclerView = findViewById(R.id.recyclerView);
      recyclerView.setLayoutManager(new LinearLayoutManager(this));
   }

   private void populateUsers() {
      Call<RandomUsers> randomUsersCall =
           randomUsersApi.getRandomUsers(10);

      randomUsersCall.enqueue(new Callback<RandomUsers>() {
         @Override
         public void onResponse(Call<RandomUsers> call, @NonNull Response<RandomUsers> response) {
            if (response.isSuccessful()) {
               mAdapter.setItems(response.body().getResults());
               recyclerView.setAdapter(mAdapter);
            }
         }

         @Override
         public void onFailure(Call<RandomUsers> call, Throwable t) {
            Timber.i(t.getMessage());
         }
      });
   }

}
