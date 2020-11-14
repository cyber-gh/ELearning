package dev.skyit.elearning.student.ui.home

import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.api.load
import com.google.android.material.chip.Chip
import dev.skyit.elearning.R
import dev.skyit.elearning.databinding.CourseListItemViewBinding
import dev.skyit.elearning.databinding.FragmentHomeBinding
import dev.skyit.elearning.student.repo.CategoryModel
import dev.skyit.elearning.student.repo.CourseModel
import dev.skyit.elearning.student.ui.generic.BaseFragment
import dev.skyit.elearning.utility.LoadingResource
import dev.skyit.elearning.utility.SimpleRecyclerAdapter
import dev.skyit.elearning.utility.errAlert
import dev.skyit.elearning.utility.setItemSpacing
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val vModel: HomeViewModel by viewModel()
    private val binding: FragmentHomeBinding by viewBinding()

    private lateinit var myCoursesAdapter: SimpleRecyclerAdapter<CourseModel, CourseListItemViewBinding>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindUI()
    }

    private fun bindUI() {
        bindMyCoursesList()

        vModel.categoriesLive.observe(viewLifecycleOwner, Observer {
            completeCategories(it)
        })

        vModel.loadData()

        vModel.loadingState.observe(viewLifecycleOwner, Observer {
            if (it is LoadingResource.Error) {
                errAlert(it.errorMessage)
            }
        })


    }

    private fun completeCategories(categories: List<CategoryModel>) {
        categories.forEach {
            val chip = Chip(requireContext())

            chip.setText(it.name)

            binding.categoriesGroup.addView(chip)

        }
    }

    private fun bindMyCoursesList() {
        myCoursesAdapter = SimpleRecyclerAdapter(
            binderCreator = {
                CourseListItemViewBinding.inflate(it)
            }, injectData = { data ->
                if (data.imgLink.isNotEmpty()) {
                    this.courseImage.load(data.imgLink)
                }
                this.courseTitle.text = data.name
                this.courseTeacher.text = data.teacher

                this.ratingView.numStars = 5
                this.ratingView.rating = data.rating.toFloat()

            }, onItemClick = {
                findNavController().navigate(R.id.action_navigation_home_to_courseDetailsFragment)
            }
        )
        binding.recyclerView.adapter = myCoursesAdapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.recyclerView.setItemSpacing()

        vModel.coursesLive.observe(viewLifecycleOwner, Observer {
            myCoursesAdapter.updateData(ArrayList(it))
        })


    }



}