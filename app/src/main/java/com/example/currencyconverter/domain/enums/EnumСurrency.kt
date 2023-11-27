package com.example.currencyconverter.domain.enums

import android.content.Context
import com.example.currencyconverter.R

enum class EnumСurrency() {

    AED(),
    AMD(),
    AUD(),
    AZN(),
    BGN(),
    BRL(),
    BYN(),
    CAD(),
    CHF(),
    CNY(),
    CZK(),
    DKK(),
    EGP(),
    EUR(),
    GEL(),
    HKD(),
    HUF(),
    IDR(),
    INR(),
    JPY(),
    KGS(),
    KRW(),
    KZT(),
    MDL(),
    NOK(),
    NZD(),
    PLN(),
    QAR(),
    RON(),
    RSD(),
    SEK(),
    SGD(),
    THB(),
    TJS(),
    TMT(),
    TRY(),
    UAH(),
    USD(),
    UZS(),
    VND(),
    ZAR();

    companion object {
        fun enumToString(enumValue: EnumСurrency, context: Context): String {
            return when (enumValue) {
                EnumСurrency.AED -> context.getString(R.string.united_arab_emirates_dirhams)
                EnumСurrency.AMD -> context.getString(R.string.armenian_drams)
                EnumСurrency.AUD -> context.getString(R.string.australian_dollar)
                EnumСurrency.AZN -> context.getString(R.string.azerbaijani_manat)
                EnumСurrency.BGN -> context.getString(R.string.bulgarian_lion)
                EnumСurrency.BRL -> context.getString(R.string.brazilian_real)
                EnumСurrency.BYN -> context.getString(R.string.belarusian_ruble)
                EnumСurrency.CAD -> context.getString(R.string.canadian_dollar)
                EnumСurrency.CHF -> context.getString(R.string.swiss_franc)
                EnumСurrency.CNY -> context.getString(R.string.chinese_yuan)
                EnumСurrency.CZK -> context.getString(R.string.czech_crowns)
                EnumСurrency.DKK -> context.getString(R.string.danish_krona)
                EnumСurrency.EGP -> context.getString(R.string.egyptian_pounds)
                EnumСurrency.EUR -> context.getString(R.string.euro)
                EnumСurrency.GEL -> context.getString(R.string.georgian_lari)
                EnumСurrency.HKD -> context.getString(R.string.hong_kong_dollar)
                EnumСurrency.HUF -> context.getString(R.string.hungarian_forints)
                EnumСurrency.IDR -> context.getString(R.string.indonesian_rupiah)
                EnumСurrency.INR -> context.getString(R.string.indian_rupees)
                EnumСurrency.JPY -> context.getString(R.string.japanese_yen)
                EnumСurrency.KGS -> context.getString(R.string.kyrgyz_som)
                EnumСurrency.KRW -> context.getString(R.string.won_republic_korea)
                EnumСurrency.KZT -> context.getString(R.string.kazakhstani_tenge)
                EnumСurrency.MDL -> context.getString(R.string.moldovan_lei)
                EnumСurrency.NOK -> context.getString(R.string.norwegian_crowns)
                EnumСurrency.NZD -> context.getString(R.string.new_zealand_dollar)
                EnumСurrency.PLN -> context.getString(R.string.polish_zloty)
                EnumСurrency.QAR -> context.getString(R.string.qatari_rial)
                EnumСurrency.RON -> context.getString(R.string.romanian_leu)
                EnumСurrency.RSD -> context.getString(R.string.serbian_dinars)
                EnumСurrency.SEK -> context.getString(R.string.swedish_crowns)
                EnumСurrency.SGD -> context.getString(R.string.singapore_dollar)
                EnumСurrency.THB -> context.getString(R.string.thai_baht)
                EnumСurrency.TJS -> context.getString(R.string.tajik_somoni)
                EnumСurrency.TMT -> context.getString(R.string.new_turkmen_manat)
                EnumСurrency.TRY -> context.getString(R.string.turkish_lira)
                EnumСurrency.UAH -> context.getString(R.string.ukrainian_hryvnias)
                EnumСurrency.USD -> context.getString(R.string.us_dollar)
                EnumСurrency.UZS -> context.getString(R.string.uzbek_soums)
                EnumСurrency.VND -> context.getString(R.string.vietnamese_dong)
                EnumСurrency.ZAR -> context.getString(R.string.south_african_rands)
            }
        }
    }


}

