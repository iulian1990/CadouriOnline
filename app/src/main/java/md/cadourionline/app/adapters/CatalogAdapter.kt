package md.cadourionline.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import md.cadourionline.app.BR
import md.cadourionline.app.R
import md.cadourionline.app.models.Catalog
import md.cadourionline.app.models.CatalogType
import md.cadourionline.app.models.CatalogType.VERTICAL

class CatalogAdapter(private val type: CatalogType) :
    ListAdapter<Catalog, CatalogAdapter.CatalogViewHolder>(CatalogDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        val layoutId = if (type == VERTICAL)
            R.layout.item_catalog_vertical
        else
            R.layout.item_catalog_horizontal

        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, layoutId, parent, false)

        return CatalogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CatalogViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(catalog: Catalog) {

            // variableId may be different for two cases
            if (type == VERTICAL) {
                binding.setVariable(BR.catalog, catalog)
            } else {
                binding.setVariable(BR.catalog, catalog)
            }

            binding.executePendingBindings()
        }
    }
}

object CatalogDiff : DiffUtil.ItemCallback<Catalog>() {
    override fun areItemsTheSame(oldItem: Catalog, newItem: Catalog): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Catalog, newItem: Catalog): Boolean =
        oldItem == newItem
}

