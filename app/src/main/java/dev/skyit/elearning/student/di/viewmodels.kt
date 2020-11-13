package dev.skyit.elearning.student.di

import dev.skyit.elearning.auth.login.LoginViewModel
import dev.skyit.elearning.student.ui.dashboard.DashboardViewModel
import dev.skyit.elearning.student.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel {
        HomeViewModel(get(), get())
    }

    viewModel {
        DashboardViewModel()
    }

    viewModel {
        LoginViewModel(get())
    }
}