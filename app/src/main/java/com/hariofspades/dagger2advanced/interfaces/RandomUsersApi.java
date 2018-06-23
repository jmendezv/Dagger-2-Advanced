package com.hariofspades.dagger2advanced.interfaces;

import com.hariofspades.dagger2advanced.model.RandomUsers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *
 * Created by Hari on 23/11/17.
 *
 * Documented by Pep on 23/06/18
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
 * @GET is a GET request with an optional relative or absolute path, or full URL of the endpoint
 *
 * @Query is a Query parameter appended to the URL.
 *
 * Call<T> An invocation of a Retrofit method that sends a request to a web server and returns a response.
 * Each call yields its own HTTP request and response pair.
 *
 * Calls may be executed synchronously with execute(), or asynchronously with enqueue(retrofit2.Callback<T>).
 * In either case the call can be canceled at any time with cancel().
 *
 * A call that is busy writing its request or reading its response may receive a IOException;
 *
 * T is the successful response body type.
 *
 */

public interface RandomUsersApi {
   /*This yields /api?size=n */
    @GET("api")
    Call<RandomUsers> getRandomUsers(@Query("results") int size);
}