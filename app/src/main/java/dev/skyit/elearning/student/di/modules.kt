package dev.skyit.elearning.student.di

import dev.skyit.elearning.student.repo.CategoriesRepo
import dev.skyit.elearning.student.repo.CategoriesRepoImpl
import dev.skyit.elearning.student.repo.CoursesRepo
import dev.skyit.elearning.student.repo.CoursesRepoImpl
import org.koin.dsl.module

val generalModule = module {
    single<CategoriesRepo> {
        CategoriesRepoImpl()
    }

    single<CoursesRepo> {
        CoursesRepoImpl()
    }
}