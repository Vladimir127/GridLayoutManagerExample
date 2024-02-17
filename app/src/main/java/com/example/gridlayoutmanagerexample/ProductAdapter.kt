package com.example.gridlayoutmanagerexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gridlayoutmanagerexample.databinding.ItemProductBinding

/**
 * Адаптер для списка товаров. Используется в разделах "Каталог" и "Избранное"
 */
class ProductAdapter(val context: Context) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var originalProducts: List<Product> = emptyList()
    private var currentProducts: List<Product> = emptyList()

    fun setData(products: List<Product>) {
        this.originalProducts = products
        this.currentProducts = products
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_product, parent, false
            )
        )
    }

    override fun getItemCount() = currentProducts.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = currentProducts[position]

        holder.bind(product)
    }

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemProductBinding.bind(view)

        private lateinit var product: Product

        fun bind(product: Product) {
            this.product = product

            initFavoriteButton()

            binding.imageView.setImageResource(R.drawable.cream)
            binding.titleTextView.text = product.title
            binding.subtitleTextView.text = product.subtitle
            binding.oldPriceTextView.text = product.oldPrice.toString()
            binding.priceTextView.text = product.price.toString()
            binding.discountTextView.text =
                context.resources.getString(R.string.discount, product.discount)

            binding.ratingTextView.text = product.rating.toString()
            binding.countTextView.text =
                context.resources.getString(R.string.feedback_count, product.countReviews)
        }

        private fun initFavoriteButton() {
            setFavoriteButtonIcon()

            binding.addToFavoriteButton.setOnClickListener {
                product.isFavorite = !product.isFavorite
                setFavoriteButtonIcon()
            }
        }

        private fun setFavoriteButtonIcon() {
            if (product.isFavorite) {
                binding.addToFavoriteButton.setImageResource(R.drawable.ic_heart_filled)
            } else {
                binding.addToFavoriteButton.setImageResource(R.drawable.ic_heart_stroke)
            }
        }
    }
}