package com.kaspersky.kaspresso.tutorial

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.tutorial.afterlogin.AfterLoginActivity
import com.kaspersky.kaspresso.tutorial.tutorial.screen.LoginScreen
import com.kaspersky.kaspresso.tutorial.screen.MainScreen
import com.kaspersky.kaspresso.tutorial.tutorial.LoginActivity
import org.junit.Rule
import org.junit.Test

class LoginActivityTest : TestCase() {

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun loginSuccessfulIfUsernameAndPasswordCorrect() {
        run {
            val username = "123456"
            val password = "123456"

            step("Open login screen") {
                MainScreen {
                    loginActivityButton {
                        isVisible()
                        isClickable()
                        click()
                    }
                }
            }

            step("Check elements visibility") {
                LoginScreen {
                    inputUsername {
                        isVisible()
                        hasHint(R.string.login_activity_hint_username)
                    }
                    inputPassword {
                        isVisible()
                        hasHint(R.string.login_activity_hint_password)
                    }
                    loginButton {
                        isVisible()
                        isClickable()
                    }
                }
            }
            step("Try to login") {
                LoginScreen {
                    inputUsername {
                        replaceText(username)
                    }
                    inputPassword {
                        replaceText(password)
                    }
                    loginButton {
                        click()
                    }
                }
            }
            step("Check current screen") {
                device.activities.isCurrent(AfterLoginActivity::class.java)
            }
        }
    }

    @Test
    fun loginUnsuccessfulIfUsernameIncorrect() {
        run {
            val username = "12"
            val password = "123456"

            step("Open login screen") {
                MainScreen {
                    loginActivityButton {
                        isVisible()
                        isClickable()
                        click()
                    }
                }
            }
            step("Check elements visibility") {
                LoginScreen {
                    inputUsername {
                        isVisible()
                        hasHint(R.string.login_activity_hint_username)
                    }
                    inputPassword {
                        isVisible()
                        hasHint(R.string.login_activity_hint_password)
                    }
                    loginButton {
                        isVisible()
                        isClickable()
                    }
                }
            }
            step("Try to login") {
                LoginScreen {
                    inputUsername {
                        replaceText(username)
                    }
                    inputPassword {
                        replaceText(password)
                    }
                    loginButton {
                        click()
                    }
                }
            }
            step("Check current screen") {
                device.activities.isCurrent(LoginActivity::class.java)
            }

        }
    }

    @Test
    fun loginUnsuccessfulIfPasswordIncorrect() {
        run {
            val username = "123456"
            val password = "123456"

            step("Open login screen") {
                MainScreen {
                    loginActivityButton {
                        isVisible()
                        isClickable()
                        click()
                    }
                }
            }
            step("Check elements visibility") {
                LoginScreen {
                    inputUsername {
                        isVisible()
                        hasHint(R.string.login_activity_hint_username)
                    }
                    inputPassword {
                        isVisible()
                        hasHint(R.string.login_activity_hint_password)
                    }
                    loginButton {
                        isVisible()
                        isClickable()
                    }
                }
            }
            step("Try to login") {
                LoginScreen {
                    inputUsername {
                        replaceText(username)
                    }
                    inputPassword {
                        replaceText(password)
                    }
                    loginButton {
                        click()
                    }
                }
            }
            step("Check current screen") {
                device.activities.isCurrent(LoginActivity::class.java)
            }
        }
    }
}
