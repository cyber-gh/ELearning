package dev.skyit.elearning.student.repo


data class CategoryModel(val name: String)

interface CategoriesRepo {
    suspend fun getCategories(contextId: String = "") : List<CategoryModel>
}

class CategoriesRepoImpl: CategoriesRepo {
    override suspend fun getCategories(contextId: String): List<CategoryModel> {
        return listOf(
            CategoryModel("Physics"),
            CategoryModel("Maths"),
            CategoryModel("Literature"),
            CategoryModel("Chemistry"),
            CategoryModel("Biology")
        )
    }
}