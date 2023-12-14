package com.bedirhandroid.badgesproject.models.praise.uimodel

import com.bedirhandroid.badgesproject.models.praise.BadgePraiseModel
import com.bedirhandroid.badgesproject.models.praise.RelatedPerson

data class RowUi(
    val id: Int? = null,
    val relatedPerson: RelatedPerson? = null,
    val praiseRating : Int? = null,
    val badgePraiseModel: BadgePraiseModel? = null,
    val message: String? = null,
    val createdDate: String? = null
)
