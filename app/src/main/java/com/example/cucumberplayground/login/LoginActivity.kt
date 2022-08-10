package com.example.cucumberplayground.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.core.view.isVisible
import com.example.cucumberplayground.homepage.HomepageActivity
import com.example.cucumberplayground.databinding.ActivityLoginBinding

class LoginActivity : Activity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnSubmit.setOnClickListener {
                val credentialsFormatValid = isCredentialsFormatValid()
                if (credentialsFormatValid) {
                    val accountIsValid = isAccountValid()
                    tvError.isVisible = !accountIsValid
                    if (accountIsValid) {
                        navigateHomepageScreen()
                    }
                }
            }
        }
    }

    private fun navigateHomepageScreen() {
        val intent = Intent(this@LoginActivity, HomepageActivity::class.java)
        intent.flags =
            Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    private fun isCredentialsFormatValid(): Boolean {
        val emailValid = isEmailFormatValid()
        val passwordValid = isPasswordFormatValid()
        binding.tvPasswordError.isVisible = !passwordValid
        binding.tvEmailError.isVisible = !emailValid
        return emailValid && passwordValid
    }

    private fun isPasswordFormatValid() = binding.etPassword.text.toString().isNotEmpty()

    private fun isEmailFormatValid(): Boolean {
        val email = binding.etEmail.text.toString()
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isAccountValid(): Boolean {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        return email == DEMO_EMAIL && password == DEMO_PASSWORD
    }

    companion object {
        private const val DEMO_EMAIL = "valid@email.com"
        private const val DEMO_PASSWORD = "validpassword"
    }
}