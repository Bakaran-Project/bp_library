package com.bp.library

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import dagger.hilt.android.HiltAndroidApp

/**
 * author Trian Damai
 * created_at 21/03/22 - 12.08
 * site https://trian.app
 */
@HiltAndroidApp
class MainApplication :Application(){
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()

    }
}