package tw.idv.jew.koinsample

import android.app.Application
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // declare modules
            modules(myModule)
        }
    }
}

val myModule = module {
    factory { HoneyLemonade(get(), get()) }
    factory { Honey(get()) }
    factory { Lemon() }
    single { Bee() }
    viewModel { MainViewModel(get()) }
}