package dev.skyit.elearning.auth.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.skyit.api.LoginTagApi
import dev.skyit.elearning.student.repo.UserRepo
import dev.skyit.elearning.student.ui.generic.BaseViewModel
import dev.skyit.elearning.utility.LoadingResource
import dev.skyit.model.Session
import kotlinx.coroutines.launch
import javax.security.auth.login.LoginException

class LoginViewModel(
    private val repo: UserRepo
): BaseViewModel() {


    val state = MutableLiveData<LoadingResource<String>>()

    fun login(email: String, pass: String) {
        state.postValue(LoadingResource.Loading())

        viewModelScope.launch {
            kotlin.runCatching {
                repo.login(email, pass)
            }.onSuccess {
                state.postValue(LoadingResource.Success(it))
            }.onFailure {
                state.postValue(LoadingResource.Error(it.localizedMessage))
            }
        }
    }
}