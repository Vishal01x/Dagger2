package com.exa.android.dagger2.service

import com.exa.android.dagger2.Dagger.d.qualifier.customAnnotation.NoSQLDatabaseQualifier
import javax.inject.Inject
import javax.inject.Named

class UserRegistrationService @Inject constructor(
    @NoSQLDatabaseQualifier private val userRepository: UserRepository,
    @Named("email") private val notificationService: NotificationService // way of calling qualifier here same name is passed as annotate on fun
) {

    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "no-reply@vishal.com", "User Registered")
    }

}