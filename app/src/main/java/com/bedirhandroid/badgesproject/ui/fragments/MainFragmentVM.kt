package com.bedirhandroid.badgesproject.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bedirhandroid.badgesproject.base.BaseViewModel
import com.bedirhandroid.badgesproject.enums.BadgeTypes
import com.bedirhandroid.badgesproject.network.models.badge.uimodel.BadgeUi
import com.bedirhandroid.badgesproject.network.models.praise.PraiseWithBadgeTypeModel
import com.bedirhandroid.badgesproject.network.models.praise.uimodel.PraiseUi
import com.bedirhandroid.badgesproject.network.models.praise.uimodel.RowUi
import com.bedirhandroid.badgesproject.usecases.impl.badge.BadgeUseCase
import com.bedirhandroid.badgesproject.usecases.impl.praise.PraiseUseCase
import com.bedirhandroid.badgesproject.util.groupList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentVM @Inject constructor(
    private val badgeUseCase: BadgeUseCase,
    private val praiseUseCase: PraiseUseCase
) : BaseViewModel() {

    val currentPage = MutableLiveData(0)
    var praiseTotalText = MutableLiveData<String>()
    private var totalRating: Int = 0
    var commentsDataList: List<List<Map.Entry<Int?, List<RowUi>>>>? = null
    private val mutableListPraiseBadgeModel = mutableListOf<PraiseWithBadgeTypeModel>()

    private val _praiseStateFlow = MutableStateFlow<PraiseUi?>(null)
    val praiseStateFlow = _praiseStateFlow.asStateFlow()

    private val _badgeStateFlow =
        MutableStateFlow<Pair<BadgeUi?, List<PraiseWithBadgeTypeModel>?>?>(null)
    val badgeStateFlow = _badgeStateFlow.asStateFlow()

    init {
        getBadgeAndPraiseList()
    }

    private fun getBadgeAndPraiseList() {
        viewModelScope.launch {
            zipFlows(badgeUseCase.invoke(Unit), (praiseUseCase.invoke(Unit))) { badges, praises ->
                mutableListPraiseBadgeModel.addAll(praises.groupList())
                praises.row?.map {
                    totalRating += it.praiseRating ?: 0
                }
                praiseTotalText.postValue(
                    (totalRating / (praises.row?.size ?: 0)).toFloat().toString()
                )
                _praiseStateFlow.emit(praises)
                _badgeStateFlow.emit(Pair(first = badges, second = mutableListPraiseBadgeModel))
            }
        }
    }

}
