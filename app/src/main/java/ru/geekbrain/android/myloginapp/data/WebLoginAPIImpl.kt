package ru.geekbrain.android.myloginapp.data

import ru.geekbrain.android.myloginapp.domain.LoginAPI

class WebLoginAPIImpl: LoginAPI {
    override fun login(login: String, password: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun register(login: String, password: String, email: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun logout(): Boolean {
        TODO("Not yet implemented")
    }

    override fun forgotPassword(login: String): Boolean {
        TODO("Not yet implemented")
    }
}