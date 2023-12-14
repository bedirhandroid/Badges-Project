package com.bedirhandroid.badgesproject.usecases.impl.badge

import com.bedirhandroid.badgesproject.base.BaseFlowUseCase
import com.bedirhandroid.badgesproject.base.Repository
import com.bedirhandroid.badgesproject.models.badge.uimodel.BadgeUi
import com.bedirhandroid.badgesproject.models.badge.uimodel.BadgeUiModel
import com.bedirhandroid.badgesproject.models.xxx.BadgeIconModel
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BadgeUseCase @Inject constructor(private val repository: Repository) :
    BaseFlowUseCase<Unit, BadgeUi>() {

    override fun execute(params: Unit): Flow<BadgeUi> =
        repository.getBadges().map {
            BadgeUi(
                value = it.value?.map { _map ->
                    BadgeUiModel(
                        icon = _map.parseBadgeIcon(),
                        id = _map.id,
                        title = _map.title,
                        editLink = _map.editLink,
                        eTag = _map.eTag,
                        dataId = _map.dataId,
                        type = _map.type
                    )
                }
            )
        }
}