package com.bedirhandroid.badgesproject.ui.fragments

import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.bedirhandroid.badgesproject.R
import com.bedirhandroid.badgesproject.base.BaseFragment
import com.bedirhandroid.badgesproject.databinding.FragmentMainBinding
import com.bedirhandroid.badgesproject.network.models.badge.uimodel.BadgeUiModel
import com.bedirhandroid.badgesproject.network.models.praise.PraiseWithBadgeTypeModel
import com.bedirhandroid.badgesproject.network.models.praise.uimodel.RowUi
import com.bedirhandroid.badgesproject.ui.adapters.CommentsAdapter
import com.bedirhandroid.badgesproject.ui.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : BaseFragment<FragmentMainBinding, MainFragmentVM>() {
    private lateinit var vpAdapter: ViewPagerAdapter
    private lateinit var commentsAdapter: CommentsAdapter
    var sumTotalRate = 0
    var sumTotalSize = 0

    private val currentPageObserver = Observer<Int> { _pos ->
        viewModel.commentsDataList?.get(_pos)?.map {
            it.value
        }.also {
            it?.let(::initCommentsAdapter)
        }
    }

    private val praiseTotalTextObserver = Observer<String> {
        binding.tvTotalRating.text = it.replace(".", ",")
    }


    override fun initView() {}

    override fun initListeners() {
        viewBinding {
            vpBoard.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    viewModel.currentPage.postValue(position)
                }
            })
        }
    }

    override fun initObservers() {
        viewModel {
            praiseStateFlow.collectStateFlowData {
                this?.let {
                    val x = this.row?.groupBy { it.badgePraiseModel?.lookupId }?.map { it }
                        ?.sortedBy { it.key }?.chunked(9)?.get(0)
                    commentsDataList = x?.chunked(4)
                }
            }
            badgeStateFlow.collectStateFlowData {
                this?.let { _pair ->
                    _pair.second?.let { _praiseList ->
                        _praiseList.map { _praise ->
                            sumTotalSize += _praise.rate.size
                            _praise.rate.map { _int ->
                                sumTotalRate += _int
                            }
                        }.also {
                            binding.tvTotalCount.text =
                                getString(R.string.txt_dynamic_units, sumTotalSize)
                            binding.rbTotal.rating = sumTotalRate / sumTotalSize.toFloat()
                        }
                        _pair.first?.value?.let { _badgeUiModelList ->
                            initViewPagerAdapter(
                                _badgeUiModelList,
                                _praiseList
                            )
                        }
                    }
                }
            }
            currentPage.observe(viewLifecycleOwner, currentPageObserver)
            praiseTotalText.observe(viewLifecycleOwner, praiseTotalTextObserver)
        }
    }

    private fun initViewPagerAdapter(
        list: List<BadgeUiModel>,
        praiseList: List<PraiseWithBadgeTypeModel>
    ) {
        viewBinding {
            vpBoard.apply {
                viewModel.currentPage.value?.let { _pos ->
                    vpAdapter = ViewPagerAdapter(list.chunked(4), praiseList.chunked(4))
                    vpAdapter.submitList(list.chunked(3)[0]) //indicator sayısı için statik yazıldı burası
                    adapter = vpAdapter
                    offscreenPageLimit = list.chunked(4)[_pos].size
                }
            }
            TabLayoutMediator(tabLayout, vpBoard) { _, _ -> }.attach()
        }
    }

    private fun initCommentsAdapter(list: List<List<RowUi>>) {
        val sumList = mutableListOf<RowUi>()
        list.map {
            sumList.addAll(it)
        }
        commentsAdapter = CommentsAdapter(sumList.sortedBy { it.dateMilliSec() })
        binding.rvComments.adapter = commentsAdapter
    }

}