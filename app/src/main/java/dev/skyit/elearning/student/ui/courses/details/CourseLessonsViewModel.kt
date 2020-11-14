package dev.skyit.elearning.student.ui.courses.details

import androidx.lifecycle.MutableLiveData
import dev.skyit.elearning.student.repo.CourseDetailsRepo
import dev.skyit.elearning.student.repo.LessonModel
import dev.skyit.elearning.student.ui.generic.BaseViewModel

class CourseLessonsViewModel(
    private val courseId: String,
    private val repo: CourseDetailsRepo
): BaseViewModel() {

    val lessons = MutableLiveData<List<LessonModel>>()

    fun loadData() {
        lessons.makeCall {
            repo.getLessons(courseId)
        }
    }

}