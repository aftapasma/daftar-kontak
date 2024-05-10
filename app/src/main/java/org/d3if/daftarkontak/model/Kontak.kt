package org.d3if.daftarkontak.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kontak")
data class Kontak(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val nomor: String,
    val gender: String
)
