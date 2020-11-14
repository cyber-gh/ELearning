package dev.skyit.elearning.student.di

import dev.skyit.elearning.student.cache.CacheManager
import dev.skyit.elearning.student.cache.CacheManagerImpl
import dev.skyit.elearning.student.repo.*
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module

val generalModule = module {

    single<CoursesRepo> {
        CoursesRepoImpl(get())
    } bind CategoriesRepo::class bind CourseDetailsRepo::class

    single<UserRepo> {
        UserRepoImpl(get())
    }

    single<CacheManager> {
        CacheManagerImpl(androidContext())
    }
    
    single<NotificationRepo> {
        NotificationRepoImlp()
    }

}