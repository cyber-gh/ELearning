package dev.skyit.elearning.student.di

import dev.skyit.elearning.auth.login.LoginViewModel
import dev.skyit.elearning.student.repo.CourseReviewModel
import dev.skyit.elearning.student.ui.courses.SearchCoursesMinimalViewModel
import dev.skyit.elearning.student.ui.courses.details.CourseLessonsViewModel
import dev.skyit.elearning.student.ui.courses.details.CourseReviewsViewModel
import dev.skyit.elearning.student.ui.dashboard.ExploreViewModel
import dev.skyit.elearning.student.ui.home.HomeViewModel
import dev.skyit.elearning.student.ui.notifications.NotificationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel {
        HomeViewModel(get(), get())
    }

    viewModel {
        ExploreViewModel(get(), get())
    }

    viewModel {
        LoginViewModel(get())
    }

    viewModel {
        SearchCoursesMinimalViewModel(get())
    }

    viewModel {
        NotificationsViewModel(get())
    }

    viewModel {
        CourseReviewsViewModel(get())
    }

    viewModel {
        CourseLessonsViewModel(get())
    }
}