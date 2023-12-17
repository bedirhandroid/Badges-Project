package com.bedirhandroid.badgesproject.usecases.impl.badge

import com.bedirhandroid.badgesproject.models.badge.Badge
import com.bedirhandroid.badgesproject.models.badge.BadgeResponse

object BadgeFixtures {
    fun getBadgeResponse() =
        BadgeResponse(
            value = listOf(
                Badge(
                    dataId = "69eca8ee-6e23-43d0-9024-1316ef04c273",
                    type = "1",
                    id = 1,
                ),
                Badge(
                    dataId = "c5d1c620-71a2-4c35-9c0b-878b70fe4da4",
                    type = "2",
                    id = 1,
                )
            )
        )

}