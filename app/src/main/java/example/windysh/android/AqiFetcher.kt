package example.windysh.android

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class AqiFetcher {

    private val aqiApi: AqiApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.waqi.info")

            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        aqiApi = retrofit.create(AqiApi::class.java)
    }

    fun fetchContents(): LiveData<String> {
        var responseLiveData: MutableLiveData<String> = MutableLiveData()
        val aqiRequest: Call<String> = aqiApi.fetchContents()
        aqiRequest.enqueue(object : Callback<String> {

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e("AQI", "Failed to fetch photos", t)
            }

            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                Log.d("AQI", "Response received")
                if(response.isSuccessful){

                    responseLiveData.value =response.body()
            }}


        })

        return responseLiveData
    }
}

