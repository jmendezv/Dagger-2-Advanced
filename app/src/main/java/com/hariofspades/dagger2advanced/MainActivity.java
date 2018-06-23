package com.hariofspades.dagger2advanced;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hariofspades.dagger2advanced.adapter.RandomUserAdapter;
import com.hariofspades.dagger2advanced.application.RandomUserApplication;
import com.hariofspades.dagger2advanced.components.MainActivityComponent;
import com.hariofspades.dagger2advanced.interfaces.RandomUsersApi;
import com.hariofspades.dagger2advanced.model.RandomUsers;
import com.hariofspades.dagger2advanced.modules.ContextModule;
import com.hariofspades.dagger2advanced.components.*;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
// an API for Android’s Log class
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

   // private Retrofit retrofit;

   private RecyclerView recyclerView;

   // private Picasso picasso;

   @Inject
   RandomUsersApi randomUsersApi;

   @Inject
   RandomUserAdapter mAdapter;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      initViews();
      //beforeDagger2();
      //afterDagger();
      afterActivityLevelComponent();
      populateUsers();

   }

   private void afterActivityLevelComponent() {
      DaggerMainActivityComponent
           .builder()
           .contextModule(new ContextModule(this))
           .randomUserComponent(RandomUserApplication.get(this)
                .getRandomUserComponent())
           .build()
           .inject(this);
   }

   public void afterDagger() {
//      RandomUserComponent daggerRandomUserComponent = DaggerRandomUserComponent.builder()
//           .contextModule(new ContextModule(this))
//           .build();
//      picasso = daggerRandomUserComponent.getPicasso();
//      randomUsersApi = daggerRandomUserComponent.getRandomUserApi();
   }

   private void beforeDagger2() {
//      GsonBuilder gsonBuilder = new GsonBuilder();
//      Gson gson = gsonBuilder.create();
//
//      Timber.plant(new Timber.DebugTree());
//
//      File cacheFile = new File(this.getCacheDir(), "HttpCache");
//      cacheFile.mkdirs();
//
//      Cache cache = new Cache(cacheFile, 10 * 1000 * 1000); //10 MB
//
//      HttpLoggingInterceptor httpLoggingInterceptor = new
//           HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//         @Override
//         public void log(@NonNull String message) {
//            Timber.i(message);
//         }
//      });
//
//      httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//
//      OkHttpClient okHttpClient = new OkHttpClient()
//           .newBuilder()
//           .cache(cache)
//           .addInterceptor(httpLoggingInterceptor)
//           .build();
//
//      OkHttp3Downloader okHttpDownloader = new OkHttp3Downloader(okHttpClient);
//
//      picasso = new Picasso.Builder(this).downloader(okHttpDownloader).build();
//
//      retrofit = new Retrofit.Builder()
//           .client(okHttpClient)
//           .baseUrl("https://randomuser.me/")
//           .addConverterFactory(GsonConverterFactory.create(gson))
//           .build();
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
