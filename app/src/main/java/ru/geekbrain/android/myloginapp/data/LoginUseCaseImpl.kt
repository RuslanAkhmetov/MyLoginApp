package ru.geekbrain.android.myloginapp.data

import android.os.Handler
import ru.geekbrain.android.myloginapp.domain.LoginAPI
import ru.geekbrain.android.myloginapp.domain.LoginUseCase

class LoginUseCaseImpl(private val loginAPI: LoginAPI,
                       private val uiHandler: Handler
                       ): LoginUseCase {

    override fun login(login: String, password: String, callback: (Boolean) -> Unit) {
        Thread{
            val result = loginAPI.login(login, password)
            uiHandler.post {
                callback(result)
            }
        }.start()
    }
}