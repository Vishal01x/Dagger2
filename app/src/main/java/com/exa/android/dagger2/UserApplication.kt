package com.exa.android.dagger2

import android.app.Application
import com.exa.android.dagger2.Dagger.d.connector.AppComponent
import com.exa.android.dagger2.Dagger.d.connector.DaggerAppComponent
import com.exa.android.dagger2.Dagger.d.connector.DaggerUserRegistrationComponent1
import com.exa.android.dagger2.Dagger.d.connector.UserRegistrationComponent1

class UserApplication :Application(){

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}