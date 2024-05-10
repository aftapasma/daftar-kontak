package org.d3if.daftarkontak.navigation

import org.d3if.daftarkontak.screen.KEY_ID_KONTAK

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object FormBaru: Screen("detailScreen")
    data object FormUbah: Screen("detailScreen/{$KEY_ID_KONTAK}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
}