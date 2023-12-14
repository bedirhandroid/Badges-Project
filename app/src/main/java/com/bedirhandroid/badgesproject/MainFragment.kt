package com.bedirhandroid.badgesproject

import com.bedirhandroid.badgesproject.base.BaseFragment
import com.bedirhandroid.badgesproject.databinding.FragmentMainBinding

class MainFragment: BaseFragment<FragmentMainBinding, MainFragmentVM>() {
    override fun initView() {
        viewModel.getBadgeAndPraiseList()
    }

    override fun initListeners() {

    }

    override fun initObservers() {

    }
}