package com.example.currencyconverter.domain.usecases

import com.example.currencyconverter.data.entity.Currencies
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class SetCharCodeValuesUseCase(private val valuesData: Flow<List<Currencies>>) {
    private lateinit var scope: CoroutineScope
    private var nameCurrencyFromVal = "VAL"
    private var nameCurrencyToVal = "VAL"

    fun executeFromVal(): String {
        return nameCurrencyFromVal
    }

    fun executeToVal(): String {
        return nameCurrencyToVal
    }

     fun monitoringValueFromVal(nameCurrencyScreen: Any) {
        scope = CoroutineScope(Dispatchers.IO).also { scope ->
            scope.launch {
                valuesData.collect { database ->
                   nameCurrencyFromVal = database.find { it.name == nameCurrencyScreen }?.charCode!!
                }
            }
        }
    }

     fun monitoringValueToVal(nameCurrencyScreenToVal: Any) {
        scope = CoroutineScope(Dispatchers.IO).also { scope ->
            scope.launch {
                valuesData.collect { database ->
                    nameCurrencyToVal = database.find { it.name == nameCurrencyScreenToVal }?.charCode!!
                }
            }
        }
    }
}