package com.bedirhandroid.badgesproject.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import java.io.EOFException
import java.net.ProtocolException
import java.util.concurrent.TimeoutException

abstract class BaseViewModel : ViewModel() {
    val errorLiveData: MutableLiveData<String> = MutableLiveData()
    val showProgress: MutableLiveData<Boolean> = MutableLiveData()

    protected inline fun sendRequest(
        crossinline block: suspend CoroutineScope.() -> Unit
    ) {
        viewModelScope.launch {
            showProgress.postValue(true)
            try {
                block()
            } catch (exception: Exception) {
                when (exception) {
                    is TimeoutException -> errorLiveData.postValue("ErrorMessages.TIME_OUT")
                    is ProtocolException -> errorLiveData.postValue("ErrorMessages.TRY_AGAIN")
                    is EOFException -> errorLiveData.postValue("ErrorMessages.ERROR_EOFE")
                    else -> {
                        errorLiveData.postValue("ERROR")
                    }
                }
            } finally {
                showProgress.postValue(false)
            }
        }
    }

    inline fun <T> Flow<T>.collectFlow(crossinline block: suspend T.() -> Unit) {
        viewModelScope.launch {
            this@collectFlow.onStart {
                showProgress.postValue(true)
            }.onCompletion {
                showProgress.postValue(false)
            }.catch {
                errorLiveData.postValue(it.message)
            }.collect {
                block(it)
            }
        }
    }

    inline fun <T : Any, R : Any> zipFlows(
        flow1: Flow<T>,
        flow2: Flow<R>,
        crossinline block: suspend (first: T, sec: R) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.Unconfined) {
            flow1.zip(flow2) { value1, value2 ->
                block(value1, value2)
            }.onStart {
                showProgress.postValue(true)
            }.onCompletion {
                showProgress.postValue(false)
            }.catch { cause ->
                errorLiveData.postValue(cause.message)
            }.collect()
        }
    }

}