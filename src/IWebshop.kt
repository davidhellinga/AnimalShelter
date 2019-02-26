import webshop.ISellable

interface IWebshop {
    fun getProducts(): List<ISellable>
    fun addProduct(product: ISellable): Boolean
}