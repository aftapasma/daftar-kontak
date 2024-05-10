package org.d3if.daftarkontak.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if.daftarkontak.database.KontakDao
import org.d3if.daftarkontak.model.Kontak

class MainViewModel(dao: KontakDao) : ViewModel() {

    val data: StateFlow<List<Kontak>> = dao.getKontak().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}