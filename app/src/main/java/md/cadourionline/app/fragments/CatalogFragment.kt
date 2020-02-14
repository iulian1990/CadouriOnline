package md.cadourionline.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import md.cadourionline.app.adapters.CatalogAdapter
import md.cadourionline.app.adapters.ProductAdapter
import md.cadourionline.app.databinding.FragmentCatalogBinding
import md.cadourionline.app.models.CatalogType.VERTICAL
import md.cadourionline.app.utilities.InjectorUtils
import md.cadourionline.app.viewmodels.CatalogViewModel

class CatalogFragment : Fragment() {

    lateinit var binding: FragmentCatalogBinding

    private val viewModel: CatalogViewModel by activityViewModels {
        InjectorUtils.provideCatalogViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatalogBinding.inflate(inflater, container, false)

        binding.catalogRecyclerView.adapter = CatalogAdapter(VERTICAL).also { adapter ->

            viewModel.catalogs.observe(viewLifecycleOwner) { catalogs ->
                adapter.submitList(catalogs)
            }

        }

        return binding.root
    }
}