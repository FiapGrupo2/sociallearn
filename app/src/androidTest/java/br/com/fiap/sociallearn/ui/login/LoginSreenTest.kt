package br.com.fiap.sociallearn.ui.login

import android.service.autofill.Validators.not
import android.widget.Toast
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.ui.home.HomeActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches

@RunWith(AndroidJUnit4::class)
class LoginSreenTest {

    @get:Rule
    var activityRule: ActivityTestRule<LoginActivity>
            = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun validaCamposEmBranco() {
        Espresso
            .onView(
                ViewMatchers.withId(R.id.btLogin)
            )
            .perform(
                ViewActions.click()
            )
        Espresso
            .onView(withText(R.string.MSG_NULL_LOGIN)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
    }

    @Test
    fun validaCarregamento() {
        Espresso
            .onView(
                ViewMatchers.withId(R.id.etEmailLogin)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
        Espresso
            .onView(
                ViewMatchers.withId(R.id.etPasswordLogin)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
        Espresso
            .onView(
                ViewMatchers.withId(R.id.btLogin)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
    }


}