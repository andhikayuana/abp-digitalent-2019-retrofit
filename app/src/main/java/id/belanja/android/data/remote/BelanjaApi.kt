package id.belanja.android.data.remote

import id.belanja.android.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Jul, Mon 08 2019 19:39
 **/
object BelanjaApi {

//    private val interceptor = Interceptor {chain ->
//
//        val request = chain.request()
//            .newBuilder()
//            .addHeader("Authorization", "Bearer TOKENHERE")
//            .build()
//
//        return@Interceptor chain.proceed(request)
//    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
//            .client(interceptor)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service: BelanjaEndpoint = createRetrofit().create(BelanjaEndpoint::class.java)
}