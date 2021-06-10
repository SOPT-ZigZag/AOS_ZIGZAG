package org.sopt.util

import java.text.DecimalFormat

object NumberUtil {
    fun convertIntToDecimalString(num : Int) : String {
        val convertNum = (num.toDouble() / 10000).toString()
        return convertNum.format("%.1f") + "만"
    }

    fun convertIntToCouponString(num : Int) : String {
        val couponFormat = DecimalFormat("###,###")
        return "최대 " + couponFormat.format(num) + "원 쿠폰"
    }
}