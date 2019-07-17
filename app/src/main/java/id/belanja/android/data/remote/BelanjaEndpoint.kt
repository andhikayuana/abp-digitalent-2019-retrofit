package id.belanja.android.data.remote

import id.belanja.android.data.model.Product
import id.belanja.android.data.remote.response.ProductResponse
import id.belanja.android.data.remote.response.ProductsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Jul, Mon 08 2019 19:40
 **/
interface BelanjaEndpoint {

    @GET("/products")
    fun getAll(): Call<ProductsResponse>

    @POST("/products")
    fun saveData(product: Product): Call<ProductResponse>
}