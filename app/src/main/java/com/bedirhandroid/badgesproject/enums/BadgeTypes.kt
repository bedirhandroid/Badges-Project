package com.bedirhandroid.badgesproject.enums

enum class BadgeTypes(val lookupId: Int) {
    DEGER_KATAN(3),
    DEGISIME_ACIK(4),
    ISINE_HAKIM(5),
    LIDER(6),
    SORUN_COZEN(7),
    TAKIM_OYUNCUSU(8),
    TESEKKUR(9),
    YARATICI(10),
    YENILIKCI(11);

    companion object {
        fun fromInt(value: Int): BadgeTypes? {
            return values().find { it.lookupId == value }
        }
    }
}