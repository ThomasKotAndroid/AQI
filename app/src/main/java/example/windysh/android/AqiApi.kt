package example.windysh.android

import retrofit2.Call
import retrofit2.http.GET

interface AqiApi {

    @GET(
        "/feed" +
                "/shanghai"+
                "/?token=get_your_token_from_ https://aqicn.org/data-platform/token/"


    )

    fun fetchContents(): Call<String>

}