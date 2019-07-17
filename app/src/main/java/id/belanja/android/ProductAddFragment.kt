package id.belanja.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.belanja.android.data.model.Product
import id.belanja.android.data.remote.BelanjaApi
import id.belanja.android.data.remote.response.ProductResponse
import id.belanja.android.data.remote.response.ProductsResponse
import kotlinx.android.synthetic.main.fragment_product_add.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductAddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val name = etProductName.text.toString()
        val price = etProductPrice.text.toString()
        val image = etProductImage.text.toString()

        val product = Product(0, name, image, price.toInt())

        btnSave.setOnClickListener {
            saveData(product)
        }
    }

    private fun saveData(product: Product) {
        BelanjaApi.service.saveData(product).enqueue(object : Callback<ProductResponse> {

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {

            }

        })
    }
}
