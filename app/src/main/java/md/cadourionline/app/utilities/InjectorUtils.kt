package md.cadourionline.app.utilities

import md.cadourionline.app.data.*
import md.cadourionline.app.viewmodels.CatalogViewModelFactory
import md.cadourionline.app.viewmodels.ProductViewModelFactory

object InjectorUtils {

    private fun getCatalogRepository(): CatalogRepository {
        val api = RetrofitClient.getInstance().create(CatalogApi::class.java)
        return CatalogRepository.getInstance(api)
    }

    private fun getProductRepository(): ProductRepository {
        val api = RetrofitClient.getInstance().create(ProductApi::class.java)
        return ProductRepository.getInstance(api)
    }

    fun provideCatalogViewModelFactory(): CatalogViewModelFactory {
        val repository = getCatalogRepository()
        return CatalogViewModelFactory(repository)
    }

    fun provideProductViewModelFactory(): ProductViewModelFactory {
        val repository = getProductRepository()
        return ProductViewModelFactory(repository)
    }
}