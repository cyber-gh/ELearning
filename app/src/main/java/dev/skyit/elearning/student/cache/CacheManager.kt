package dev.skyit.elearning.student.cache

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager


interface CacheManager {
    var isFirstTime: Boolean

    var loginToken: String
    var aswaqDeviceId: Int

    var appLanguage: String // either en or ar

}

class CacheManagerImpl (
    private val context: Context
) : CacheManager, ISharedPreferences {
    override val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    override var isFirstTime: Boolean by PreferenceBool( true)
    override var loginToken: String by PreferenceString("")
    override var aswaqDeviceId: Int by PreferenceInt(-1)
    override var appLanguage: String by PreferenceString("en")
}