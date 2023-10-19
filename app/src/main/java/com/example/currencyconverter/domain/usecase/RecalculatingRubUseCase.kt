package com.example.currencyconverter.domain.usecase

import com.example.currencyconverter.data.entity.Currencies
import com.example.currencyconverter.domain.usecase.ParametersСurrency.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

class RecalculatingRubUseCase(private val valuesData: Flow<Currencies>) {
    private lateinit var scope: CoroutineScope
    private var resultAED by Delegates.notNull<Double>()
    private var resultAMD by Delegates.notNull<Double>()
    private var resultAUD by Delegates.notNull<Double>()
    private var resultAZN by Delegates.notNull<Double>()
    private var resultBGN by Delegates.notNull<Double>()
    private var resultBRL by Delegates.notNull<Double>()
    private var resultBYN by Delegates.notNull<Double>()
    private var resultCAD by Delegates.notNull<Double>()
    private var resultCHF by Delegates.notNull<Double>()
    private var resultCNY by Delegates.notNull<Double>()
    private var resultCZK by Delegates.notNull<Double>()
    private var resultDKK by Delegates.notNull<Double>()
    private var resultEGP by Delegates.notNull<Double>()
    private var resultEUR by Delegates.notNull<Double>()
    private var resultGEL by Delegates.notNull<Double>()
    private var resultHKD by Delegates.notNull<Double>()
    private var resultHUF by Delegates.notNull<Double>()
    private var resultIDR by Delegates.notNull<Double>()
    private var resultINR by Delegates.notNull<Double>()
    private var resultJPY by Delegates.notNull<Double>()
    private var resultKGS by Delegates.notNull<Double>()
    private var resultKRW by Delegates.notNull<Double>()
    private var resultKZT by Delegates.notNull<Double>()
    private var resultMDL by Delegates.notNull<Double>()
    private var resultNOK by Delegates.notNull<Double>()
    private var resultNZD by Delegates.notNull<Double>()
    private var resultPLN by Delegates.notNull<Double>()
    private var resultQAR by Delegates.notNull<Double>()
    private var resultRON by Delegates.notNull<Double>()
    private var resultRSD by Delegates.notNull<Double>()
    private var resultSEK by Delegates.notNull<Double>()
    private var resultSGD by Delegates.notNull<Double>()
    private var resultTHB by Delegates.notNull<Double>()
    private var resultTJS by Delegates.notNull<Double>()
    private var resultTMT by Delegates.notNull<Double>()
    private var resultTRY by Delegates.notNull<Double>()
    private var resultUAH by Delegates.notNull<Double>()
    private var resultUSD by Delegates.notNull<Double>()
    private var resultUZS by Delegates.notNull<Double>()
    private var resultVND by Delegates.notNull<Double>()
    private var resultZAR by Delegates.notNull<Double>()

