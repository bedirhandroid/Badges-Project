package com.bedirhandroid.badgesproject.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bedirhandroid.badgesproject.enums.BadgeTypes
import com.bedirhandroid.badgesproject.databinding.CommentRowBinding
import com.bedirhandroid.badgesproject.models.praise.uimodel.RowUi
import com.bedirhandroid.badgesproject.util.loadImage
import com.bedirhandroid.badgesproject.util.loadImageByType

class CommentsAdapter(private val list: List<RowUi>) :
    RecyclerView.Adapter<CommentsAdapter.CommentsVH>() {

    class CommentsVH(val binding: CommentRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsVH {
        val binding = CommentRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentsVH(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CommentsVH, position: Int) {
        list[position].let {
            holder.binding.apply {
                tvMsg.text = it.message
                tvName.text = it.relatedPerson?.title
                tvBadgeName.text = it.badgePraiseModel?.lookupValue
                rbRate.rating = it.praiseRating?.toFloat()!!
                tvDate.text = it.timeDiffToString(tvDate.context)
                ivPerson.loadImage(position)
                ivBagde.loadImageByType(BadgeTypes.fromInt(it.badgePraiseModel?.lookupId!!)!!)
            }
        }

    }
}