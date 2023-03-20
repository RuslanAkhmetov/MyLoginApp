package ru.geekbrain.android.myloginapp.data

import ru.geekbrain.android.myloginapp.domain.LoginAPI

class MockLoginAPI: LoginAPI {
    override fun login(login: String, password: String): Boolean {
        Thread.sleep(3_000)
        return login == password
    }


    override fun register(login: String, password: String, email: String): Boolean {
        Thread.sleep(3_000)
        return login.isNotEmpty()
    }

    override fun logout(): Boolean {
        Thread.sleep(3_000)
        return true
    }

    override fun forgotPassword(login: String): Boolean {
        Thread.sleep(3_000)
        return false
    }
}