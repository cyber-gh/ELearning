package dev.skyit.elearning.student.repo

import dev.skyit.model.Category


data class CategoryModel(val name: String, val url: String, val category: Category)

interface CategoriesRepo {
    suspend fun getCategories(contextId: String? = null) : List<CategoryModel>
}