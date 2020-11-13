package dev.skyit.elearning.student.di

import dev.skyit.elearning.student.repo.*
import org.koin.dsl.module

val generalModule = module {
    single<CategoriesRepo> {
        CategoriesRepoImpl()
    }

    single<CoursesRepo> {
        CoursesRepoImpl()
    }

    single<UserRepo> {
        UserRepoImpl()
    }
}