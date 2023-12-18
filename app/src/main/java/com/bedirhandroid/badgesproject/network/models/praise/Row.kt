package com.bedirhandroid.badgesproject.network.models.praise

import com.google.gson.annotations.SerializedName

data class Row(
    @SerializedName("ID")
    val id: Int? = null,
    @SerializedName("RelatedPerson")
    val relatedPerson: List<RelatedPerson>? = null,
    @SerializedName("PraiseRating")
    val praiseRating : Int? = null,
    @SerializedName("Badge")
    val badgePraiseModel: List<BadgePraiseModel>? = null,
    @SerializedName("Message")
    val message: String? = null,
    @SerializedName("Created.")
    val createdDate: String? = null
)