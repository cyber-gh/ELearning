package dev.skyit.elearning.student.repo

data class CourseModel(val name: String,
                       val imgLink: String = "https://media.wired.com/photos/593235d89be5e55af6c2388b/master/w_1600%2Cc_limit/GettyImages-174715765.jpg",
                       val teacher: String = "Soltan Gheorghe",
                       val rating: Int = 4)

interface CoursesRepo {
    suspend fun getCourses(contextId: String = "", categoryId: String = "") : List<CourseModel>
    suspend fun getMyCourses() : List<CourseModel>

}

class CoursesRepoImpl: CoursesRepo {
    override suspend fun getCourses(contextId: String, categoryId: String): List<CourseModel> {
        return getMyCourses()
    }

    override suspend fun getMyCourses(): List<CourseModel> {
        return listOf(
            CourseModel("Physics - Basics"),
            CourseModel("Physics - Aerodynamics"),
            CourseModel("Physics - Law of Motion"),
            CourseModel("Physics - Fluids"),
        )
    }

}