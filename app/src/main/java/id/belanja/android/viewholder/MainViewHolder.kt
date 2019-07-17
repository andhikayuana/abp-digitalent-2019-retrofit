package id.belanja.android.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.belanja.android.data.model.Product
import kotlinx.android.synthetic.main.item_product.view.*

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(product: Product) {
        with(itemView) {
            tvProductName.text = product.name
            tvProductPrice.text = product.price.toString()
            Glide.with(this).load(product.image).into(ivProduct)
            setOnClickListener {
                //todo
                //
            }
        }
    }

}
