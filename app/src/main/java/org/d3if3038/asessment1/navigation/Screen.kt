package org.d3if3038.asessment1.navigation

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object About: Screen("aboutScreen")
}