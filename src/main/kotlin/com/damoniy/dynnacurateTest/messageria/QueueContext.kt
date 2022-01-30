package com.damoniy.dynnacurateTest.messageria

import com.damoniy.dynnacurateTest.messageria.connection.RabbitConnector
import com.rabbitmq.client.Channel

object QueueContext {
    private val connector = RabbitConnector()

    fun createContext(queue: String) {
        connect()
        val channel = createChannel()
        PacketManager().listen(channel = channel, queue = queue)
    }

    private fun createChannel(): Channel {
        return connector.getChannel()
    }

    private fun connect() {
        connector.connect()
    }
}