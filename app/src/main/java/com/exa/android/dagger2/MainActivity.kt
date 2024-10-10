package com.exa.android.dagger2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import com.exa.android.dagger2.service.UserRegistrationService
import com.exa.android.dagger2.ui.theme.Dagger2Theme
import javax.inject.Inject


class MainActivity : ComponentActivity() {

    @Inject // -> this inject showing to inject all fields into this
    // so we have two inject one showing to create objects and other to inject fields
    lateinit var userRegistrationService: UserRegistrationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Dagger component and perform injection
//        val component = DaggerUserRegistrationComponent1.builder().build()
//        component.inject(this)  // This will inject the dependencies into this activity
        // above is used until we don't have to pass in parameter at runtime

//        val component = DaggerUserRegistrationComponent1.builder()
//            .notificationServiceModule(NotificationServiceModule(3))
//            .build()
        // those modules that takes an arguments at runtime such modules are initialised manually

        // COMPONENT FACTORY
       //  val component = DaggerUserRegistrationComponent1.factory().create(3)

        //val component = (application as UserApplication).userRegistrationComponent // -> achieving true singleton and scoped component with application
        //component.inject(this)

        val appComponent = (application as UserApplication).appComponent
        //val userRegistrationComponent = DaggerUserRegistrationComponent1.factory().create(3, appComponent) -> for using component with dependencies
        //val userRegistrationComponent = appComponent.getUserRegistrationComponent() // -> without factory direct

        val userRegistrationComponent = appComponent.getUserRegistrationComponentFactory().create(3)
        userRegistrationComponent.inject(this)

        enableEdgeToEdge()
        setContent {
            Dagger2Theme {
                App(userRegistrationService)
            }
        }
    }
}

@Composable
fun App(userRegistrationService: UserRegistrationService, modifier: Modifier = Modifier) {
    //ManualDI()
    //ConstructonInjection()

    FieldInjection(userRegistrationService)  // Pass the service to the FieldInjection Composable
}

/*
@Composable
fun ManualDI(modifier: Modifier = Modifier) {

    val emailService = EmailService()
    val userRepository = UserRepository()

    val userRegistrationService = UserRegistrationService(userRepository,emailService) // Construction Injection

    userRegistrationService.createUser("vishal@gmail.com", "454585254")
    userRegistrationService.email("Vishal", "Tanya", "Feeling Well")

    // here we create obj manually and passed them in class but if we need to have a lot in such condition
    // we use Dagger2/ Hilt for injection
}

@Composable
fun ConstructonInjection() {

    val component = DaggerUserRegistrationComponent1.builder().build() // this is generated class using dagger & annotation

    val userRegistrationService = component.getUserRegistrationService() // we are using fun that are described in interface
    val emailService = component.getEmailService()
    // background it is creating the obj as we passed in manual DI and we directly use it


    userRegistrationService.createUser("vishal@gmail.com", "454585254")
    userRegistrationService.email("Vishal", "Tanya", "Feeling Well")
}
*/

@Composable
fun FieldInjection(userRegistrationService: UserRegistrationService) {
//    val component = DaggerUserRegistrationComponent1.builder().build()
//    component.inject(this@MainActivity) -> this way we have an error because compose doesn't work on lifecycle
    // so we instantiate it above and passed the userregistration as an argument

    // Now you can use the injected service
    userRegistrationService.registerUser("vishal@gmail.com", "66554")
}