package com.hariofspades.dagger2advanced;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.hariofspades.dagger2advanced.adapter.RandomUserAdapter;
import com.hariofspades.dagger2advanced.interfaces.RandomUsersApi;
import com.hariofspades.dagger2advanced.model.json.RandomUsers;
import com.hariofspades.dagger2advanced.model.json.Result;
import com.hariofspades.dagger2advanced.modules.ContextModule;
import com.hariofspades.dagger2advanced.components.*;
import com.hariofspades.dagger2advanced.services.AppSharedPreferences;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
// an API for Android’s Log class
import timber.log.Timber;

/*
 * randomapi.com
 * jmendez1/nif-
 * O0Z4-1SI8-T4WP-MNRK
 *
 * */
public class MainActivity extends AppCompatActivity {

   private RecyclerView recyclerView;

   @Inject
   //Provider<RandomUsersApi> randomUsersApi;
        RandomUsersApi randomUsersApi;

   @Inject
   //Lazy<RandomUserAdapter> mAdapter;
        RandomUserAdapter mAdapter;

   @Inject
   AppSharedPreferences mAppSharedPreferences;

   @Inject
   Vibrator mVibrator;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Timber.d("In MainActivity.onCreate()");
      setContentView(R.layout.activity_main);
      initViews();
      setupComponents1();
      populateUsers();
   }

   private void vibrate() {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
         mVibrator.vibrate(VibrationEffect.createOneShot(250, 1));
      } else {
         mVibrator.vibrate(250);
      }
   }

   private void setupComponents1() {

      getLifecycle().addObserver(new android.arch.lifecycle.LifecycleObserver() {

         @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
         void onCreate() {
            Toast.makeText(getApplicationContext(), "LifeCycleObserver.onCreate()", Toast.LENGTH_LONG).show();
         }

         @OnLifecycleEvent(Lifecycle.Event.ON_START)
         void onStart() {
            Toast.makeText(getApplicationContext(), "LifeCycleObserver.onStart()", Toast.LENGTH_LONG).show();
            mAppSharedPreferences.storeString("last_edit", new Date().toString());
         }

         @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
         void onPause() {
            Toast.makeText(getApplicationContext(), "LifeCycleObserver.onPause()", Toast.LENGTH_LONG).show();
         }

         @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
         void onStop() {
            vibrate();
            Toast.makeText(getApplicationContext(), "LifeCycleObserver.onStop()", Toast.LENGTH_LONG).show();
         }

         @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
         void onResume() {
            vibrate();
            Toast.makeText(getApplicationContext(), "LifeCycleObserver.onResume()", Toast.LENGTH_LONG).show();
         }

         @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
         void onDestroy() {
            vibrate();
            Toast.makeText(getApplicationContext(), "LifeCycleObserver.onDestroy()", Toast.LENGTH_LONG).show();
         }

      });

      DaggerMainActivityComponent
           .builder()
           .contextModule(new ContextModule(this))
           .build()
           .inject(this);
   }

   /* A method with no parameters that returns a MembersInjector is equivalent to a members injection method */
   private void setupComponents2() {
      MainActivityComponent mainActivityComponent = DaggerMainActivityComponent
           .builder()
           .contextModule(new ContextModule(this))
           .build();
      mainActivityComponent.inject().injectMembers(this);
   }

   private void initViews() {
      recyclerView = findViewById(R.id.recyclerView);
      //recyclerView.setLayoutManager(new LinearLayoutManager(this));
   }

   private void populateUsers() {
      //  GET https://randomuser.me/api?results=10
      Call<RandomUsers> randomUsersCall =
           //randomUsersApi.get().getRandomUsers(10);
           randomUsersApi.getRandomUsers(50);

      randomUsersCall.enqueue(new Callback<RandomUsers>() {
         @Override
         public void onResponse(Call<RandomUsers> call, @NonNull Response<RandomUsers> response) {
            if (response.isSuccessful()) {
               //mAdapter.get().setItems(response.body().getResults());
               List<Result> results = response.body().getResults();
               mAdapter.setItems(results);
               recyclerView.setAdapter(mAdapter);
               Toast.makeText(getApplicationContext(), "adapter " + results.size(), Toast.LENGTH_LONG).show();
            }
         }

         @Override
         public void onFailure(Call<RandomUsers> call, Throwable t) {
            Timber.i(t.getMessage());
         }
      });
   }

}
