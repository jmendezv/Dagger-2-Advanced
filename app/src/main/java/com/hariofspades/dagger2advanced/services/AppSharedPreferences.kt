package com.hariofspades.dagger2advanced.services

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class AppSharedPreferences(context: Context) {

    private val sharedPreferences: SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

    public fun storeString(key: String, value: String): Unit {
        sharedPreferences.edit().putString(key, value).apply()
    }

    public fun restoreString(key: String): String =
            sharedPreferences.getString(key, "@null")
}