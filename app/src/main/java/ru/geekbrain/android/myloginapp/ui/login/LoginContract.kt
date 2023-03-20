package ru.geekbrain.android.myloginapp.ui.login

import android.os.Handler
import androidx.annotation.MainThread

class LoginContract {
    interface Presenter{
        @MainThread
        fun onAttach(view: View)

        @MainThread
        fun onLogin(login: String, password: String)

        @MainThread
        fun onCredentialChange()
    }

    interface View{
        @MainThread
        fun setSuccess()
        @MainThread
        fun setError(error: String)
        @MainThread
        fun showProgress()
        @MainThread
        fun hideProgress()

        fun getHandler():Handler
    }




}