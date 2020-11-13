package dev.skyit.elearning.student.ui.generic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import dev.skyit.elearning.utility.LoadingResource
import dev.skyit.elearning.utility.SingleLiveEvent

open class BaseViewModel: ViewModel() {
    val loadingState = SingleLiveEvent<LoadingResource<String>>()

    protected fun makeCall(wrapped: suspend () -> String) {
        viewModelScope.launch {
            loadingState.postValue(LoadingResource.Loading())
            kotlin.runCatching {
                wrapped()
            }.onSuccess {
                loadingState.postValue(LoadingResource.Success(it))
            }.onFailure {
                loadingState.postValue(LoadingResource.Error(it.localizedMessage))
            }
        }
    }

    protected fun withLoading(wrapped: suspend () -> Unit) {
        viewModelScope.launch {
            loadingState.postValue(LoadingResource.Loading())
            kotlin.runCatching {
                wrapped()
            }.onSuccess {
                loadingState.postValue(LoadingResource.Idle())
            }.onFailure {
                loadingState.postValue(LoadingResource.Error(it.localizedMessage))
            }
        }
    }


    protected fun <T> MutableLiveData<T>.makeCall(wrapped: suspend () -> T) {
        viewModelScope.launch {
            loadingState.postValue(LoadingResource.Loading())
            kotlin.runCatching {
                wrapped()
            }.onSuccess {
                loadingState.postValue(LoadingResource.Success("Loaded"))
                postValue(it)
            }.onFailure {
                loadingState.postValue(LoadingResource.Error(it.localizedMessage))
            }
        }
    }
}