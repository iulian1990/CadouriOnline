package md.cadourionline.app.data

import md.cadourionline.app.models.Product
import retrofit2.http.GET

interface ProductApi {
    @GET("app/promo_products.php")
    suspend fun requestNewProducts(): List<Product>
}