package com.example.cucumberplayground.test

import io.cucumber.junit.CucumberOptions

@CucumberOptions(
    features = [
        //"features/login.feature:3",
        //"features/login.feature:10",

        //"features/login.feature",

        //"features/homepage.feature"

        "features"
    ],
    plugin = ["pretty"],
    glue = ["com.example.cucumberplayground.steps"],
    tags = ["not @iOS"]
)
@Suppress("unused")
class CucumberConfiguration