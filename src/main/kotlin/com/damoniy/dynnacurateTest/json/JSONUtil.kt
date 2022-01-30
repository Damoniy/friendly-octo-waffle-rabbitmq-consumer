package com.damoniy.dynnacurateTest.json

import org.json.JSONObject

object JSONUtil {
    fun stringToJson(string: String): JSONObject {
        return JSONObject(string)
    }

    fun getInteger(value: String): Int {
        return Integer.parseInt(value)
    }
}