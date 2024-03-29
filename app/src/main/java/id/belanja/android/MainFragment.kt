package id.belanja.android


import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.belanja.android.adapter.MainAdapter
import id.belanja.android.data.model.Product
import id.belanja.android.data.remote.BelanjaApi
import id.belanja.android.data.remote.response.ProductsResponse
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment() {

    companion object {
        const val TAG = "MainFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        BelanjaApi.service.getAll().enqueue(object : Callback<ProductsResponse> {
            override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
                d(TAG, t.message)
            }

            override fun onResponse(call: Call<ProductsResponse>, response: Response<ProductsResponse>) {

                if (response.isSuccessful) {
                    response.body().let {
                        setupAdapter(it!!.data)
                    }
                } else {
                    d(TAG, response.errorBody().toString())
                }
            }
        })
    }

    private fun setupAdapter(data: List<ProductsResponse.Data>) {
        val result = data.map {
            with(it) {
                Product(id, image, name, price)
            }
        }
        val mainAdapter = MainAdapter(result)
        rvProducts.apply {
            adapter = mainAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
        }
    }

}
