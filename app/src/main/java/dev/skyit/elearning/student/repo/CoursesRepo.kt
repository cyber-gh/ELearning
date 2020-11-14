package dev.skyit.elearning.student.repo

import dev.skyit.api.*
import dev.skyit.elearning.student.cache.CacheManager
import dev.skyit.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

data class CourseModel(val name: String,
                       val imgLink: String = "https://media.wired.com/photos/593235d89be5e55af6c2388b/master/w_1600%2Cc_limit/GettyImages-174715765.jpg",
                       val teacher: String = "Soltan Gheorghe",
                       val rating: Int = 4,
                       val course: Course
)


data class CourseReviewModel(val name: String,
                             val timeElapsed: String,
                             val comment: String,
                             val rating: Int)

data class LessonModel(
    val name: String,
    val video: Video?,
    val materials: List<String>
)

interface CoursesRepo {
    suspend fun getCourses(contextId: String? = null, categoryId: String? = null) : List<CourseModel>
    suspend fun getMyCourses() : List<CourseModel>

}

interface WorkspaceRepo {
    suspend fun getWorkspaces(): List<Workspace>
}

interface CourseDetailsRepo {
    suspend fun getReviews(courseId: String): List<CourseReviewModel>
    suspend fun getLessons(courseId: String): List<LessonModel>
}

class CoursesRepoImpl(
    private val cacheManager: CacheManager
): CoursesRepo, CategoriesRepo, WorkspaceRepo, CourseDetailsRepo {




    override suspend fun getCourses(contextId: String?, categoryId: String?): List<CourseModel> = withContext(Dispatchers.IO) {
        val ctx = contextId ?: getWorkspaces().first().id!!
        CoursesGetApi().getCoursesParam(
            InlineObject2(CoursesGetData(categoryId ?: "", ctx), cacheManager.loginToken)
        ).data!!.map {
            val teacherName = "Soltan Gheorghe"
            val rating = if (it.reviews != null &&  it.reviews!!.count() > 0) it.reviews!!.sumBy { it.rating!! } / it.reviews!!.count() else 0
            CourseModel(it.name!!, it.url!!, teacherName, rating, it)
        }
    }

    override suspend fun getMyCourses(): List<CourseModel>  = withContext(Dispatchers.IO){
        CoursesGetUserApi().coursesGetUserParam(InlineObject3(cacheManager.loginToken)).data!!.map {
            val teacherName = "Soltan Gheorghe"
            val rating = if (it.reviews != null &&  it.reviews!!.count() > 0) it.reviews!!.sumBy { it.rating!! } / it.reviews!!.count() else 0
            CourseModel(it.name!!, it.url!!, teacherName, rating, it)
        }
    }

    override suspend fun getWorkspaces(): List<Workspace> = withContext(Dispatchers.IO) {

        WorkspaceGetApi().getWorkspaceParam(InlineObject9(cacheManager.loginToken)).data!!.toList()
    }

    override suspend fun getCategories(contextId: String?): List<CategoryModel> = withContext(Dispatchers.IO) {
        val ctx = contextId ?: getWorkspaces().first().id!!
        CategoriesGetApi().getCategoriesParam(InlineObject(data = ctx,cacheManager.loginToken)).data!!.toList().map {
            CategoryModel(it.name!!, it.url ?: "", it)
        }
    }

    override suspend fun getReviews(courseId: String): List<CourseReviewModel> = withContext(Dispatchers.IO){
        getCourses().first {
            it.course.id == courseId
        }.course.reviews!!.map {
            CourseReviewModel(it.name!!, "Yesterday", it.feedback!!, it.rating!!)
        }
    }

    override suspend fun getLessons(courseId: String): List<LessonModel> = withContext(Dispatchers.IO){
        val list = getCourses().first {
            it.course.id == courseId
        }.course.lessons!!.mapIndexed { index, lesson ->
            LessonModel("Lesson Nr ${index}", lesson.video ?: Video(), lesson.materials?.toList() ?: emptyList())
        }
        list
//        return listOf(
//            LessonModel("1. The Avatar", Video()),
//            LessonModel("2. La Fleur Martini", Video()),
//            LessonModel("3. The Pheonix", Video()),
//            LessonModel("4. The Lesson", Video()),
//            LessonModel("4. The Lesson", Video()),
//            LessonModel("4. The Lesson", Video()),
//            LessonModel("4. The Lesson", Video()),
//            LessonModel("4. The Lesson", Video()),
//        )
    }

}