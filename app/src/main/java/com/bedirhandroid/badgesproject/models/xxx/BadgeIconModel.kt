package com.bedirhandroid.badgesproject.models.xxx

import com.google.gson.annotations.SerializedName

data class BadgeIconModel(
    @SerializedName("type") val type: String?,
    @SerializedName("fileName") val fileName: String?,
    @SerializedName("nativeFile") val nativeFile: Any?,
    @SerializedName("fieldName") val fieldName: String?,
    @SerializedName("serverUrl") val serverUrl: String?,
    @SerializedName("serverRelativeUrl") val serverRelativeUrl: String?,
    @SerializedName("id") val id: String?
)
