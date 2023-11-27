package com.example.currencyconverter.ui.homeScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverter.data.DataRepository
import com.example.currencyconverter.data.entity.Currencies
import com.example.currencyconverter.domain.enums.EnumСurrency
import com.example.currencyconverter.domain.usecases.RecalculatingValuesСhoiceUseCase
import com.example.currencyconverter.domain.usecases.SetCharCodeValuesUseCase
import com.example.currencyconverter.ui.homeScreen.model.CurrencyUIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


class HomeViewModel @Inject constructor(val repository: DataRepository) : ViewModel() {

    private val _valuesData: Flow<List<Currencies>>
    val valuesData get() = _valuesData

    val currencyUIState: StateFlow<CurrencyUIState> get() = _currencyUIState.asStateFlow()
    private val _currencyUIState = MutableStateFlow(
        CurrencyUIState(
            listInputCurrency = listOf(),
            inputNameCurrency = EnumСurrency.AED,
            inputMenuPosition = false,
            inputCurrencyValue = "",
            listOutputCurrency = listOf(),
            outputNameCurrency = EnumСurrency.AED,
            outputMenuPosition = false,
            outputCurrencyValue = ""
        )
    )

    init {
        _valuesData = repository.getCurrenciesFromDb()
        loadPosts()

    }

    private val recalculatingValuesUseCase = RecalculatingValuesСhoiceUseCase(valuesData)
    private val setCharCodeValuesUseCase = SetCharCodeValuesUseCase(valuesData)

    fun loadPosts() {
        viewModelScope.launch {

            _valuesData.collect { it ->
                _currencyUIState.value.listInputCurrency = it.map {
                    EnumСurrency.valueOf(it.charCode)
                }

                _currencyUIState.value.listOutputCurrency = it.map {
                    EnumСurrency.valueOf(it.charCode)
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

    fun openMenuInputCurrency() {
        _currencyUIState.update { it.copy(inputMenuPosition = true) }
    }

    fun closeMenuInputCurrency() {
        _currencyUIState.update { it.copy(inputMenuPosition = false) }
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


    fun setInputCurrency(name: EnumСurrency) {
        _currencyUIState.update { it.copy(inputNameCurrency = name) }
    }

    fun setInputCurrencyValue(value: String) {
        _currencyUIState.update { it.copy(inputCurrencyValue = value) }
    }

    fun setEmptyInputCurrencyValue() {
        _currencyUIState.update { it.copy(inputCurrencyValue = "") }
    }


    fun openMenuOutputCurrency() {
        _currencyUIState.update { it.copy(outputMenuPosition = true) }
    }

    fun closeMenuOutputCurrency() {
        _currencyUIState.update { it.copy(outputMenuPosition = false) }
    }

    fun setOutputCurrency(name: EnumСurrency) {
        _currencyUIState.update { it.copy(outputNameCurrency = name) }
    }

    fun setOutputCurrencyValue(value: String) {
        _currencyUIState.update { it.copy(outputCurrencyValue = value) }
    }

    fun setEmptyOutputCurrencyValue() {
        _currencyUIState.update { it.copy(outputCurrencyValue = "") }
    }


}
