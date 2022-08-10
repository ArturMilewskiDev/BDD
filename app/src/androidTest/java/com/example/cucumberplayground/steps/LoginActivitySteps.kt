/*
 * Copyright (C) 2015 emmasuzuki <emma11suzuki@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH
 * THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.example.cucumberplayground.steps

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.action.ViewActions.typeText
import com.example.cucumberplayground.*
import com.example.cucumberplayground.ViewTestCommons.onView
import com.example.cucumberplayground.homepage.HomepageActivity
import com.example.cucumberplayground.login.LoginActivity
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class LoginActivitySteps {

    @When("^launch login screen$")
    fun launchLoginScreen() {
        launch(LoginActivity::class.java)
    }

    @When("type email {string}")
    fun typeEmail(email: String) {
        onView(R.id.etEmail).perform(typeText(email))
    }

    @When("type password {string}")
    fun typePassword(password: String) {
        onView(R.id.etPassword).perform(typeText(password))
    }

    @Then("^should see homepage screen$")
    fun shouldSeeHomepageScreen() {
        (HomepageActivity::class.java.name).checkActivityLaunched()
    }

    @Then("^should (true|false) email error$")
    fun shouldSeeEmailErrorEmailError(displayed: Boolean) {
        onView(R.id.tvEmailError).isDisplayed(displayed)
    }

    @And("^should (true|false) password error$")
    fun shouldSeePasswordErrorPasswordError(displayed: Boolean) {
        onView(R.id.tvPasswordError).isDisplayed(displayed)
    }

    @Then("^should see auth error$")
    fun shouldSeeAuthError() {
        onView(R.id.tvError).isDisplayed()
    }

    @Then("^should see email input$")
    fun shouldSeeEmailInput() {
        onView(R.id.etEmail).checkEmailInput().isDisplayed()
    }

    @Then("^should see password input$")
    fun shouldSeePasswordInput() {
        onView(R.id.etPassword).checkPasswordInput().isDisplayed()
    }

    @When("^when Android stuff$")
    fun whenAndroidStuff() {
        // not important for now
    }

    @Then("^then Android stuff$")
    fun thenAndroidStuff() {
        // not important for now
    }
}
