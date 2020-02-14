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
import md.cadourionline.app.databinding.FragmentHomeBinding
import md.cadourionline.app.models.CatalogType.HORIZONTAL
import md.cadourionline.app.utilities.InjectorUtils
import md.cadourionline.app.viewmodels.CatalogViewModel
import md.cadourionline.app.viewmodels.ProductViewModel

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    private val catalogViewModel: CatalogViewModel by activityViewModels {
        InjectorUtils.provideCatalogViewModelFactory()
    }

    private val productViewModel: ProductViewModel by activityViewModels {
        InjectorUtils.provideProductViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.catalogRecyclerView.adapter = CatalogAdapter(HORIZONTAL).also { adapter ->

            catalogViewModel.catalogs.observe(viewLifecycleOwner) { catalogs ->
                adapter.submitList(catalogs)
            }
        }

        binding.newProductsRecyclerView.adapter = ProductAdapter().also { adapter ->

            productViewModel.newProducts.observe(viewLifecycleOwner) { newProducts ->
                adapter.submitList(newProducts)
            }
        }

        return binding.root
    }
}