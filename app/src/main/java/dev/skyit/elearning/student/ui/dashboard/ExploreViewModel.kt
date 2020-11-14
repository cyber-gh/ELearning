package dev.skyit.elearning.student.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.skyit.elearning.student.repo.CategoriesRepo
import dev.skyit.elearning.student.repo.CategoryModel
import dev.skyit.elearning.student.repo.CourseModel
import dev.skyit.elearning.student.repo.CoursesRepo
import dev.skyit.elearning.student.ui.generic.BaseViewModel

class ExploreViewModel(
    private val categoriesRepo: CategoriesRepo,
    private val coursesRepo: CoursesRepo
) : BaseViewModel() {

    val categoriesLive = MutableLiveData<List<CategoryModel>>()

    fun loadData() {
        categoriesLive.makeCall {
            categoriesRepo.getCategories()
        }
    }
}