package com.example.currencyconverter.ui.homeScreen.model

import com.example.currencyconverter.domain.enums.EnumСurrency

data class InputCurrencyUIState(
    var listInputCurrency: List<EnumСurrency>,
    val inputNameCurrency:EnumСurrency = EnumСurrency.AED,
    val inputMenuPosition:Boolean,
    val inputCurrencyValue:String


)
