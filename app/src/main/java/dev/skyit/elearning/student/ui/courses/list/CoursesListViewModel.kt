package dev.skyit.elearning.student.ui.courses.list

import androidx.lifecycle.MutableLiveData
import dev.skyit.elearning.student.repo.CategoriesRepo
import dev.skyit.elearning.student.repo.CategoryModel
import dev.skyit.elearning.student.repo.CourseModel
import dev.skyit.elearning.student.repo.CoursesRepo
import dev.skyit.elearning.student.ui.generic.BaseViewModel

class CoursesListViewModel(
        private val workspaceId: String? = null,
        private val categoryId: String,
        private val coursesRepo: CoursesRepo
): BaseViewModel() {

    val courses = MutableLiveData<List<CourseModel>>()


    fun loadData() {
        courses.makeCall {
            coursesRepo.getCourses(workspaceId, categoryId)
        }
    }
}