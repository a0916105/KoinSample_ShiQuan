package tw.idv.jew.koinsample

import androidx.lifecycle.ViewModel

class MainViewModel(private val honeyLemonade: HoneyLemonade) : ViewModel() {

    fun check() {
        println(honeyLemonade)
    }
}