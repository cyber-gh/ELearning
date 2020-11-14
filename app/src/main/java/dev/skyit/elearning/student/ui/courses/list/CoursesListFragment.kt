package dev.skyit.elearning.student.ui.courses.list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.api.load
import dev.skyit.elearning.R
import dev.skyit.elearning.databinding.CourseListItemViewBinding
import dev.skyit.elearning.databinding.FragmentCoursesListBinding
import dev.skyit.elearning.student.repo.CourseModel
import dev.skyit.elearning.student.ui.generic.BaseFragment
import dev.skyit.elearning.utility.SimpleRecyclerAdapter
import dev.skyit.elearning.utility.setItemSpacing
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CoursesListFragment : BaseFragment(R.layout.fragment_courses_list) {
    private val args: CoursesListFragmentArgs by navArgs()
    private val vModel: CoursesListViewModel by viewModel {
        parametersOf(null,args.categoryId )
    }

    private val binding: FragmentCoursesListBinding by viewBinding()

    private lateinit var adapter: SimpleRecyclerAdapter<CourseModel, CourseListItemViewBinding>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindMyCoursesList()

        vModel.loadData()

    }

    private fun bindMyCoursesList() {
        adapter = SimpleRecyclerAdapter(
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
            this.ratingView.isEnabled = false
            this.ratingView.setOnClickListener(null)

        }, onItemClick = {
            findNavController().navigate(
                    CoursesListFragmentDirections.actionCoursesListFragmentToCourseDetailsFragment(it.course.id!!)
            )
        }
        )
        binding.recyclerView3.adapter = adapter
        binding.recyclerView3.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.recyclerView3.setItemSpacing()

        vModel.courses.observe(viewLifecycleOwner, Observer {
            adapter.updateData(ArrayList(it))
        })


    }
}