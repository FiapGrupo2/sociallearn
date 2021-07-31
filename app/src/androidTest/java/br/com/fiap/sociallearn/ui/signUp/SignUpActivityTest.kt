package br.com.fiap.sociallearn.ui.signUp

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
class SignUpActivityTest {
    @get:Rule
    var activityRule: ActivityTestRule<SignUpActivity>
            = ActivityTestRule(SignUpActivity::class.java)

   /** @Test
    fun validaCamposEmBranco() {
        Espresso
            .onView(
                ViewMatchers.withId(R.id.btCreateAccount)
            )
            .perform(
                ViewActions.click()
            )
        Espresso
            .onView(
                ViewMatchers.withText(R.string.ERROR_NULL_SIGN)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
    }*/


    @Test
    fun validaCarregamento() {
        Espresso
            .onView(
                ViewMatchers.withId(R.id.tvWelcomeSugestion)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
        Espresso
            .onView(
                ViewMatchers.withId(R.id.etUserNameSignUp)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
        Espresso
            .onView(
                ViewMatchers.withId(R.id.etEmail)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )

        Espresso
            .onView(
                ViewMatchers.withId(R.id.etPasswordConfirm)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )


        Espresso
            .onView(
                ViewMatchers.withId(R.id.btCreateAccount)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
    }
}