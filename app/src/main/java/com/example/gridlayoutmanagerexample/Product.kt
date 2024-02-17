package com.example.gridlayoutmanagerexample

data class Product(
    val title: String,
    val subtitle: String,
    val oldPrice: Int,
    val price: Int,
    val discount: Int,
    val rating: Double,
    val countReviews: Int
) {
    var isFavorite: Boolean = false
}

