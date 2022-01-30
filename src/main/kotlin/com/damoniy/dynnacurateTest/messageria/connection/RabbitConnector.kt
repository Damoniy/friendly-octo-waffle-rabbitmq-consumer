package com.damoniy.dynnacurateTest.messageria.connection

import com.rabbitmq.client.*

class RabbitConnector {
    private val connectionFactory = ConnectionFactory()
    private lateinit var connection: Connection

    init {
        connectionFactory.setUri("amqps://qmshcfth:t2vIixo-qqsUcNzuzvnWyTEAU55l09DS@fox.rmq.cloudamqp.com/qmshcfth")
    }

    fun connect() {
        this.connection = connectionFactory.newConnection()
    }

    fun getChannel(): Channel {
        return connection.createChannel()
    }
}