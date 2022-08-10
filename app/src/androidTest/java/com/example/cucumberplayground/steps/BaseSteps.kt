package com.example.cucumberplayground.steps

import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers
import com.example.cucumberplayground.R
import com.example.cucumberplayground.ViewTestCommons.onView
import com.example.cucumberplayground.isClickable
import com.example.cucumberplayground.isDisplayed
import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.en.And
import io.cucumber.java.en.When

class BaseSteps {

    @Before(value = "@intents")
    fun beforeScenarioWithIntentsTag() {
        Intents.init() // zaczyna monitorować intenty
    }

    @After(value = "@intents")
    fun afterScenarioWithIntentsTag() {
        Intents.release() // kończy monitorować intenty
    }

    @And("click option with text {string}")
    fun clickOptionWithText(arg0: String) {
        onView(arg0).apply {
            check(matches(ViewMatchers.isDisplayed()))
            perform(ViewActions.click())
        }
    }

    @And("^hide keyboard$")
    fun hideKeyboard() {
        ViewActions.closeSoftKeyboard()
    }

    @When("title {string} is displayed")
    fun titleIsDisplayed(title: String) {
        onView(R.id.tvTitle, title).isDisplayed()
    }

    @When("button with text {string} is displayed")
    fun buttonWithTextIsDisplayed(text: String) {
        onView(text).isDisplayed().isClickable()
    }
}