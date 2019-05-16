package com.radik.labs.evo_test_project.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun toDate(timeMillis: Long): String {
    return SimpleDateFormat("dd.MM.yy").format(Date(timeMillis))
}

@SuppressLint("SimpleDateFormat")
fun toTime(timeMillis: Long): String {
    return SimpleDateFormat("kk:mm").format(Date(timeMillis))
}