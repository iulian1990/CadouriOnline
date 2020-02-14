package md.cadourionline.app.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import md.cadourionline.app.R
import md.cadourionline.app.databinding.FragmentSubscribeBinding
import md.cadourionline.app.databinding.FragmentSupportBinding

class SupportFragment : Fragment() {

    lateinit var binding: FragmentSupportBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSupportBinding.inflate(inflater, container, false)

        return binding.root
    }
}
