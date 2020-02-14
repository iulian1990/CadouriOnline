package md.cadourionline.app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import md.cadourionline.app.data.CatalogRepository

class CatalogViewModelFactory(private val repository: CatalogRepository) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CatalogViewModel(repository) as T
    }
}
