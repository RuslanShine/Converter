package com.example.currencyconverter.ui.homeScreen

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverter.R
import com.example.currencyconverter.data.DataRepository
import com.example.currencyconverter.data.entity.Currencies
import com.example.currencyconverter.domain.enums.EnumСurrency
import com.example.currencyconverter.domain.usecases.RecalculatingValuesСhoiceUseCase
import com.example.currencyconverter.domain.usecases.SetCharCodeValuesUseCase
import com.example.currencyconverter.ui.homeScreen.model.InputCurrencyUIState
import com.example.currencyconverter.ui.homeScreen.model.ItemInputCurrency
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


class HomeViewModel @Inject constructor(val repository: DataRepository) : ViewModel() {

    private val _valuesData: Flow<List<Currencies>>
    val valuesData get() = _valuesData

    val inputCurrencyUIState: StateFlow<InputCurrencyUIState> get() = _inputCurrencyUIState.asStateFlow()
    private val _inputCurrencyUIState = MutableStateFlow(InputCurrencyUIState(listOf(), false, ""))

    init {
        _valuesData = repository.getCurrenciesFromDb()
        loadPosts()
    }

    private val recalculatingValuesUseCase = RecalculatingValuesСhoiceUseCase(valuesData)
    private val setCharCodeValuesUseCase = SetCharCodeValuesUseCase(valuesData)

    fun loadPosts() {
        viewModelScope.launch {

            _valuesData.collect { it ->
                _inputCurrencyUIState.value.listInputCurrency = it.map {
                    ItemInputCurrency(
                        nameCurrency = it.name,
                    )
                }
            }

            try {
                repository.getCurrenciesFromApi()
            } catch (e: Exception) {
                Log.e("HomeViewModel", e.message.toString())
                e.printStackTrace()
            }

        }
    }

    fun openMenu() {
        _inputCurrencyUIState.update { it.copy(inputNumber = true) }
    }

    fun closeMenu() {
        _inputCurrencyUIState.update { it.copy(inputNumber = false) }
    }


    fun recalculatingValues(result: String): Double {
        return recalculatingValuesUseCase.execute(result)
    }

    fun searchFromValRecalculating(nameCurrencyFromVal: Any) {
        recalculatingValuesUseCase.monitoringValueFromVal(nameCurrencyFromVal)
    }

    fun searchToValRecalculating(nameCurrencyToVal: Any) {
        recalculatingValuesUseCase.monitoringValueToVal(nameCurrencyToVal)
    }

    fun searchValueFromVal(nameCurrencyScreen: Any) {
        setCharCodeValuesUseCase.monitoringValueFromVal(nameCurrencyScreen)
    }

    fun setCurrencyNameFromVal(): String {
        return setCharCodeValuesUseCase.executeFromVal()
    }

    fun searchValueToVal(nameCurrencyScreenToVal: Any) {
        setCharCodeValuesUseCase.monitoringValueToVal(nameCurrencyScreenToVal)
    }

    fun setCurrencyNameToVal(): String {
        return setCharCodeValuesUseCase.executeToVal()
    }

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
