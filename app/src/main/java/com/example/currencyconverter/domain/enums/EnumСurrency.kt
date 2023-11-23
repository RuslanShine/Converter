package com.example.currencyconverter.domain.enums

import android.content.Context
import com.example.currencyconverter.R

enum class EnumСurrency(val nameCurrency: String) {

    AED("Дирхам ОАЭ"),
    AMD("Армянских драмов"),
    AUD("Австралийский доллар"),
    AZN("Азербайджанский манат"),
    BGN("Болгарский лев"),
    BRL("Бразильский реал"),
    BYN("Белорусский рубль"),
    CAD("Канадский доллар"),
    CHF("Швейцарский франк"),
    CNY("Китайский юань"),
    CZK("Чешских крон"),
    DKK("Датская крона"),
    EGP("Египетских фунтов"),
    EUR("Евро"),
    GEL("Грузинский лари"),
    HKD("Гонконгский доллар"),
    HUF("Венгерских форинтов"),
    IDR("Индонезийских рупий"),
    INR("Индийских рупий"),
    JPY("Японских иен"),
    KGS("Киргизских сомов"),
    KRW("Вон Республики Корея"),
    KZT("Казахстанских тенге"),
    MDL("Молдавских леев"),
    NOK("Норвежских крон"),
    NZD("Новозеландский доллар"),
    PLN("Польский злотый"),
    QAR("Катарский риал"),
    RON("Румынский лей"),
    RSD("Сербских динаров"),
    SEK("Шведских крон"),
    SGD("Сингапурский доллар"),
    THB("Таиландских батов"),
    TJS("Таджикских сомони"),
    TMT("Новый туркменский манат"),
    TRY("Турецких лир"),
    UAH("Украинских гривен"),
    USD("Доллар США"),
    UZS("Узбекских сумов"),
    VND("Вьетнамских донгов"),
    ZAR("Южноафриканских рэндов");

    fun Context.enumToString(enumValue: EnumСurrency): String {
        return when (enumValue) {
            EnumСurrency.AED -> getString(R.string.united_arab_emirates_dirhams)
            EnumСurrency.AMD -> getString(R.string.armenian_drams)
            EnumСurrency.AUD -> getString(R.string.australian_dollar)
            EnumСurrency.AZN -> getString(R.string.azerbaijani_manat)
            EnumСurrency.BGN -> getString(R.string.bulgarian_lion)
            EnumСurrency.BRL -> getString(R.string.brazilian_real)
            EnumСurrency.BYN -> getString(R.string.belarusian_ruble)
            EnumСurrency.CAD -> getString(R.string.canadian_dollar)
            EnumСurrency.CHF -> getString(R.string.swiss_franc)
            EnumСurrency.CNY -> getString(R.string.chinese_yuan)
            EnumСurrency.CZK -> getString(R.string.czech_crowns)
            EnumСurrency.DKK -> getString(R.string.danish_krona)
            EnumСurrency.EGP -> getString(R.string.egyptian_pounds)
            EnumСurrency.EUR -> getString(R.string.euro)
            EnumСurrency.GEL -> getString(R.string.georgian_lari)
            EnumСurrency.HKD -> getString(R.string.hong_kong_dollar)
            EnumСurrency.HUF -> getString(R.string.hungarian_forints)
            EnumСurrency.IDR -> getString(R.string.indonesian_rupiah)
            EnumСurrency.INR -> getString(R.string.indian_rupees)
            EnumСurrency.JPY -> getString(R.string.japanese_yen)
            EnumСurrency.KGS -> getString(R.string.kyrgyz_som)
            EnumСurrency.KRW -> getString(R.string.won_republic_korea)
            EnumСurrency.KZT -> getString(R.string.kazakhstani_tenge)
            EnumСurrency.MDL -> getString(R.string.moldovan_lei)
            EnumСurrency.NOK -> getString(R.string.norwegian_crowns)
            EnumСurrency.NZD -> getString(R.string.new_zealand_dollar)
            EnumСurrency.PLN -> getString(R.string.polish_zloty)
            EnumСurrency.QAR -> getString(R.string.qatari_rial)
            EnumСurrency.RON -> getString(R.string.romanian_leu)
            EnumСurrency.RSD -> getString(R.string.serbian_dinars)
            EnumСurrency.SEK -> getString(R.string.swedish_crowns)
            EnumСurrency.SGD -> getString(R.string.singapore_dollar)
            EnumСurrency.THB -> getString(R.string.thai_baht)
            EnumСurrency.TJS -> getString(R.string.tajik_somoni)
            EnumСurrency.TMT -> getString(R.string.new_turkmen_manat)
            EnumСurrency.TRY -> getString(R.string.turkish_lira)
            EnumСurrency.UAH -> getString(R.string.ukrainian_hryvnias)
            EnumСurrency.USD -> getString(R.string.us_dollar)
            EnumСurrency.UZS -> getString(R.string.uzbek_soums)
            EnumСurrency.VND -> getString(R.string.vietnamese_dong)
            EnumСurrency.ZAR -> getString(R.string.south_african_rands)
            else -> {
                "123"
            }
        }
    }
}

