package id.belanja.android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.belanja.android.R
import id.belanja.android.data.model.Product
import id.belanja.android.viewholder.MainViewHolder

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Jul, Thu 11 2019 18:37
 **/
class MainAdapter(val data: List<Product>) : RecyclerView.Adapter<MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(data[position])
    }
}