    fun execute(param: String) {
        val userParamsConvert = param.toDouble()
        scope = CoroutineScope(Dispatchers.IO).also { scope ->
            scope.launch {
                valuesData.collect { db ->
                    resultAED = AED_VALUE.getValueRUB(db, userParamsConvert)
                    resultAMD = AMD_VALUE.getValueRUB(db, userParamsConvert)
                    resultAUD = AUD_VALUE.getValueRUB(db, userParamsConvert)
                    resultAZN = AZN_VALUE.getValueRUB(db, userParamsConvert)
                    resultBGN = BGN_VALUE.getValueRUB(db, userParamsConvert)
                    resultBRL = BRL_VALUE.getValueRUB(db, userParamsConvert)
                    resultBYN = BYN_VALUE.getValueRUB(db, userParamsConvert)
                    resultCAD = CAD_VALUE.getValueRUB(db, userParamsConvert)
                    resultCHF = CHF_VALUE.getValueRUB(db, userParamsConvert)
                    resultCNY = CNY_VALUE.getValueRUB(db, userParamsConvert)
                    resultCZK = CZK_VALUE.getValueRUB(db, userParamsConvert)
                    resultDKK = DKK_VALUE.getValueRUB(db, userParamsConvert)
                    resultEGP = EGP_VALUE.getValueRUB(db, userParamsConvert)
                    resultEUR = EUR_VALUE.getValueRUB(db, userParamsConvert)
                    resultGEL = GEL_VALUE.getValueRUB(db, userParamsConvert)
                    resultHKD = HKD_VALUE.getValueRUB(db, userParamsConvert)
                    resultHUF = HUF_VALUE.getValueRUB(db, userParamsConvert)
                    resultIDR = IDR_VALUE.getValueRUB(db, userParamsConvert)
                    resultINR = INR_VALUE.getValueRUB(db, userParamsConvert)
                    resultJPY = JPY_VALUE.getValueRUB(db, userParamsConvert)
                    resultKGS = KGS_VALUE.getValueRUB(db, userParamsConvert)
                    resultKRW = KRW_VALUE.getValueRUB(db, userParamsConvert)
                    resultKZT = KZT_VALUE.getValueRUB(db, userParamsConvert)
                    resultMDL = MDL_VALUE.getValueRUB(db, userParamsConvert)
                    resultNOK = NOK_VALUE.getValueRUB(db, userParamsConvert)
                    resultNZD = NZD_VALUE.getValueRUB(db, userParamsConvert)
                    resultPLN = PLN_VALUE.getValueRUB(db, userParamsConvert)
                    resultQAR = QAR_VALUE.getValueRUB(db, userParamsConvert)
                    resultRON = RON_VALUE.getValueRUB(db, userParamsConvert)
                    resultRSD = RSD_VALUE.getValueRUB(db, userParamsConvert)
                    resultSEK = SEK_VALUE.getValueRUB(db, userParamsConvert)
                    resultSGD = SGD_VALUE.getValueRUB(db, userParamsConvert)
                    resultTHB = THB_VALUE.getValueRUB(db, userParamsConvert)
                    resultTJS = TJS_VALUE.getValueRUB(db, userParamsConvert)
                    resultTMT = TMT_VALUE.getValueRUB(db, userParamsConvert)
                    resultTRY = TRY_VALUE.getValueRUB(db, userParamsConvert)
                    resultUAH = UAH_VALUE.getValueRUB(db, userParamsConvert)
                    resultUSD = USD_VALUE.getValueRUB(db, userParamsConvert)
                    resultUZS = UZS_VALUE.getValueRUB(db, userParamsConvert)
                    resultVND = VND_VALUE.getValueRUB(db, userParamsConvert)
                    resultZAR = ZAR_VALUE.getValueRUB(db, userParamsConvert)

                }
            }
        }
    }

    fun getResultAed(): Double {
        return resultAED
    }

    fun getResultAmd(): Double {
        return resultAMD
    }

    fun getResultAud(): Double {
        return resultAUD
    }

    fun getResultAzn(): Double {
        return resultAZN
    }

    fun getResultBgn(): Double {
        return resultBGN
    }

    fun getResultBrl(): Double {
        return resultBRL
    }

    fun getResultByn(): Double {
        return resultBYN
    }

    fun getResultCad(): Double {
        return resultCAD
    }

    fun getResultChf(): Double {
        return resultCHF
    }

    fun getResultCny(): Double {
        return resultCNY
    }

    fun getResultCzk(): Double {
        return resultCZK
    }

    fun getResultDkk(): Double {
        return resultDKK
    }

    fun getResultEgp(): Double {
        return resultEGP
    }

    fun getResultEur(): Double {
        return resultEUR
    }

    fun getResultGel(): Double {
        return resultGEL
    }

    fun getResultHkd(): Double {
        return resultHKD
    }

    fun getResultHuf(): Double {
        return resultHUF
    }

    fun getResultIdr(): Double {
        return resultIDR
    }

    fun getResultInr(): Double {
        return resultINR
    }

    fun getResultJpy(): Double {
        return resultJPY
    }

    fun getResultKgs(): Double {
        return resultKGS
    }

    fun getResultKrw(): Double {
        return resultKRW
    }

    fun getResultKzt(): Double {
        return resultKZT
    }

    fun getResultMdl(): Double {
        return resultMDL
    }

    fun getResultNok(): Double {
        return resultNOK
    }

    fun getResultNzd(): Double {
        return resultNZD
    }

    fun getResultPln(): Double {
        return resultPLN
    }

    fun getResultQar(): Double {
        return resultQAR
    }

    fun getResultRon(): Double {
        return resultRON
    }

    fun getResultRsd(): Double {
        return resultRSD
    }

    fun getResultSek(): Double {
        return resultSEK
    }

    fun getResultSgd(): Double {
        return resultSGD
    }

    fun getResultThb(): Double {
        return resultTHB
    }

    fun getResultTjs(): Double {
        return resultTJS
    }

    fun getResultTmt(): Double {
        return resultTMT
    }

    fun getResultTry(): Double {
        return resultTRY
    }

    fun getResultUah(): Double {
        return resultUAH
    }

    fun getResultUsd(): Double {
        return resultUSD
    }

    fun getResultUzs(): Double {
        return resultUZS
    }

    fun getResultVnd(): Double {
        return resultVND
    }

    fun getResultZar(): Double {
        return resultZAR
    }

}