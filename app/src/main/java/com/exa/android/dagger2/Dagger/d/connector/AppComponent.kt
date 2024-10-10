package com.exa.android.dagger2.Dagger.d.connector

import com.exa.android.dagger2.Dagger.d.producer.AnalyticServiceModule
import com.exa.android.dagger2.service.AnalyticService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AnalyticServiceModule::class])
interface AppComponent {
   // fun getAnalyticsService() : AnalyticService

   // fun getUserRegistrationComponent () : UserRegistrationComponent1 // -> without factory

    fun getUserRegistrationComponentFactory() : UserRegistrationComponent1.Factory
}