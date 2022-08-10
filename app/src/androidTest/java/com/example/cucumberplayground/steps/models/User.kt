package com.example.cucumberplayground.steps.models

data class User(
    val name: String,
    val surname: String,
    val premiumAccount: Boolean,
    val age: Int,
    val additionalInformation: String,
)