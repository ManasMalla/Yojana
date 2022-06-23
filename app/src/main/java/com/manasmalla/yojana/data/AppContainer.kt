package com.manasmalla.yojana.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.manasmalla.yojana.data.onboarding.OnBoardingRepository

interface AppContainer {
    val onBoardingRepository: OnBoardingRepository
    val userPreferencesRepository: UserPreferencesRepository
}

class AppContainerImpl(dataStore: DataStore<Preferences>) : AppContainer {
    override val onBoardingRepository: OnBoardingRepository by lazy {
        OnBoardingRepository()
    }

    override val userPreferencesRepository: UserPreferencesRepository by lazy{
        UserPreferencesRepository(dataStore)
    }
}