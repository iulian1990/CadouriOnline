package md.cadourionline.app.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {

    companion object {

        @Volatile
        private var INSTANCE: Retrofit? = null

        fun getInstance(): Retrofit =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildRetrofit().also { INSTANCE = it }
            }

        private fun buildRetrofit() =
            Retrofit.Builder()
                .baseUrl("http://gifteg.webpower.cf/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}