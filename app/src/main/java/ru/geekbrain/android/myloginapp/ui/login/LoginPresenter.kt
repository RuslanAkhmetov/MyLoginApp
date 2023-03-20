package ru.geekbrain.android.myloginapp.ui.login

import ru.geekbrain.android.myloginapp.domain.LoginUseCase


class LoginPresenter( private val loginUseCase: LoginUseCase): LoginContract.Presenter {

    private lateinit var view: LoginContract.View
    private var currentResult = false
    private var errorMessage = ""

    override fun onAttach(view: LoginContract.View) {
        this.view = view
        if (currentResult){
            view.setSuccess()
        }
    }

    override fun onLogin(login: String, password: String) {
        view.showProgress()

        loginUseCase.login(login, password) {result:Boolean->
            view.hideProgress()
            if (result) {
                view.setSuccess()
                currentResult = true
                errorMessage = ""
            } else {
                errorMessage = "Invalid password"
                view.setError(errorMessage)
                currentResult = false
            }

        }

    }

    private fun checkCredentials(login: String, password: String): Boolean =
        login == password

    override fun onCredentialChange() {
        TODO("Not yet implemented")
    }
}