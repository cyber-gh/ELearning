package dev.skyit.elearning.student.ui.courses

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.skyit.elearning.student.repo.CategoriesRepo
import dev.skyit.elearning.student.repo.CourseModel
import dev.skyit.elearning.student.repo.CoursesRepo
import dev.skyit.elearning.student.ui.generic.BaseViewModel
import kotlinx.coroutines.launch

class SearchCoursesMinimalViewModel(
    private val coursesRepo: CoursesRepo
): BaseViewModel() {

    private var allCourses: List<CourseModel> = emptyList()

    val filteredCourses = MutableLiveData<List<CourseModel> >()

    init {
        viewModelScope.launch {
            allCourses = coursesRepo.getCourses()
        }
    }

    fun filter(keyword: String) {
        filteredCourses.value = allCourses.filter {
            it.name.toLowerCase().contains(keyword.toLowerCase())
        }
    }
}