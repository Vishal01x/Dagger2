package com.exa.android.dagger2.service

import android.util.Log
import javax.inject.Inject

interface UserRepository{
    fun saveUser(email : String, password: String)
}

// either annotate here or in module both are correct for singleton
class SQLRepository @Inject constructor( val analyticService: AnalyticService) : UserRepository{
    override fun saveUser(email : String, password : String ){
        Log.d(TAG,"User saved to SQL : $email->$password")
        analyticService.trackEvent("Save User", "CREATE")    }
}

class FirebaseRepository( val analyticService: AnalyticService): UserRepository{
    override fun saveUser(email : String, password : String ){
        Log.d(TAG,"User saved to Firebase : $email->$password")
        analyticService.trackEvent("Save User", "CREATE")
    }// here the analyticService object is passed as an arguments, now the benefits of DI that we just
    // no need to worry about the object creation and passing we just use them their creation is responsibility of Dagger
}

/* previously it was just userRepository to save user in database but now we modified it to
two database SQL, Firebase as per our needs
* */