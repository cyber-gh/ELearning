package dev.skyit.elearning.student.repo

import dev.skyit.api.CategoriesGetApi
import dev.skyit.api.CoursesGetApi
import dev.skyit.api.WorkspaceGetApi
import dev.skyit.elearning.student.cache.CacheManager
import dev.skyit.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

data class CourseModel(val name: String,
                       val imgLink: String = "https://media.wired.com/photos/593235d89be5e55af6c2388b/master/w_1600%2Cc_limit/GettyImages-174715765.jpg",
                       val teacher: String = "Soltan Gheorghe",
                       val rating: Int = 4)


data class CourseReviewModel(val name: String,
                             val timeElapsed: String,
                             val comment: String,
                             val rating: Int)

data class LessonModel(
    val name: String,
    val video: Video
)

interface CoursesRepo {
    suspend fun getCourses(contextId: String? = null, categoryId: String? = null) : List<CourseModel>
    suspend fun getMyCourses() : List<CourseModel>

}

interface WorkspaceRepo {
    suspend fun getWorkspaces(): List<Workspace>
}

interface CourseDetailsRepo {
    suspend fun getReviews(courseId: Int): List<CourseReviewModel>
    suspend fun getLessons(courseId: Int): List<LessonModel>
}

class CoursesRepoImpl(
    private val cacheManager: CacheManager
): CoursesRepo, CategoriesRepo, WorkspaceRepo, CourseDetailsRepo {




    override suspend fun getCourses(contextId: String?, categoryId: String?): List<CourseModel> = withContext(Dispatchers.IO) {
        val ctx = contextId ?: getWorkspaces().first().id!!
        CoursesGetApi().getCoursesParam(
            InlineObject2(CoursesGetData("", ctx), cacheManager.loginToken)
        ).data!!.map {
            val rating = if (it.reviews != null &&  it.reviews!!.count() > 0) it.reviews!!.sumBy { it.rating!! } / it.reviews!!.count() else 0
            CourseModel(it.name!!, it.url!!, it.teacherId!!, rating)
        }
    }

    override suspend fun getMyCourses(): List<CourseModel> {
        return listOf(
            CourseModel("Physics - Basics"),
            CourseModel("Physics - Aerodynamics"),
            CourseModel("Physics - Law of Motion"),
            CourseModel("Physics - Fluids"),
        )
    }

    override suspend fun getWorkspaces(): List<Workspace> = withContext(Dispatchers.IO) {

        WorkspaceGetApi().getWorkspaceParam(InlineObject7(cacheManager.loginToken)).data!!.toList()
    }

    override suspend fun getCategories(contextId: String?): List<CategoryModel> = withContext(Dispatchers.IO) {
        val ctx = contextId ?: getWorkspaces().first().id!!
        CategoriesGetApi().getCategoriesParam(InlineObject(data = ctx,cacheManager.loginToken)).data!!.toList().map {
            CategoryModel(it.name!!)
        }
    }

    override suspend fun getReviews(courseId: Int): List<CourseReviewModel> {
        return listOf(
            CourseReviewModel("John Cena", "1 day ago", "Best course ever", 5),
            CourseReviewModel("John Cena", "2 days ago", "Best course ever", 5),
            CourseReviewModel("John Cena", "Yesterday", "Not bad", 3),
            CourseReviewModel("John Cena", "1 month ago", "Sucked", 2),
        )
    }

    override suspend fun getLessons(courseId: Int): List<LessonModel> {
        return listOf(
            LessonModel("1. The Avatar", Video()),
            LessonModel("2. La Fleur Martini", Video()),
            LessonModel("3. The Pheonix", Video()),
            LessonModel("4. The Lesson", Video()),
            LessonModel("4. The Lesson", Video()),
            LessonModel("4. The Lesson", Video()),
            LessonModel("4. The Lesson", Video()),
            LessonModel("4. The Lesson", Video()),
        )
    }

}