package md.cadourionline.app.data

class CatalogRepository private constructor(private val api: CatalogApi) {

    suspend fun getCatalogs() = api.requestCatalogs()

    companion object {

        @Volatile
        private var INSTANCE: CatalogRepository? = null

        fun getInstance(api: CatalogApi): CatalogRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: CatalogRepository(api).also { INSTANCE = it }
            }
    }
}