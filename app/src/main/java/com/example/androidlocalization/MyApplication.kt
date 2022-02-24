package com.example.androidlocalization

import android.app.Application
import com.example.androidlocalization.manager.LocaleManager

class MyApplication:Application() {

    companion object{
        val TAG = MyApplication::class.java.simpleName
        var instance:MyApplication? = null
        var localeManager:LocaleManager? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        localeManager = LocaleManager(this)
        localeManager!!.setLocale(this)
    }

}