package tw.idv.jew.koinsample

import androidx.lifecycle.ViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

//class MainViewModel(private val honeyLemonade: HoneyLemonade) : ViewModel() {
class MainViewModel : ViewModel(), KoinComponent {
    /*fun check() {
        println(honeyLemonade)
    }*/

    private val honeyLemonade: HoneyLemonade by inject()

    fun doSomething(): String {
        return honeyLemonade.toString()
    }
}