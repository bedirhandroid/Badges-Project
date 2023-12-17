package com.bedirhandroid.badgesproject.models.praise.uimodel

import android.content.Context
import com.bedirhandroid.badgesproject.R
import com.bedirhandroid.badgesproject.models.praise.BadgePraiseModel
import com.bedirhandroid.badgesproject.models.praise.RelatedPerson
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

data class RowUi(
    val id: Int? = null,
    val relatedPerson: RelatedPerson? = null,
    val praiseRating: Int? = null,
    val badgePraiseModel: BadgePraiseModel? = null,
    val message: String? = null,
    val createdDate: String? = null
) {
    fun dateMilliSec(): Long {
        val formatter = DateTimeFormatter.ISO_INSTANT
        val instant = Instant.from(formatter.parse(this.createdDate))
        return instant.toEpochMilli()
    }

    fun timeDiffToString(context: Context): String {
        val formatter = DateTimeFormatter.ISO_INSTANT
        val instant = Instant.from(formatter.parse(this.createdDate))


        val dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())

        val now = LocalDateTime.now()

        val yearsAgo = ChronoUnit.YEARS.between(dateTime, now)
        val monthsAgo = ChronoUnit.MONTHS.between(dateTime, now)
        val daysAgo = ChronoUnit.DAYS.between(dateTime, now)
        val hoursAgo = ChronoUnit.HOURS.between(dateTime, now)

        return when {
            yearsAgo > 0 -> context.getString(R.string.txt_dynamic_year, yearsAgo.toInt())
            monthsAgo > 0 -> context.getString(R.string.txt_dynamic_month, monthsAgo.toInt())
            daysAgo > 0 -> context.getString(R.string.txt_dynamic_days, daysAgo.toInt())
            hoursAgo > 0 -> context.getString(R.string.txt_dynamic_hours, hoursAgo.toInt())
            else -> context.getString(R.string.txt_now)
        }
    }


}
