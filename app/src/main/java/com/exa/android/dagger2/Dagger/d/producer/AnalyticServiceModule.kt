package com.exa.android.dagger2.Dagger.d.producer

import com.exa.android.dagger2.service.AnalyticService
import com.exa.android.dagger2.service.MixPanel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AnalyticServiceModule {

    @Provides
    @Singleton
    fun getMixPanel() : AnalyticService{
        return MixPanel()
    }

}