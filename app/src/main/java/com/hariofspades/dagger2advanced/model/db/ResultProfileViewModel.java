package com.hariofspades.dagger2advanced.model.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.hariofspades.dagger2advanced.model.json.Result;

import java.util.List;

/*
 *
 * A ViewModel provides the data for a specific UI component,
 * such as a fragment or activity, and handles the communication
 * with the business part of data handling, such as calling other
 * components to load the data or forwarding user modifications.
 *
 * The ViewModel does not know about the View and is not affected
 * by configuration changes such as recreating an activity due to
 * rotation.
 *
 * Android Developers   Platform   Libraries
LiveData overview

Contents
The advantages of using LiveData
Work with LiveData objects
Create LiveData objects
Observe LiveData objects

Issue Tracker
Report issues so we can fix bugs.

G+ Community
Provide feedback and discuss ideas with other developers.

Codelab
Sample App
* LiveData is an observable data holder class.
*
* Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the
* lifecycle of other app components, such as activities, fragments, or services
 *
 * LiveData is lifecycle aware, which means it will not invoke the
 * callback unless the activity is in an active state.
 *
 * LiveData will also automatically remove the observer when the
 * fragment receives onDestroy().
 *
 * Caution: A ViewModel must never reference a view, Lifecycle,
 * or any class that may hold a reference to the activity context.
 *
 * The ViewModel remains in memory until the Lifecycle it's scoped to
 * goes away permanently: in the case of an activity, when it finishes,
 * while in the case of a fragment, when it's detached.
 *
 * You usually request a ViewModel the first time the system calls an activity
 * object's onCreate() method.
 *
 * The system may call onCreate() several times throughout the life of an activity,
 * such as when a device screen is rotated.
 *
 * The ViewModel exists from when you first request a ViewModel until the
 * activity is finished and destroyed.
 *
 * ViewModel works with Room and LiveData to replace the loader.
 *
 * */
public class ResultProfileViewModel extends ViewModel {

   private LiveData<List<ResultEntity>> results = null;

   public void init(ResultRepository resultRepository) {
      MutableLiveData<List<ResultEntity>> data = new MutableLiveData<>();
      data.setValue(resultRepository.getResults());
      results = data;
   }

   public LiveData<List<ResultEntity>> getResults() {
      return results;
   }

}
