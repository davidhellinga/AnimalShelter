package main.kotlin

import main.kotlin.webshop.ISellable

interface IWebshop {
    fun getProducts(): List<ISellable>
    fun addProduct(product: ISellable): Boolean
}