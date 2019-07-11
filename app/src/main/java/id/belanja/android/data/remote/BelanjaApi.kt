package id.belanja.android.data.remote

import id.belanja.android.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Jul, Mon 08 2019 19:39
 **/
object BelanjaApi {

    private fun logging(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
        else HttpLoggingInterceptor.Level.NONE
        return logging
    }

    private val client: OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(logging())
            .build()

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service: BelanjaEndpoint = createRetrofit().create(BelanjaEndpoint::class.java)
}