package com.bedirhandroid.badgesproject.usecases.impl.praise

import com.bedirhandroid.badgesproject.base.BaseFlowUseCase
import com.bedirhandroid.badgesproject.base.Repository
import com.bedirhandroid.badgesproject.network.models.praise.uimodel.PraiseUi
import com.bedirhandroid.badgesproject.network.models.praise.uimodel.RowUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PraiseUseCase@Inject constructor(private val repo: Repository) : BaseFlowUseCase<Unit, PraiseUi>(){
    override fun execute(params: Unit): Flow<PraiseUi> =
        repo.getPraises().map {
            PraiseUi(
                row = it.row.map { _row ->
                    RowUi(
                        id = _row.id,
                        relatedPerson = _row.relatedPerson?.firstOrNull(),
                        praiseRating = _row.praiseRating,
                        badgePraiseModel = _row.badgePraiseModel?.firstOrNull() ,
                        message = _row.message,
                        createdDate = _row.createdDate
                    )
                }
            )
        }


}