package com.bedirhandroid.badgesproject.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bedirhandroid.badgesproject.R
import com.bedirhandroid.badgesproject.databinding.GridRowBinding
import com.bedirhandroid.badgesproject.network.models.badge.uimodel.BadgeUiModel
import com.bedirhandroid.badgesproject.network.models.praise.PraiseWithBadgeTypeModel
import com.bedirhandroid.badgesproject.util.loadImageByType

class BadgeGridAdapter(
    private val list: List<BadgeUiModel>,
    private val rates: List<PraiseWithBadgeTypeModel>
) : RecyclerView.Adapter<BadgeGridAdapter.GridAdapterVH>() {

    class GridAdapterVH(val binding: GridRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridAdapterVH {
        val binding = GridRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GridAdapterVH(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: GridAdapterVH, position: Int) {
        val listByPosition = list[position]
        var totalRates = 0f
        rates[position].rate.map {
            totalRates += it

        }.also {
            totalRates /= it.size.toFloat()
            holder.binding.apply {
                tvCount.text = tvCount.context.getString(R.string.txt_dynamic_units, it.size)
            }
        }
        holder.binding.apply {
            tvTitle.text = listByPosition.title
            rvRating.rating = totalRates
            ivBadge.loadImageByType(rates[position].type)
        }
    }
}