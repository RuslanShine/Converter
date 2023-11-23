package com.example.currencyconverter.ui.homeScreen.content

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.currencyconverter.R
import com.example.currencyconverter.domain.enums.EnumСurrency
import com.example.currencyconverter.theme.ButtonColors
import com.example.currencyconverter.theme.Dimens
import com.example.currencyconverter.theme.FontSizes
import com.example.currencyconverter.theme.Purple40
import com.example.currencyconverter.theme.Purple80
import com.example.currencyconverter.ui.homeScreen.HomeViewModel
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun MainScreen(context: Context, viewModel: HomeViewModel) {
    val keyboardController = LocalSoftwareKeyboardController.current


    val uiStateListInputCurrency by viewModel.inputCurrencyUIState.collectAsState()

    val listСurrencyName =
        EnumСurrency.values().map { it.nameCurrency } + stringResource(R.string.choose_currency)

    val listСurrencyInput = uiStateListInputCurrency.listInputCurrency
    var inputNumber = uiStateListInputCurrency.inputNumber
    var currentInputCurrency = uiStateListInputCurrency.listInputCurrency
    var currencyNameInput = uiStateListInputCurrency.currencyNameInput

    val listСurrencyOutput = uiStateListInputCurrency.listInputCurrency
    val outputNumber = remember { mutableStateOf(false) }
    val currentOutputCurrency = remember { mutableStateOf(listСurrencyOutput[41]) }
    var currencyNameOutput by remember { mutableStateOf("") }


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimens._8),
            shape = RoundedCornerShape(Dimens._16),
            elevation = CardDefaults.cardElevation(defaultElevation = Dimens._4)
        ) {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .background(Color.White)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(Dimens._8),
                    colors = CardDefaults.cardColors(Purple40)
                ) {
                    Box(
                        contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier.padding(Dimens._4),
                            text = stringResource(R.string.currency_converter),
                            color = Color.Black,
                            fontSize = FontSizes._24
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(Dimens._156)
                        .padding(Dimens._8),
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = Dimens._12),
                            contentAlignment = Alignment.TopCenter
                        ) {
                            Row(modifier = Modifier.clickable {
                                viewModel.openMenu()
                            }, verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = currentInputCurrency[1].nameCurrency,
                                    fontSize = FontSizes._18,
                                    color = Color.Black
                                )
                                Icon(
                                    imageVector = Icons.Filled.ArrowDropDown,
                                    contentDescription = null
                                )
                                DropdownMenu(expanded = inputNumber,
                                    onDismissRequest = { viewModel.closeMenu() }) {
                                    listСurrencyInput.forEach {
                                        DropdownMenuItem(
                                            text = { Text(text = it.nameCurrency ) },
                                            onClick = {
                                                currentInputCurrency = it

                                                viewModel.closeMenu()


//                                                viewModel.searchFromValRecalculating(it)
//                                                viewModel.searchValueFromVal(it)
                                            },
                                            modifier = Modifier.background(Color.White),
                                        )
                                    }
                                }
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(Dimens._8),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                text = viewModel.setCurrencyNameFromVal(),
                                fontSize = FontSizes._24,
                                color = Color.Black
                            )
                            OutlinedTextField(value = currencyNameInput,
                                onValueChange = { currencyNameInput = it },

                                modifier = Modifier.width(Dimens._240),
                                textStyle = androidx.compose.ui.text.TextStyle(
                                    fontSize = FontSizes._24
                                ),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = Color.White,
                                    unfocusedBorderColor = Color.White,
                                    textColor = Color.Black
                                ),
                                placeholder = { Text(stringResource(R.string._0)) },
                                trailingIcon = {
                                    Icon(Icons.Default.Clear,
                                        contentDescription = stringResource(R.string.clear_text),
                                        modifier = Modifier
                                            .clickable {
                                                currencyNameInput = ""
                                            }
                                    )
                                }
                            )
                        }
                    }
                }


                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(Dimens._156)
                        .padding(Dimens._8)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Purple80)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = Dimens._12),
                            contentAlignment = Alignment.TopCenter
                        ) {
                            Row(modifier = Modifier.clickable {
                                outputNumber.value = !outputNumber.value
                            }, verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = currentOutputCurrency.value.nameCurrency,
                                    fontSize = FontSizes._18,
                                    color = Color.Black
                                )
                                Icon(
                                    imageVector = Icons.Filled.ArrowDropDown,
                                    contentDescription = null
                                )
                                DropdownMenu(expanded = outputNumber.value,
                                    onDismissRequest = { outputNumber.value = false }) {
                                    listСurrencyOutput.forEach {
                                        DropdownMenuItem(
                                            text = { Text(text = it.nameCurrency) },
                                            onClick = {
                                                currentOutputCurrency.value = it
                                                outputNumber.value = false

//                                                viewModel.searchToValRecalculating(it)
//                                                viewModel.searchValueToVal(it)
                                            },
                                            modifier = Modifier.background(Color.White)
                                        )
                                    }
                                }

                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                text = viewModel.setCurrencyNameToVal(),
                                fontSize = FontSizes._24,
                                color = Color.Black
                            )
                            OutlinedTextField(value = currencyNameOutput,
                                onValueChange = { currencyNameOutput = it },
                                modifier = Modifier.width(Dimens._240),
                                textStyle = androidx.compose.ui.text.TextStyle(
                                    fontSize = FontSizes._24
                                ),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = Color.White,
                                    unfocusedBorderColor = Color.White,
                                    textColor = Color.Black
                                ),
                                placeholder = { Text(stringResource(R.string._0)) },
                                trailingIcon = {
                                    Icon(Icons.Default.Clear,
                                        contentDescription = stringResource(R.string.clear_text),
                                        modifier = Modifier
                                            .clickable {
                                                currencyNameOutput = ""
                                            }
                                    )
                                }
                            )
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = Dimens._36, bottom = Dimens._36),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = {
//                            if (currentInputCurrency != listСurrencyInput[41]) {
//                                if (currentOutputCurrency.value != listСurrencyInput[41]) {
//                                    currencyNameOutput = if (currencyNameInput.isNotEmpty()) {
//                                        val resultFinish = viewModel.recalculatingValues(currencyNameInput)
//                                        String.format("%.3f", resultFinish)
//                                    } else {
//                                        "0"
//                                    }
//                                } else {
//                                    Toast.makeText(
//                                        context,
//                                        R.string.select_conversion_currency, Toast.LENGTH_SHORT).show()
//                                }
//                            } else {
//                                Toast.makeText(
//                                    context,
//                                    R.string.select_convertible_currency, Toast.LENGTH_SHORT).show()
//                            }
                            keyboardController?.hide()
                        },
                        modifier = Modifier.width(Dimens._320),
                        colors = ButtonDefaults.buttonColors(ButtonColors)
                    ) {
                        Text(stringResource(R.string.convert), fontSize = FontSizes._24)

                    }
                }
            }
        }
    }
}




