package com.example.git.data

import com.example.git.domain.GitHubRepository
import com.example.git.domain.GithubUserModel
import org.koin.core.annotation.Single

@Single
class GitHubRepositoryImpl : GitHubRepository {
    override suspend fun getUser(username: String): Result<GithubUserModel> =
        runCatching {
           GitHubApi.getUser(username).toGithubUserModel()
        }
}