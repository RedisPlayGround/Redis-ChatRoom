package me.saechimdaeki.redischatroom

import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.listener.RedisMessageListenerContainer

@Configuration
class RedisConfig(private val chatService: ChatService) {

    @Bean
    fun redisConnectionFactory() : RedisConnectionFactory {
        return LettuceConnectionFactory()
    }

    @Bean
    fun redisContainer() : RedisMessageListenerContainer {
        return RedisMessageListenerContainer().also {
            it.setConnectionFactory(redisConnectionFactory())
        }
    }

    @PostConstruct
    fun init () {
        chatService.enterChatRoom("chat1")
    }
}