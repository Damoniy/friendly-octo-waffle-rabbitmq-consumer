package com.damoniy.dynnacurateTest.messageria

import com.damoniy.dynnacurateTest.mapper.EventMapper
import com.damoniy.dynnacurateTest.persistence.PersistentObject
import org.json.JSONObject
import javax.persistence.Persistence

class PacketManager: MessageReceiver {
    private val factory = Persistence.createEntityManagerFactory("user-events")
    private val entityManager = factory.createEntityManager()

    override fun jsonContextLoop(jsonObject: JSONObject) {
        persist(EventMapper.map(jsonObject))
        println(jsonObject.toString())
    }

    private fun persist(obj: PersistentObject) {
        entityManager.transaction.begin()
        entityManager.persist(obj)
        entityManager.transaction.commit()
    }
}