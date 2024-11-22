package com.example.git.data

import com.example.git.domain.GithubUserModel
import kotlinx.serialization.Serializable

@Serializable
data class GitHubUser(
    val login: String,
    val id: Int,
    val avatar_url: String,
    val name: String?,
    val company: String?,
    val blog: String?,
    val location: String?,
    val email: String?,
    val bio: String?,
    val public_repos: Int,
    val followers: Int,
    val following: Int,
    val created_at: String
){
    fun toGithubUserModel(): GithubUserModel {
        return GithubUserModel(
            login = login,
            id = id,
            avatarUrl = avatar_url,
            name = name,
            company = company,
            blog = blog,
            location = location,
            email = email,
            bio = bio,
            publicRepos = public_repos,
            followers = followers,
            following = following,
            createdAt = created_at
        )
    }
}