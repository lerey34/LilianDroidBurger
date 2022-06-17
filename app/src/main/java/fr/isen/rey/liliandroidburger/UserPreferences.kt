package fr.isen.rey.liliandroidburger

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferences(private val context: Context) {
    companion object {
        private val Context.dataStoreeNom: DataStore<Preferences> by preferencesDataStore("userName")
        private val Context.dataStoreePrenom: DataStore<Preferences> by preferencesDataStore("userPrenom")
        val USERNAME_KEY = stringPreferencesKey("user_name")
        val USERPRENOM_KEY = stringPreferencesKey("user_prenom")
    }

    val getuserName: Flow<String?> = context.dataStoreeNom.data
        .map { preferences ->
            preferences[USERNAME_KEY] ?: ""
        }

    suspend fun saveUserName(name: String) {
        context.dataStoreeNom.edit { preferences ->
            preferences[USERNAME_KEY] = name
        }
    }

    val getuserPrenom: Flow<String?> = context.dataStoreePrenom.data
        .map { preferences ->
            preferences[USERPRENOM_KEY] ?: ""
        }

    suspend fun saveUserPrenom(prenom: String) {
        context.dataStoreePrenom.edit { preferences ->
            preferences[USERPRENOM_KEY] = prenom
        }
    }
}