package tw.idv.jew.koinsample

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // declare used Android context
            androidContext(this@MyApplication)
            // declare modules
            modules(myModule)
        }
    }
}

val myModule = module {
    factory { HoneyLemonade(get(), get()) }
    factory(named("Lyme")) { HoneyLemonade(get(), get(named("Lyme"))) }

    factory { Honey(get()) }

//    factory(named("Lemon")) { Lemon() }
    factory { Lemon() }

    //    factory(named("Lyme")) { Lyme() as Lemon }
    factory<Lemon>(named("Lyme")) { Lyme() }

    single { Bee() }
//    viewModel { MainViewModel(get()) }
    viewModel { MainViewModel() }
}