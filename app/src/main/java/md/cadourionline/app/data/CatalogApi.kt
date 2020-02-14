package md.cadourionline.app.data

import md.cadourionline.app.models.Catalog
import retrofit2.http.GET

interface CatalogApi {
    @GET("app/categories.php")
    suspend fun requestCatalogs(): List<Catalog>
}