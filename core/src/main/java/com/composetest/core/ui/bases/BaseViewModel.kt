package com.composetest.core.ui.bases

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

abstract class BaseViewModel<Action, State>(stateInstance: State) : ViewModel() {

    protected val _state = MutableStateFlow(stateInstance)
    val state = _state.asStateFlow()

    abstract fun handleAction(action: Action)

    protected fun <T> asyncFlowTask(
        showLoading: Boolean = false,
        flowTask: Flow<T>,
        onErrorTask: (e: Throwable) -> Unit = ::handleError,
        onSuccessTask: (param: T) -> Unit,
    ) {
        viewModelScope.launch {
            flowTask.onStart {
                //showLoading(showLoading)
            }.onCompletion {
                //showLoading(false)
            }.catch {
                onErrorTask.invoke(it)
            }.collect {
                onSuccessTask.invoke(it)
            }
        }
    }

    private fun handleError(e: Throwable) {

    }
}