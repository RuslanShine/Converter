package com.example.currencyconverter.ui.homeScreen.model

import com.example.currencyconverter.domain.enums.EnumСurrency

data class CurrencyUIState(
    var listInputCurrency: List<EnumСurrency>,
    val inputNameCurrency: EnumСurrency = EnumСurrency.AED,
    val inputMenuPosition: Boolean,
    val inputCurrencyValue: String,


    var listOutputCurrency: List<EnumСurrency>,
    val outputNameCurrency: EnumСurrency = EnumСurrency.AED,
    val outputMenuPosition: Boolean,
    val outputCurrencyValue: String,


    )
