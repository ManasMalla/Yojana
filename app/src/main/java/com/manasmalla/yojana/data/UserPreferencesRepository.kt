package com.manasmalla.yojana.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.map

private object  PreferenceKeys {
    val IS_ONBOARDING_SCREEN_SHOWN = stringPreferencesKey("didShowOnboardingScreen")
    val CURRENT_USER = stringPreferencesKey("didShowOnboardingScreen")
}

class UserPreferencesRepository(private val userPreferencesStore: DataStore<Preferences>) {
    val isOnboardingScreenShown = userPreferencesStore.data.map {
        it[PreferenceKeys.IS_ONBOARDING_SCREEN_SHOWN].toBoolean()
    }
    val currentUser = userPreferencesStore.data.map { it[PreferenceKeys.CURRENT_USER] }
}