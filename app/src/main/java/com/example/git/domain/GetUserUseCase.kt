package com.example.git.domain

import org.koin.core.annotation.Single

@Single
class GetUserUseCase(private val repository: GitHubRepository) {
    suspend operator fun invoke(username: String): Result<GithubUserModel> {
        return repository.getUser(username)
    }
}