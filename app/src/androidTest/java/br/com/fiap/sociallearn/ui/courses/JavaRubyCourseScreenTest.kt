package br.com.fiap.sociallearn.ui.courses

import androidx.test.espresso.Espresso
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
class JavaRubyCourseScreenTest {
    @get:Rule
    var activityRule: ActivityTestRule<JavaRubyCourseActivity>
            = ActivityTestRule(JavaRubyCourseActivity::class.java)

    @Test
    fun validaCarregamentoInformacao() {
        Espresso
            .onView(
                ViewMatchers.withId(R.id.btInicio)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
        Espresso
            .onView(
                ViewMatchers.withId(R.id.btSignOut)
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
        Espresso
            .onView(
                ViewMatchers.withId(R.id.tvDescricao)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
        Espresso
            .onView(
                ViewMatchers.withId(R.id.tvIntroducao)
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
    }
}