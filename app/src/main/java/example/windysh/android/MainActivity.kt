package example.windysh.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



       setContentView(R.layout.activity_main)
        val textView :TextView = findViewById(R.id.myTextView)


        val aqiLiveData: LiveData<String> = AqiFetcher().fetchContents()
        aqiLiveData.observe(
            this,
            Observer { str ->
                Log.d("AQIResponseInMainActivity", "Response received: $str")

                textView.text = str
            })
    }


}