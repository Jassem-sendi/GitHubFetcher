package com.example.git.data

import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


object GitHubApi {
    private val client = HttpClient (Android) {
       install(ContentNegotiation){
           json(Json {
                ignoreUnknownKeys = true
                isLenient = true
           })
       }
    }

    suspend fun getUser(username: String): GitHubUser {
        return client.get("https://api.github.com/users/$username").body()
    }
}