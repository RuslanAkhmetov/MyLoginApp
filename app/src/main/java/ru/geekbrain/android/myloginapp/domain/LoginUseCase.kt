package ru.geekbrain.android.myloginapp.domain

import androidx.annotation.MainThread

interface LoginUseCase {
    fun login(login: String, password: String,  @MainThread callback: (Boolean) -> Unit )
}