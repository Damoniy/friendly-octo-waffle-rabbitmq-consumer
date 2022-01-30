package com.damoniy.dynnacurateTest.mapper

import com.damoniy.dynnacurateTest.entity.Event
import com.damoniy.dynnacurateTest.json.JSONUtil
import org.json.JSONObject

object EventMapper {
    fun map(jsonObject: JSONObject): Event {
        val id: Int = JSONUtil.getInteger(jsonObject.getJSONObject("event").getString("id"))
        val eventType: String = jsonObject.getJSONObject("event").getString("eventType")
        val eventDateTime: String = jsonObject.getJSONObject("event").getString("eventDateTime")
        return Event(id = id, eventType = eventType, eventDateTime = eventDateTime)
    }
}