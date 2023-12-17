package com.bedirhandroid.badgesproject.base

import com.bedirhandroid.badgesproject.models.badge.BadgeResponse
import com.bedirhandroid.badgesproject.models.praise.PraiseResponse
import com.bedirhandroid.badgesproject.models.request.RequestModel
import com.bedirhandroid.badgesproject.network.ApiService
import com.bedirhandroid.badgesproject.util.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {
    fun getBadges(): Flow<BadgeResponse> = flow {
        emit(apiService.getBadges(RequestModel(Constants.BADGE_BODY)))
    }


    fun getPraises(): Flow<PraiseResponse> = flow {
        emit(apiService.getPraises(RequestModel(Constants.PRAISE_BODY)))
    }
}
