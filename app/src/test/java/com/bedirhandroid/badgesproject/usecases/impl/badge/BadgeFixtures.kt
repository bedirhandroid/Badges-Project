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
                    icon = "{\"type\":\"thumbnail\",\"fileName\":\"icon_deger_katan.png\",\"nativeFile\":{},\"fieldName\":\"BadgeIcon\",\"serverUrl\":\"https://devjunointranet.sharepoint.com\",\"serverRelativeUrl\":\"/sites/dev/Praise/SiteAssets/Lists/5f0cf965-1901-4f1d-ad7c-ddb89acfa58c/icon_deger_katan.png\",\"id\":\"e2b52295-d408-4157-93ce-845e3da6f01f\"}",
                    id = 1,
                ),
                Badge(
                    dataId = "c5d1c620-71a2-4c35-9c0b-878b70fe4da4",
                    type = "2",
                    icon = "{\"type\":\"thumbnail\",\"fileName\":\"icon_gelisime_acik.png\",\"nativeFile\":{},\"fieldName\":\"BadgeIcon\",\"serverUrl\":\"https://devjunointranet.sharepoint.com\",\"serverRelativeUrl\":\"/sites/dev/Praise/SiteAssets/Lists/5f0cf965-1901-4f1d-ad7c-ddb89acfa58c/icon_gelisime_acik.png\",\"id\":\"7e480327-6e4a-4617-aa72-0e1022a16513\"}",
                    id = 1,
                )
            )
        )

}