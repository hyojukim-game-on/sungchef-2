package com.ssafy.sungchef.features.screen.refrigerator.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ssafy.sungchef.features.screen.refrigerator.RefrigeratorScreen

const val refrigeratorNavigationRoute = "refrigerator_screen"


fun NavController.navigateRefrigerator(
    navOptions: NavOptions? = null
) {
    this.navigate(refrigeratorNavigationRoute, navOptions)
}

fun NavGraphBuilder.refrigeratorScreen(
    onMoveReceiptPage : () -> Unit,
    onChange : () -> Unit
){
    composable(refrigeratorNavigationRoute) {
        RefrigeratorScreen(
            onMoveReceiptPage,
            hiltViewModel(),
            onChange = onChange
        )
    }
}