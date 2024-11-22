package com.example.git.domain

import com.example.git.data.GitHubUser

interface GitHubRepository {
    suspend fun getUser(username: String): Result<GithubUserModel>
}
data class GithubUserModel(
    val login: String,
    val id: Int,
    val avatarUrl: String,
    val name: String?,
    val company: String?,
    val blog: String?,
    val location: String?,
    val email: String?,
    val bio: String?,
    val publicRepos: Int,
    val followers: Int,
    val following: Int,
    val createdAt: String
)