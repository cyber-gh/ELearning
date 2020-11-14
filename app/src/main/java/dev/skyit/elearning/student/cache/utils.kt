package dev.skyit.elearning.student.cache

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


interface ISharedPreferences {
    val pref: SharedPreferences
}

interface CustomStringConvertible<T> {
    fun fromString(str: String) : T?
    fun toString(data: T) : String
}

class PreferenceString(
    private val defaultValue: String = ""
) : ReadWriteProperty<ISharedPreferences, String> {
    override fun getValue(thisRef: ISharedPreferences, property: KProperty<*>): String {
        return thisRef.pref.getString(property.name, defaultValue) ?: defaultValue
    }

    override fun setValue(thisRef: ISharedPreferences, property: KProperty<*>, value: String) {
        thisRef.pref.edit().putString(property.name, value).apply()
    }

}

class PreferenceInt(
    private val defaultValue: Int = 0
) : ReadWriteProperty<ISharedPreferences, Int> {
    override fun getValue(thisRef: ISharedPreferences, property: KProperty<*>): Int {
        return thisRef.pref.getInt(property.name, defaultValue)
    }

    override fun setValue(thisRef: ISharedPreferences, property: KProperty<*>, value: Int) {
        thisRef.pref.edit().putInt(property.name, value).apply()
    }

}

class PreferenceBool(
    private val defaultValue: Boolean = false
) : ReadWriteProperty<ISharedPreferences, Boolean> {
    override fun getValue(thisRef: ISharedPreferences, property: KProperty<*>): Boolean {
        return thisRef.pref.getBoolean(property.name, defaultValue)
    }

    override fun setValue(thisRef: ISharedPreferences, property: KProperty<*>, value: Boolean) {
        thisRef.pref.edit().putBoolean(property.name, value).apply()
    }

}

class PreferenceProperty<T>(
    private val key: String,
    private val defaultValue: T,
    private val converter: CustomStringConvertible<T>
) : ReadWriteProperty<ISharedPreferences, T> {
    override fun getValue(thisRef: ISharedPreferences, property: KProperty<*>): T {
        return converter.fromString(thisRef.pref.getString(key, "")!!) ?: defaultValue
    }

    override fun setValue(thisRef: ISharedPreferences, property: KProperty<*>, value: T) {
        thisRef.pref.edit().putString(key, converter.toString(value)).apply()
    }

}