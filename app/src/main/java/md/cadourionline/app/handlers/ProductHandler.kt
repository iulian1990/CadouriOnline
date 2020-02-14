package md.cadourionline.app.handlers

import android.view.View
import md.cadourionline.app.models.Product

interface ProductHandler {
    fun show(view: View, product: Product)
}
