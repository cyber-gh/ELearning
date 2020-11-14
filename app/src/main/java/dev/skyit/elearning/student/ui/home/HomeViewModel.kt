package dev.skyit.elearning.student.ui.home

import androidx.lifecycle.MutableLiveData
import dev.skyit.elearning.student.repo.CategoriesRepo
import dev.skyit.elearning.student.repo.CategoryModel
import dev.skyit.elearning.student.repo.CourseModel
import dev.skyit.elearning.student.repo.CoursesRepo
import dev.skyit.elearning.student.ui.generic.BaseViewModel

class HomeViewModel(
    private val categoriesRepo: CategoriesRepo,
    private val coursesRepo: CoursesRepo
) : BaseViewModel() {

    val categoriesLive = MutableLiveData<List<CategoryModel>>()
    val coursesLive = MutableLiveData<List<CourseModel>>()

    fun loadData() {
        categoriesLive.makeCall {
            categoriesRepo.getCategories()
        }

        coursesLive.makeCall {
            coursesRepo.getMyCourses()
        }

    }
}