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



//    fun Context.enumToString(enumValue: EnumСurrency):String{
//        return when(enumValue){
//            AED.nameCurrency->getString(R.string.united_arab_emirates_dirhams)
//            AMD.nameCurrency->getString(R.string.armenian_drams)
//            else -> {"123"}
//        }
//    }

}

