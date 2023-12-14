package com.bedirhandroid.badgesproject.network

import com.bedirhandroid.badgesproject.RequestModel
import com.bedirhandroid.badgesproject.models.badge.BadgeResponse
import com.bedirhandroid.badgesproject.models.praise.PraiseResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/")
    suspend fun getBadges(@Body request : RequestModel) : BadgeResponse


    @POST("/")
    suspend fun getPraises(@Body request: RequestModel) : PraiseResponse
}