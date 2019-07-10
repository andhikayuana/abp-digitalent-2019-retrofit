package id.belanja.android.data.remote

import id.belanja.android.data.remote.response.ProductsResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Jul, Mon 08 2019 19:40
 **/
interface BelanjaEndpoint {

    @GET("/products")
    fun getAll(): Call<ProductsResponse>
}