package org.d3if.daftarkontak.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if.daftarkontak.database.KontakDao
import org.d3if.daftarkontak.model.Kontak

class DetailViewModel(private val dao: KontakDao) : ViewModel() {

//    private val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    fun insert(nama: String, nim: String, kelas: String) {
        val mahasiswa = Kontak(
            nama = nama,
            nomor   = nim,
            gender = kelas
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(mahasiswa)
        }
    }

    suspend fun getKontak(id: Long): Kontak? {
        return dao.getKontakById(id)
    }

    fun update(id: Long, nama: String, nomor: String, gender: String) {
        val kontak = Kontak(
            id      = id,
            nama = nama,
            nomor   = nomor,
            gender = gender
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(kontak)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}