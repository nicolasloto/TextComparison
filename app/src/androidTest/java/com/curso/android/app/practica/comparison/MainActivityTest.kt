package com.curso.android.app.practica.comparison

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.curso.android.app.practica.comparison.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun compareButton_sameTexts_resultIsEqual() {
        onView(withId(R.id.editText1)).perform(typeText("test"), closeSoftKeyboard())
        onView(withId(R.id.editText2)).perform(typeText("test"), closeSoftKeyboard())
        onView(withId(R.id.compareButton)).perform(click())
        onView(withId(R.id.resultTextView)).check(matches(withText("Los textos son iguales")))
    }

    @Test
    fun compareButton_differentTexts_resultIsDifferent() {
        onView(withId(R.id.editText1)).perform(typeText("test1"), closeSoftKeyboard())
        onView(withId(R.id.editText2)).perform(typeText("test2"), closeSoftKeyboard())
        onView(withId(R.id.compareButton)).perform(click())
        onView(withId(R.id.resultTextView)).check(matches(withText("Los textos son diferentes")))
    }
}