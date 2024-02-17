package com.example.gridlayoutmanagerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gridlayoutmanagerexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val products = listOf (
            Product("Product 1", "Description of the product 1", 124, 89, 25, 4.5, 1),
            Product("Product 2", "Description of the product 2", 389, 256, 35, 4.2, 12),
            Product("Product 3", "Description of the product 3", 456, 315, 40, 4.3, 36),
            Product("Product 4", "Description of the product 4", 108, 59, 45, 4.1, 14),
            Product("Product 5", "Description of the product 5", 359, 280, 35, 4.8, 148),
            Product("Product 6", "Description of the product 6", 710, 515, 25, 4.9, 2438),
            Product("Product 7", "Description of the product 7", 365, 289, 45, 4.6, 1569),
            Product("Product 8", "Description of the product 8", 412, 299, 50, 3.8, 458),
            Product("Product 9", "Description of the product 9", 348, 209, 45, 3.6, 361),
            Product("Product 10", "Description of the product 10", 814, 549, 35, 2.5, 5),
            Product("Product 11", "Description of the product 11", 415, 349, 25, 2.8, 54),
            Product("Product 12", "Description of the product 12", 749, 549, 30, 3.7, 388),
            Product("Product 13", "Description of the product 13", 500, 499, 1, 3.9, 100),
            Product("Product 14", "Description of the product 14", 152, 99, 30, 4.0, 25),
            Product("Product 15", "Description of the product 15", 135, 99, 30, 5.0, 48),
            Product("Product 16", "Description of the product 16", 818, 799, 10, 3.6, 354)
        )

        val layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.layoutManager = layoutManager

        val adapter = ProductAdapter(this)
        binding.recyclerView.adapter = adapter
        adapter.setData(products)
    }
}