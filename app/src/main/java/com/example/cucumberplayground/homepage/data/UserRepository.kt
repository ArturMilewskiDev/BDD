package com.example.cucumberplayground.homepage.data

class UserRepository {

    fun fetchUsers() = listOf(
        User(name = "John", surname = "Kowalsky", premiumAccount = true, age = 30, additionalInformation = ""),
        User(name = "Linda", surname = "Smith", premiumAccount = false, age = 40, additionalInformation = "Lorem ipsum"),
    )
}