package me.saechimdaeki.redischatroom

import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.stereotype.Service
import java.util.*

@Service
class ChatService(
    private val container: RedisMessageListenerContainer,
    private val redisTemplate: RedisTemplate<String, String>
) : MessageListener {

    fun enterChatRoom(chatRoomName: String) {

        container.addMessageListener(this, ChannelTopic(chatRoomName))

        val sc = Scanner(System.`in`)

        while (sc.hasNextLine()) {
            val line = sc.nextLine()
            if (line.equals("q")) {
                println("Quit..")
                break
            }
            redisTemplate.convertAndSend(chatRoomName, line);
        }

        container.removeMessageListener(this)
    }

    override fun onMessage(message: Message, pattern: ByteArray?) {
        println("Message $message")
    }
}