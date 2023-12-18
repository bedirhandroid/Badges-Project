package com.bedirhandroid.badgesproject.network

import com.bedirhandroid.badgesproject.network.models.badge.BadgeResponse
import com.bedirhandroid.badgesproject.network.models.praise.PraiseResponse
import com.bedirhandroid.badgesproject.network.request.RequestModel
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/")
    suspend fun getBadges(@Body request : RequestModel) : BadgeResponse


    @POST("/")
    suspend fun getPraises(@Body request: RequestModel) : PraiseResponse
}