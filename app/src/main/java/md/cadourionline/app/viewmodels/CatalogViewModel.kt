package md.cadourionline.app.viewmodels

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import md.cadourionline.app.data.CatalogRepository
import md.cadourionline.app.handlers.CatalogHandler
import md.cadourionline.app.models.Catalog

class CatalogViewModel(private val repository: CatalogRepository) : ViewModel(), CatalogHandler {

    override fun show(view: View, catalog: Catalog) {
        val direction = HomeFragmentDirections.actionNavigationHomeToRecipeDetailFragment(recipeId)
        view.findNavController().navigate(direction)

    }

    val catalogs = liveData(Dispatchers.IO) {
        emit(repository.getCatalogs())
    }
}