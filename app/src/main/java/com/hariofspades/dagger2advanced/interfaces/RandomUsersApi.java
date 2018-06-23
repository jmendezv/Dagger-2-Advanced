package com.hariofspades.dagger2advanced.interfaces;

import com.hariofspades.dagger2advanced.model.RandomUsers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *
 * Created by Hari on 23/11/17.
 *
 * Retrofit is a REST Client for Android and Java by Square.
 *
 * It makes it relatively easy to retrieve and upload JSON
 * (or other structured data) via a REST based webservice.
 *
 * In Retrofit you configure which converter is used for the data serialization.
 *
 * Typically for JSON you use GSon, but you can add custom converters to
 * process XML or other protocols.
 *
 * Retrofit uses the OkHttp library for HTTP requests.
 *
 *
 */

public interface RandomUsersApi {
    @GET("api")
    Call<RandomUsers> getRandomUsers(@Query("results") int size);
}