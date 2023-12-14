package com.bedirhandroid.badgesproject.models.badge.uimodel

import com.bedirhandroid.badgesproject.models.xxx.BadgeIconModel
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class BadgeUiModel(
    @SerializedName("BadgeIcon")
    val icon: BadgeIconModel? = null,
    @SerializedName("Id")
    val id: Int? = null,
    @SerializedName("Title")
    val title: String? = null,
    @SerializedName("odata.editLink")
    val editLink: String? = null,
    @SerializedName("odata.etag")
    val eTag: String? = null,
    @SerializedName("odata.id")
    val dataId: String? = null,
    @SerializedName("odata.type")
    val type: String? = null
)
