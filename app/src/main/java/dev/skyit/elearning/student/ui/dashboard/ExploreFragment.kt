package dev.skyit.elearning.student.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dev.skyit.elearning.R
import dev.skyit.elearning.databinding.CategoryListItemViewBinding
import dev.skyit.elearning.databinding.FragmentExploreBinding
import dev.skyit.elearning.student.ui.generic.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExploreFragment : BaseFragment(R.layout.fragment_explore) {

    private val vModel: ExploreViewModel by viewModel()
    private val binding: FragmentExploreBinding by viewBinding()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindUI()
    }

    private fun bindUI() {

        binding.searchTextInput.editText?.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_explore_to_search_courses_minimal)
        }

        binding.searchWrapper.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_explore_to_search_courses_minimal)
        }


        vModel.categoriesLive.observe(viewLifecycleOwner, Observer {
            it.forEach {
                val item = CategoryListItemViewBinding.inflate(layoutInflater)
                item.categoryTitle.text = it.name

                binding.categoriesList.addView(item.root)
            }
        })

        vModel.loadData()
    }
}