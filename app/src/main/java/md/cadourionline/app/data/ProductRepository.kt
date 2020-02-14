package md.cadourionline.app.data

class ProductRepository private constructor(private val api: ProductApi) {

    suspend fun getNewProducts() = api.requestNewProducts()

    companion object {

        @Volatile
        private var INSTANCE: ProductRepository? = null

        fun getInstance(api: ProductApi): ProductRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: ProductRepository(api).also { INSTANCE = it }
            }
    }
}