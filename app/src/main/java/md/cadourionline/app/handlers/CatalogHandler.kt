package md.cadourionline.app.handlers

import android.view.View
import md.cadourionline.app.models.Catalog

interface CatalogHandler {
    fun show(view: View, catalog: Catalog)
}
