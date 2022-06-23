package com.manasmalla.yojana

import android.app.Application
import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.manasmalla.yojana.data.AppContainer
import com.manasmalla.yojana.data.AppContainerImpl

class YojanaApplication : Application() {

    //Data layer


    private val USER_PREFERENCES_NAME = "user_preferences"

    private val Context.dataStore by preferencesDataStore(
        name = USER_PREFERENCES_NAME
    )

    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()

        appContainer = AppContainerImpl(dataStore)

    }
}

