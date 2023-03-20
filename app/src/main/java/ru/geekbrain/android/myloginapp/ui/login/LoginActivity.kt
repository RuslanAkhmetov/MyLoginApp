package ru.geekbrain.android.myloginapp.ui.login

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.core.view.isVisible
import ru.geekbrain.android.myloginapp.app
import ru.geekbrain.android.myloginapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), LoginContract.View {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        presenter = restorePresenter()
        presenter.onAttach(this)
        setContentView(binding.root)

        binding.butonInput.setOnClickListener{
            presenter.onLogin(
                binding.loginEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }
    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        return presenter
    }

    override fun setSuccess() {
        binding.loginEditText.isVisible = false
        binding.passwordEditText.isVisible = false
        binding.butonInput.isVisible = false
        binding.root.setBackgroundColor(Color.GREEN)
    }

    override fun setError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        binding.butonInput.isEnabled = false
    }

    override fun hideProgress() {
        binding.butonInput.isEnabled = true
    }

    override fun getHandler(): Handler {
        return Handler(Looper.getMainLooper())
    }

    private fun restorePresenter(): LoginPresenter {
        return  lastCustomNonConfigurationInstance as? LoginPresenter
            ?: LoginPresenter(app.loginUseCase)
    }
}