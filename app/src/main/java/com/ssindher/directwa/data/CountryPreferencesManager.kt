package com.ssindher.directwa.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class CountryPreferencesManager(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
        val SELECTED_COUNTRY_KEY = stringPreferencesKey("selected_country")
    }

    val selectedCountryCode: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[SELECTED_COUNTRY_KEY]
        }.catch { exception ->
            exception.printStackTrace()
            emit(null)
        }

    suspend fun saveSelectedCountryCode(country: String) {
        context.dataStore.edit { preferences ->
            preferences[SELECTED_COUNTRY_KEY] = country
        }
    }
}
