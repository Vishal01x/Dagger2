package com.exa.android.dagger2.Dagger.d.connector

import com.exa.android.dagger2.Dagger.d.producer.NotificationServiceModule
import com.exa.android.dagger2.Dagger.d.producer.UserRepositoryModule
import com.exa.android.dagger2.Dagger.d.scope.ActivityScope
import com.exa.android.dagger2.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@ActivityScope
@Subcomponent(/*dependencies = [AppComponent::class],*/ modules = [UserRepositoryModule::class, NotificationServiceModule::class]) // read below
interface UserRegistrationComponent1 {
//    fun getUserRegistrationService() : UserRegistrationService
//    fun getEmailService() : EmailService    // -> Constructor Injection



    //@Component.Factory
    @Subcomponent.Factory
    interface Factory {
        //fun create(@BindsInstance retryCount: Int, appComponent: AppComponent): UserRegistrationComponent1 -> for component dependency and factory
        fun create(@BindsInstance retryCount: Int): UserRegistrationComponent1 // -> for subcomponent factory
    }

    fun inject(mainActivity: MainActivity) // field injection here we directly pass the consumer class
}

/*
 this is an interface that acts as a connector between consumer and producer.
 here, we request service from connector and describe the way to create object by using @Inject constructor
 annotation on class, it's like we are showing it the path for creating object after rebuild projects
 we get all. But how we get so by using this annotation a Dagger class is generated where the code for
 creating and passing object is used you can see java generated for better Idea.

 So whatever object we demands we need to implement a path to create obj by annotating it with @Inject


 @Component(modules = [UserRepositoryModule::class, NotificationServiceModule::class]) ->
 this is used to use modules and providers ie we tell component to create object by using this modules
 */