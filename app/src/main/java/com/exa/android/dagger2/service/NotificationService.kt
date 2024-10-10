package com.exa.android.dagger2.service

import android.util.Log
import com.exa.android.dagger2.Dagger.d.scope.ActivityScope
import javax.inject.Inject
import javax.inject.Singleton


interface NotificationService{
    fun send(to : String, from: String , msg : String)
}

@ActivityScope
class EmailService @Inject constructor() : NotificationService{
    override fun send(to: String, from: String, msg : String){
        Log.d(TAG, "Email is sent from $to to $from is $msg")
    }
}

class MessageService(private val retryCount : Int) : NotificationService{
    override fun send(to: String, from: String, msg: String) {
        Log.d(TAG, "Messge is send from $to to $from is $msg - $retryCount")
    }
}


/* previously it was just email service which is used to send email but now we have modified it
 to send either email or message based on our needs so create an interface and two services
* */