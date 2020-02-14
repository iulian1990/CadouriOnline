package md.cadourionline.app.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import md.cadourionline.app.R
import md.cadourionline.app.databinding.FragmentProfileBinding
import md.cadourionline.app.databinding.FragmentSubscribeBinding

class SubscribeFragment : Fragment() {

    lateinit var binding: FragmentSubscribeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSubscribeBinding.inflate(inflater, container, false)

        return binding.root
    }
}
