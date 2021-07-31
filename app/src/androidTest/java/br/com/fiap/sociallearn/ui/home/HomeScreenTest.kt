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
    fun validaCarregamentoCursos() {
        Espresso
            .onView(
                ViewMatchers.withId(R.id.ivCursoJava)
            )
            .check(
            ViewAssertions.matches(ViewMatchers.isDisplayed())
        )
        Espresso
            .onView(
                ViewMatchers.withId(R.id.ivCursoAngular)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
        Espresso
            .onView(
                ViewMatchers.withId(R.id.ivCursoNode)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
        Espresso
            .onView(
                ViewMatchers.withId(R.id.ivCursoBoot)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
        Espresso
            .onView(
                ViewMatchers.withId(R.id.ivCursoFront)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
        Espresso
            .onView(
                ViewMatchers.withId(R.id.ivCursoJavaScript)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
        Espresso
            .onView(
                ViewMatchers.withId(R.id.ivCursoJavaRuby)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
    }
}