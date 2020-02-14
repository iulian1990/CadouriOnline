package md.cadourionline.app.viewmodels

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import md.cadourionline.app.data.ProductRepository
import md.cadourionline.app.handlers.ProductHandler
import md.cadourionline.app.models.Product

class ProductViewModel(private val repository: ProductRepository) : ViewModel(), ProductHandler {

    override fun show(view: View, product: Product) {
    }

    val newProducts = liveData(Dispatchers.IO) {
        emit(repository.getNewProducts())
    }
}