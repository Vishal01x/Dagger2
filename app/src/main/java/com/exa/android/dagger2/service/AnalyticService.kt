package com.exa.android.dagger2.service

import android.util.Log

interface AnalyticService {
    fun trackEvent(eventName : String, eventType : String)
}

class MixPanel : AnalyticService{
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d(TAG, "MixPanel - $eventName - $eventType")
    }
}

class FirebasePanel : AnalyticService{
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d(TAG, "FirebasePanel - $eventName - $eventType")
    }
}