package dev.skyit.elearning.student.ui.courses.details

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.taufiqrahman.reviewratings.BarLabels
import dev.skyit.elearning.R
import dev.skyit.elearning.databinding.CourseListItemViewBinding
import dev.skyit.elearning.databinding.FragmentCourseReviewsBinding
import dev.skyit.elearning.databinding.ReviewListItemViewBinding
import dev.skyit.elearning.student.repo.CourseReviewModel
import dev.skyit.elearning.student.ui.generic.BaseFragment
import dev.skyit.elearning.utility.SimpleRecyclerAdapter
import dev.skyit.elearning.utility.setItemSpacing
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.util.*
import kotlin.collections.ArrayList


class CourseReviewsFragment(
        private val courseId: String = ""
): BaseFragment(R.layout.fragment_course_reviews) {
    private val binding: FragmentCourseReviewsBinding by viewBinding()
    private val vModel: CourseReviewsViewModel by viewModel{
        parametersOf(courseId)
    }

    private lateinit var adapter: SimpleRecyclerAdapter<CourseReviewModel, ReviewListItemViewBinding>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val colors = intArrayOf(
                Color.parseColor("#0e9d58"),
                Color.parseColor("#bfd047"),
                Color.parseColor("#ffc105"),
                Color.parseColor("#ef7e14"),
                Color.parseColor("#d36259"))

        val raters = intArrayOf(
                95,
                20,
               5,
                2,
                10
        )

        binding.ratingView.createRatingBars(100, BarLabels.STYPE1, colors, raters)

        adapter = SimpleRecyclerAdapter(
            binderCreator = { it ->
                ReviewListItemViewBinding.inflate(it)
            }, injectData = {data ->
                this.ratingStars.rating = data.rating.toFloat()
                this.reviewerComment.text = data.comment
                this.reviewerName.text = data.name
                this.timeElapsed.text = data.timeElapsed
            }
        )

        binding.recyclerView.adapter = adapter

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.recyclerView.setItemSpacing()

        vModel.reviews.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            adapter.updateData(ArrayList(it))
        })

        vModel.loadData()
    }
}