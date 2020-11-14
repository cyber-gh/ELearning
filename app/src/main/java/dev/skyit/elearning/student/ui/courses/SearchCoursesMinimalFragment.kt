package dev.skyit.elearning.student.ui.courses

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.api.load
import coil.transform.CircleCropTransformation
import com.soywiz.klock.DateTime
import dev.skyit.elearning.R
import dev.skyit.elearning.databinding.FragmentSearchCourseBinding
import dev.skyit.elearning.databinding.SearchItemListBindingBinding
import dev.skyit.elearning.student.repo.CourseModel
import dev.skyit.elearning.student.ui.generic.BaseFragment
import dev.skyit.elearning.utility.SimpleRecyclerAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchCoursesMinimalFragment: BaseFragment(R.layout.fragment_search_course) {

    private val binding: FragmentSearchCourseBinding by viewBinding()

    private val vModel: SearchCoursesMinimalViewModel by viewModel()
    private lateinit var adapter: SimpleRecyclerAdapter<CourseModel, SearchItemListBindingBinding>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.searchEditText.requestFocus()

        val imm: InputMethodManager? = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.showSoftInput(binding.searchEditText, InputMethodManager.SHOW_IMPLICIT)

        binding.searchEditText.addTextChangedListener {
            val str = it?.toString() ?: return@addTextChangedListener
            vModel.filter(str)

        }

        adapter = SimpleRecyclerAdapter(binderCreator =  { inflater ->
            SearchItemListBindingBinding.inflate(inflater)
        },injectData =  { data ->

            itemTitle.text = data.name
            if (data.imgLink.isNotEmpty()) {
                itemImg.load(data.imgLink)
            }
        })

        binding.recyclerView2.adapter = adapter
        binding.recyclerView2.layoutManager = GridLayoutManager(requireContext(), 1)

        vModel.filteredCourses.observe(viewLifecycleOwner, Observer {
            adapter.updateData(ArrayList(it))
        })

    }

}