package com.kaspersky.kaspressample.jetpack_compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kaspersky.kaspressample.jetpack_compose.features.main.MainScreen
import com.kaspersky.kaspressample.jetpack_compose.features.simple_flaky.SimpleFlakyScreen
import com.kaspersky.kaspressample.jetpack_compose.features.simple_flaky.SimpleFlakyViewModel
import com.kaspersky.kaspressample.jetpack_compose.resources.C

class JetpackComposeActivity : AppCompatActivity() {

    private val simpleFlakyViewModel: SimpleFlakyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartNavigation()
        }
    }

    @Composable
    private fun StartNavigation() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = C.Screen.main_screen) {
            composable(C.Screen.main_screen) {
                MainScreen(
                    simpleFlakyClick = { navController.navigate(C.Screen.simple_flaky_screen) }
                )
            }

            composable(C.Screen.simple_flaky_screen) {
                SimpleFlakyScreen(
                    simpleFlakyStateLiveData = simpleFlakyViewModel.simpleFlakyStateLiveData,
                    firstButtonClick = { simpleFlakyViewModel.firstButtonClick() },
                    secondButtonClick = { simpleFlakyViewModel.secondButtonClick() },
                    editTextChange = { simpleFlakyViewModel.editTextChange(it) }
                )
            }
        }
    }
}
