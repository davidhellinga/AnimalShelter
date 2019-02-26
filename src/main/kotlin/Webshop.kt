package main.kotlin

import main.kotlin.webshop.ISellable

class Webshop : IWebshop {
    private var products: MutableList<ISellable> = ArrayList()

    override fun getProducts(): List<ISellable> = products

    override fun addProduct(product: ISellable): Boolean = products.add(product)



}