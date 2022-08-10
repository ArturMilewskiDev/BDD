package com.example.cucumberplayground

import android.text.InputType
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not

object ViewTestCommons {

    fun onView(id: Int, text: String): ViewInteraction =
        onView(allOf(withId(id), withText(text)))

    fun onView(text: String): ViewInteraction = onView(withText(text))

    fun onView(id: Int): ViewInteraction = onView(withId(id))
}

fun ViewInteraction.isDisplayed(displayed: Boolean) {
    val displayedMatcher = if (displayed) { ViewMatchers.isDisplayed() } else { not(ViewMatchers.isDisplayed()) }
    check(matches(displayedMatcher))
}

fun ViewInteraction.isDisplayed(): ViewInteraction =
    check(matches(ViewMatchers.isDisplayed()))

fun ViewInteraction.isClickable(): ViewInteraction =
    check(matches(ViewMatchers.isClickable()))

fun String.checkActivityLaunched() {
    Intents.intended(IntentMatchers.hasComponent(this))
}

fun ViewInteraction.checkPasswordInput(): ViewInteraction =
    check(matches(withInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)))

fun ViewInteraction.checkEmailInput(): ViewInteraction =
    check(matches(withInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS)))
