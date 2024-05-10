package org.d3if.daftarkontak.navigation

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")

}