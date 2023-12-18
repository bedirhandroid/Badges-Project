package com.bedirhandroid.badgesproject.network.models.praise

import com.bedirhandroid.badgesproject.enums.BadgeTypes

data class PraiseWithBadgeTypeModel(
    val rate: List<Int>,
    val type : BadgeTypes,
)