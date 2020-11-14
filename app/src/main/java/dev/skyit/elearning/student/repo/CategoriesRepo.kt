package dev.skyit.elearning.student.repo


data class CategoryModel(val name: String)

interface CategoriesRepo {
    suspend fun getCategories(contextId: String? = null) : List<CategoryModel>
}