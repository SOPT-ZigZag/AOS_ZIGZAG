package org.sopt.util

import java.text.DecimalFormat

object NumberUtil {
    fun convertIntToDecimalString(num : Int) : String {
        val convertNum = (num.toDouble() / 10000).toString()
        return convertNum.format("%.1f") + "만"
    }

    fun convertIntToMoneyString(num : Int) : String {
        val moneyFormat = DecimalFormat("###,###")
        return moneyFormat.format(num)
    }
}