package com.bedirhandroid.badgesproject

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.bedirhandroid.badgesproject.base.BaseViewModel
import com.bedirhandroid.badgesproject.base.Repository
import com.bedirhandroid.badgesproject.usecases.impl.badge.BadgeUseCase
import com.bedirhandroid.badgesproject.usecases.impl.praise.PraiseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class MainFragmentVM @Inject constructor(
    private val badgeUseCase: BadgeUseCase,
    private val praiseUseCase: PraiseUseCase
) : BaseViewModel() {

    fun getBadgeAndPraiseList() {
        viewModelScope.launch {
            zipFlows(badgeUseCase.invoke(Unit),(praiseUseCase.invoke(Unit))) { first, sec ->
                Log.d("qweqweqweqweqwe", "getBadgeAndPraiseList:first -> ${first}, sec -> ${sec}")
            }
        }
    }
}
