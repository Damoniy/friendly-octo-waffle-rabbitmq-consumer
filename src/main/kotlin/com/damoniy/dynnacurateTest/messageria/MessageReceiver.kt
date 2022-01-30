package com.damoniy.dynnacurateTest.messageria

import com.damoniy.dynnacurateTest.json.JSONUtil
import com.rabbitmq.client.Channel
import com.rabbitmq.client.DeliverCallback
import com.rabbitmq.client.Delivery
import org.json.JSONObject

interface MessageReceiver {
    fun listen(channel: Channel, queue: String) {
        val deliverCallback = DeliverCallback { _: String?, delivery: Delivery ->
            jsonContextLoop(JSONUtil.stringToJson(String(delivery.body)))
        }
        consume(channel, queue, deliverCallback)
    }

    private fun consume(channel: Channel, queue: String, deliverCallback: DeliverCallback, ) {
        channel.basicConsume(queue, true, deliverCallback) { _: String? -> }
    }

    fun jsonContextLoop(jsonObject: JSONObject)
}