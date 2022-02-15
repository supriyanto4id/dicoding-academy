package myid.supri.mynavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import myid.supri.mynavigation.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment() {

    private var _binding :FragmentCategoryBinding? =null
    private val binding get() =_binding!!


    companion object {
        val EXTRA_NAME = "extra_name"
        val EXTRA_STOCK = "extra_stock"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCategoryLifestyle.setOnClickListener{view ->
            //send data with bundle
//            val mBundle = Bundle()
//            mBundle.putString(EXTRA_NAME,"my lyfestyle is simple person with win")
//            mBundle.putLong(EXTRA_STOCK,3)
//            view.findNavController().navigate(R.id.action_categoryFragment_to_detailCategoryFragment,mBundle)

            //send data with Args
           val toDetailCategoryFragment = CategoryFragmentDirections.actionCategoryFragmentToDetailCategoryFragment()
            toDetailCategoryFragment.name="Lifestyle"
            toDetailCategoryFragment.stock =3
            view.findNavController().navigate(toDetailCategoryFragment)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}