package com.bedirhandroid.badgesproject.models.praise

import com.google.gson.annotations.SerializedName

data class PraiseResponse(
    @SerializedName("Row")
    val row: List<Row> = listOf()
) {
    val praiseCount = row.map {
        it.praiseRating != null
    }.size
}