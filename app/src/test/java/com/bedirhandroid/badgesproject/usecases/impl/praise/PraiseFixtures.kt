package com.bedirhandroid.badgesproject.usecases.impl.praise

import com.bedirhandroid.badgesproject.network.models.praise.BadgePraiseModel
import com.bedirhandroid.badgesproject.network.models.praise.PraiseResponse
import com.bedirhandroid.badgesproject.network.models.praise.RelatedPerson
import com.bedirhandroid.badgesproject.network.models.praise.Row

object PraiseFixtures {
    fun getPraiseResponse() =
        PraiseResponse(
            row = listOf(
                Row(
                    id = 1,
                    relatedPerson = listOf(
                        RelatedPerson(
                            email = "xxx@xxx.xxx",
                            id = "1",
                            picture = "xxxxjpeg",
                            sip = "mock-sip",
                            title = "Mock Title"
                        )
                    ),
                    praiseRating = 4,
                    badgePraiseModel = listOf(
                        BadgePraiseModel(
                            isSecretFieldValue = true,
                            lookupId = 1,
                            lookupValue = "mock-look-up-value"
                        )
                    ),
                    message = "Message",
                    createdDate = "Mock Date"
                ),
                Row(
                    id = 2,
                    relatedPerson = listOf(
                        RelatedPerson(
                            email = "2xxx@xxx.xxx",
                            id = "2",
                            picture = "2xxxxjpeg",
                            sip = "2mock-sip",
                            title = "2Mock Title"
                        )
                    ),
                    praiseRating = 5,
                    badgePraiseModel = listOf(
                        BadgePraiseModel(
                            isSecretFieldValue = true,
                            lookupId = 2,
                            lookupValue = "2mock-look-up-value"

                        )
                    ),
                    message = "2Message",
                    createdDate = "2Mock Date"
                )
            )
        )
}