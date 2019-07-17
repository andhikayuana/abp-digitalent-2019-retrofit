package id.belanja.android.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Jul, Thu 11 2019 18:36
 **/
data class Product(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int
) : Serializable