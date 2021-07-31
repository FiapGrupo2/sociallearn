package br.com.fiap.sociallearn.ui.login

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import br.com.fiap.sociallearn.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ResetPasswordScreenTest {
    @get:Rule
    var activityRule: ActivityTestRule<ResetPasswordActivity>
            = ActivityTestRule(ResetPasswordActivity::class.java)

    @Test
    fun validaCamposEmBranco() {
        Espresso
            .onView(
                ViewMatchers.withId(R.id.btResetPassword)
            )
            .perform(
                ViewActions.click()
            )
        Espresso
            .onView(
                ViewMatchers.withText(R.string.ERROR_NULL_RESET)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
    }

    @Test
    fun validaCarregamento() {
        Espresso
            .onView(
                ViewMatchers.withId(R.id.etEmailResetPassword)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
        Espresso
            .onView(
                ViewMatchers.withId(R.id.btResetPassword)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
    }

}