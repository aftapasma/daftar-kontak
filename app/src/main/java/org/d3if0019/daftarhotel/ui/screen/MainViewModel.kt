package org.d3if0019.daftarhotel.ui.screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0019.daftarhotel.model.Hotel
import org.d3if0019.daftarhotel.network.HotelApi

class MainViewModel : ViewModel() {

    var data = mutableStateOf(emptyList<Hotel>())
        private set
    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                data.value = HotelApi.service.getHewan()
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
            }
        }
    }
}