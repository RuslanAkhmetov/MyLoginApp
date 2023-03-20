package ru.geekbrain.android.myloginapp

import android.os.Handler


class LoginPresenter:LoginContract.Presenter {

    private lateinit var view:LoginContract.View
    private var currentResult = false
    private var errorMessage = ""

    override fun onAttach(view: LoginContract.View) {
        this.view = view
        if (currentResult){
            view.setSuccess()
        } else{
            view.setError(errorMessage)
        }
    }

    override fun onLogin(login: String, password: String) {
        view.showProgress()
        Thread {
            view.getHandler().post {
                view.hideProgress()
                if (checkCredentials(login, password)) {
                    view.setSuccess()
                    currentResult = true
                    errorMessage = ""
                } else {
                    errorMessage = "Invalid password"
                    view.setError(errorMessage)
                    currentResult = false
                }
            }
        }.start()
    }

    private fun checkCredentials(login: String, password: String): Boolean =
        login == password

    override fun onCredentialChange() {
        TODO("Not yet implemented")
    }
}