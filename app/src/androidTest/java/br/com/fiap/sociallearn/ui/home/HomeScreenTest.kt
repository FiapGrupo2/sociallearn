package br.com.fiap.sociallearn.ui.home

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import br.com.fiap.sociallearn.R
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeScreenTest {
    @get:Rule
    var activityRule: ActivityTestRule<HomeActivity>
            = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun validaCarregamentoCarousel() {
        Espresso
            .onView(
                ViewMatchers.withId(R.id.carousel)
            )
            .check(
            ViewAssertions.matches(ViewMatchers.isDisplayed())
        )
    }
}