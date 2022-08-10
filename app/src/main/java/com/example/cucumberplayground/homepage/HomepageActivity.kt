package com.example.cucumberplayground.homepage

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.cucumberplayground.databinding.ActivityHomepageBinding
import com.example.cucumberplayground.homepage.data.User
import com.example.cucumberplayground.homepage.data.UserRepository
import com.example.cucumberplayground.login.LoginActivity

class HomepageActivity : Activity() {

    private lateinit var binding: ActivityHomepageBinding
    private val userRepository = UserRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogout.setOnClickListener {
            navigateLoginScreen()
        }

        showUsers(userRepository.fetchUsers())
    }

    private fun showUsers(users: List<User>) {
        binding.tvUsers.text = users.toString()
    }

    private fun navigateLoginScreen() {
        val intent = Intent(this@HomepageActivity, LoginActivity::class.java)
        intent.flags =
            Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}