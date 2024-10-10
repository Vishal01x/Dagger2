package com.exa.android.dagger2.Dagger.d.producer

import com.exa.android.dagger2.Dagger.d.qualifier.customAnnotation.NoSQLDatabaseQualifier
import com.exa.android.dagger2.Dagger.d.qualifier.customAnnotation.SQLDatabaseQualifier
import com.exa.android.dagger2.Dagger.d.scope.ActivityScope
import com.exa.android.dagger2.service.AnalyticService
import com.exa.android.dagger2.service.FirebaseRepository
import com.exa.android.dagger2.service.SQLRepository
import com.exa.android.dagger2.service.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
 class UserRepositoryModule {

    @Provides
    @ActivityScope
    @NoSQLDatabaseQualifier
    fun getFirebaseRespository(analyticService: AnalyticService) : UserRepository{
        return FirebaseRepository(analyticService)
    } //-> it is used when we have to create a new object
//    You use @Provides when you need to create a new instance of a class manually inside the method.
//    Dagger will call the method to create and provide the object when needed.

    @Provides
    @ActivityScope // annotate class
    fun getSqlRepository(sqlRepo : SQLRepository) : UserRepository{
        return sqlRepo
    }

//    @Binds
//    @SQLDatabaseQualifier
//    abstract fun getSQLRepository(sqlRepo: SQLRepository) : UserRepository

    // both above are sql repo have are same just code optimisation
    // Binds is used when we don't need to create the object of class we just return the already created
    // object that is passed as an arguments, here this sqlRepo is created by Dagger because we annotate
    // it with Inject means its object is created already and now just pass it no need to create a new object
    // that's why it is abstract fun that binds the obj with class

//    here, Dagger already knows how to create SQLRepository (because of @Inject in the constructor
//    +
//    of SQLRepository), so it will pass the SQLRepository object and bind it to UserRepository.
//    No need to create the object manually. Dagger handles it automatically.

}

// read notification module

