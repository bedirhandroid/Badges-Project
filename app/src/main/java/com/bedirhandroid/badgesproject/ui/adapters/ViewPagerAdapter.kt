package com.bedirhandroid.badgesproject.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bedirhandroid.badgesproject.databinding.ViewPagerRowBinding
import com.bedirhandroid.badgesproject.network.models.badge.uimodel.BadgeUiModel
import com.bedirhandroid.badgesproject.network.models.praise.PraiseWithBadgeTypeModel

class ViewPagerAdapter(
    private val list: List<List<BadgeUiModel>>,
    private val averageRate :List<List<PraiseWithBadgeTypeModel>>
) : ListAdapter<BadgeUiModel, ViewPagerAdapter.PagerAdapterVH>(MyDiffCallback()) {

    private lateinit var gridAdapter: BadgeGridAdapter

    class PagerAdapterVH(val binding: ViewPagerRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerAdapterVH {
        val binding =
            ViewPagerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagerAdapterVH(binding)
    }

    override fun onBindViewHolder(holder: PagerAdapterVH, position: Int) {
        holder.binding.apply {
            if (position <= 2) {
                gridAdapter = BadgeGridAdapter(list[position], averageRate[position])
                rvGridAdapter.adapter = gridAdapter
            }
        }
    }

    class MyDiffCallback : DiffUtil.ItemCallback<BadgeUiModel>() {
        override fun areItemsTheSame(oldItem: BadgeUiModel, newItem: BadgeUiModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BadgeUiModel, newItem: BadgeUiModel): Boolean {
            return oldItem == newItem
        }
    }
}