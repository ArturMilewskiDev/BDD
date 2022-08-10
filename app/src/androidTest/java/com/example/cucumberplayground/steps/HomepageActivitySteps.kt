package com.example.cucumberplayground.steps

import androidx.test.core.app.ActivityScenario.launch
import com.example.cucumberplayground.R
import com.example.cucumberplayground.ViewTestCommons.onView
import com.example.cucumberplayground.checkActivityLaunched
import com.example.cucumberplayground.homepage.HomepageActivity
import com.example.cucumberplayground.isDisplayed
import com.example.cucumberplayground.login.LoginActivity
import com.example.cucumberplayground.steps.models.User
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class HomepageActivitySteps {

    @When("^launch homepage screen$")
    fun launchHomepageScreen() {
        launch(HomepageActivity::class.java)
    }

    @Then("^should see login screen$")
    fun shouldSeeLoginScreen() {
        (LoginActivity::class.java.name).checkActivityLaunched()
    }

    @Given("^users are displayed$")
    fun usersAreDisplayed(userList: List<User>) {
        onView(R.id.tvUsers, userList.toString()).isDisplayed()
    }
}