package dev.skyit.elearning.student.di

import dev.skyit.elearning.student.cache.CacheManager
import dev.skyit.elearning.student.cache.CacheManagerImpl
import dev.skyit.elearning.student.repo.*
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val generalModule = module {
    single<CategoriesRepo> {
        CategoriesRepoImpl()
    }

    single<CoursesRepo> {
        CoursesRepoImpl()
    }

    single<UserRepo> {
        UserRepoImpl(get())
    }

    single<CacheManager> {
        CacheManagerImpl(androidContext())
    }
}