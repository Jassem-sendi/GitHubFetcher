package com.example.git.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.git.domain.GetUserUseCase
import com.example.git.domain.GithubUserModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ProfileViewModel(
    private val getUserUseCase: GetUserUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()


    fun toggleTheme() {
        _uiState.value = _uiState.value.copy(isDarkTheme = !_uiState.value.isDarkTheme)
    }

    fun setUsername(username: String) {
        _uiState.value = _uiState.value.copy(username = username)
    }


    private var fetchUserJob: Job? = null

    fun fetchUser(username: String) {
        fetchUserJob?.cancel()
        fetchUserJob = viewModelScope.launch {
            if (username.isEmpty()) {
                _uiState.update {
                    it.copy(
                        errorMessage = "Username cannot be empty",
                        loading = false
                    )
                }
                return@launch
            }
            _uiState.update {
                it.copy(
                    loading = true,
                    errorMessage = null,
                )
            }
            try {
                getUserUseCase(username)
                    .onSuccess {user->
                        _uiState.update {
                            it.copy(
                                user = user,
                                errorMessage = null,
                                loading = false
                            )
                        }
                        println("User found success")
                    }
                    .onFailure {
                        println("User not found failure $it")
                        _uiState.update {
                            it.copy(
                                errorMessage = "User not found",
                                user = null,
                                loading = false
                            )
                        }
                    }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        errorMessage = "User not found",
                        user = null,
                        loading = false
                    )
                }
            }
        }
    }
}
data class ProfileUiState (
    val isDarkTheme: Boolean = false ,
    val username: String = "" ,
    val user: GithubUserModel? = null,
    val errorMessage: String? = null,
    val loading: Boolean = false,
)