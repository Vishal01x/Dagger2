package com.exa.android.dagger2.Dagger.d.producer

import com.exa.android.dagger2.Dagger.d.scope.ActivityScope
import com.exa.android.dagger2.service.EmailService
import com.exa.android.dagger2.service.MessageService
import com.exa.android.dagger2.service.NotificationService
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
  class NotificationServiceModule() {

    @Named("message")
    @Provides
    @ActivityScope// we can't annotate its class with singleton because its object is created here
    fun getMessageService(retryCount : Int) : NotificationService{
        return MessageService(retryCount)
    }

    @Named("email")
    @Provides // we can use singleton here also but preffered to use in such case when we can't have its class acces else annotate class with singlton
     fun getEmailService(emailService: EmailService) : NotificationService {
         return emailService
     }// -> we use binds because it's object is already created by dagger for more info check repoModule
}

/*
This code demonstrates how to configure dependency injection with Dagger for classes implementing the
`NotificationService` interface. Dagger modules are used to provide or bind specific implementations
of the `NotificationService` interface.

- **`NotificationServiceModule`**: This module is responsible for using the `@Binds` annotation to bind
the `EmailService` class to the `NotificationService` interface. The `@Binds` method is abstract, and
Dagger will automatically inject the already-created instance of `EmailService`.

- **`MessageServiceModule`**: This module provides an instance of the `MessageService` class using the
`@Provides` method. It creates the object of `MessageService` and returns it as a `NotificationService`.
Since `@Provides` requires a method body (non-abstract), it is placed in a separate module.

### Workflow Explanation:
1. When an object of `NotificationService` is requested, Dagger checks for available modules.
2. For `EmailService`, Dagger uses the `@Binds` method in `NotificationServiceModule`, which doesn't
create a new object but binds an existing one to the interface.
3. For `MessageService`, the `MessageServiceModule` is used to create and provide the object using the
`@Provides` method.
4. This modular approach makes it easy to switch between implementations (e.g., `EmailService` vs
`MessageService`) without altering much code, providing flexibility and decoupling.

### `@Binds` vs `@Provides`:
- **`@Binds`**: Used when you already have an object created by Dagger (usually with `@Inject`), and you
just need to bind it to an interface.
- **`@Provides`**: Used when you need to create a new object manually and return it.

This modular setup is especially helpful in scenarios where you have multiple implementations of an
interface and need to switch between them dynamically.
*/
