package ru.geekbrain.android.myloginapp

import android.app.Application
import android.content.Context
import android.os.Handler
import android.os.Looper
import ru.geekbrain.android.myloginapp.data.LoginUseCaseImpl
import ru.geekbrain.android.myloginapp.data.MockLoginAPI
import ru.geekbrain.android.myloginapp.domain.LoginAPI

class App : Application() {
    private val loginApi: LoginAPI by lazy { MockLoginAPI() }
    val loginUseCase by lazy {  LoginUseCaseImpl(loginApi, Handler(Looper.getMainLooper()) )}
}

val Context.app: App
    get() {
        return applicationContext as App
    }