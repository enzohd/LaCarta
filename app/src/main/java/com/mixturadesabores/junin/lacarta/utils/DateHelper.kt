package com.mixturadesabores.junin.lacarta.utils

import java.text.SimpleDateFormat
import java.util.*

class DateHelper {

    companion object {

        private val utcFormatText = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
        private val simpleFormatText = "hh:mm aa"
        private val utcFormat = SimpleDateFormat(utcFormatText)
        private val simpleFormat = SimpleDateFormat(simpleFormatText)

        fun getDateFromUTC(string: String): Date {
            return utcFormat.parse(string)
        }

        fun getSimpleFormat(date: Date): String {
            return simpleFormat.format(date)
        }
    }
}
