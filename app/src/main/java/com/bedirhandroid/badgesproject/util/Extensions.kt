package com.bedirhandroid.badgesproject.util

import android.app.AlertDialog
import android.content.Context
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import com.bedirhandroid.badgesproject.enums.BadgeTypes
import com.bedirhandroid.badgesproject.R


fun ImageView.loadImage(p: Int) {
    this.setImageDrawable(
        when (p % 2 == 0) {
            true -> AppCompatResources.getDrawable(this.context, R.drawable.ic_person_blue)
            else -> AppCompatResources.getDrawable(this.context, R.drawable.ic_person_purple)
        }
    )
}

fun ImageView.loadImageByType(type: BadgeTypes) {
    this.setImageDrawable(
        when(type) {
            BadgeTypes.DEGER_KATAN -> AppCompatResources.getDrawable(this.context, R.drawable.ic_deger_katan)
            BadgeTypes.DEGISIME_ACIK -> AppCompatResources.getDrawable(this.context, R.drawable.ic_degisime_acik)
            BadgeTypes.ISINE_HAKIM -> AppCompatResources.getDrawable(this.context, R.drawable.ic_isine_hakim)
            BadgeTypes.LIDER -> AppCompatResources.getDrawable(this.context, R.drawable.ic_lider)
            BadgeTypes.SORUN_COZEN -> AppCompatResources.getDrawable(this.context, R.drawable.ic_sorun_cozen)
            BadgeTypes.TAKIM_OYUNCUSU -> AppCompatResources.getDrawable(this.context, R.drawable.ic_takim_oyuncusu)
            BadgeTypes.TESEKKUR -> AppCompatResources.getDrawable(this.context, R.drawable.ic_tesekkur)
            BadgeTypes.YARATICI -> AppCompatResources.getDrawable(this.context, R.drawable.ic_yaratici)
            BadgeTypes.YENILIKCI -> AppCompatResources.getDrawable(this.context, R.drawable.ic_yenilikci)
        }
    )
}

fun String.showAlert(context: Context) {
    AlertDialog.Builder(context).apply {
        setTitle("Uyarı")
        setMessage(this@showAlert)
        setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
    }.show()
}