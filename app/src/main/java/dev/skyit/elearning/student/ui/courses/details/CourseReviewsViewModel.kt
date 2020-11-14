package dev.skyit.elearning.student.ui.courses.details

import androidx.lifecycle.MutableLiveData
import dev.skyit.elearning.student.repo.CourseDetailsRepo
import dev.skyit.elearning.student.repo.CourseReviewModel
import dev.skyit.elearning.student.ui.generic.BaseViewModel

class CourseReviewsViewModel(
    private val repo: CourseDetailsRepo
): BaseViewModel() {

    val reviews = MutableLiveData<List<CourseReviewModel>>()

    fun loadData() {
        reviews.makeCall {
            repo.getReviews(-1)
        }
    }
}