package com.example.currencyconverter.ui.homeScreen.content

import android.annotation.SuppressLint
import android.content.Context
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


@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun MainScreen(context: Context, viewModel: HomeViewModel) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val uiStateListInputCurrency by viewModel.currencyUIState.collectAsState()

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
                                viewModel.openMenuInputCurrency()
                            }, verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = EnumСurrency.enumToString(
                                        uiStateListInputCurrency.inputNameCurrency,
                                        context
                                    ),
                                    fontSize = FontSizes._18,
                                    color = Color.Black
                                )
                                Icon(
                                    imageVector = Icons.Filled.ArrowDropDown,
                                    contentDescription = null
                                )
                                DropdownMenu(expanded = uiStateListInputCurrency.inputMenuPosition,
                                    onDismissRequest = { viewModel.closeMenuInputCurrency() }) {
                                    uiStateListInputCurrency.listInputCurrency.forEach {
                                        DropdownMenuItem(
                                            text = {
                                                Text(
                                                    text = EnumСurrency.enumToString(
                                                        it,
                                                        context
                                                    )
                                                )
                                            },
                                            onClick = {
                                                viewModel.setInputCurrency(it)

                                                viewModel.closeMenuInputCurrency()


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
                            OutlinedTextField(value = uiStateListInputCurrency.inputCurrencyValue,
                                onValueChange = { viewModel.setInputCurrencyValue(it) },

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
                                                viewModel.setEmptyInputCurrencyValue()
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
                                viewModel.openMenuOutputCurrency()
                            }, verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = EnumСurrency.enumToString(
                                        uiStateListInputCurrency.outputNameCurrency,
                                        context
                                    ),
                                    fontSize = FontSizes._18,
                                    color = Color.Black
                                )
                                Icon(
                                    imageVector = Icons.Filled.ArrowDropDown,
                                    contentDescription = null
                                )
                                DropdownMenu(expanded = uiStateListInputCurrency.outputMenuPosition,
                                    onDismissRequest = { viewModel.closeMenuOutputCurrency() }) {
                                    uiStateListInputCurrency.listOutputCurrency.forEach {
                                        DropdownMenuItem(
                                            text = {
                                                Text(
                                                    text = EnumСurrency.enumToString(
                                                        it,
                                                        context
                                                    )
                                                )
                                            },
                                            onClick = {
                                                viewModel.setOutputCurrency(it)

                                                viewModel.closeMenuOutputCurrency()

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
                            OutlinedTextField(value = uiStateListInputCurrency.outputCurrencyValue,
                                onValueChange = { viewModel.setOutputCurrencyValue(it) },
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
                                                viewModel.setEmptyOutputCurrencyValue()
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




