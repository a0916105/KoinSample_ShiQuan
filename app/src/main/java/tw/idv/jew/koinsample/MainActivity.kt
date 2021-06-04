package tw.idv.jew.koinsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val honeyLemonade by inject<HoneyLemonade>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val honeyLemonade2 = get<HoneyLemonade>()
        val honeyLemonade3: HoneyLemonade = get()

        textView.text = honeyLemonade.toString() + "\n" +
                        honeyLemonade2.toString() + "\n" +
                        honeyLemonade3.toString()
    }
}