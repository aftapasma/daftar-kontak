package org.d3if.daftarkontak.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if.daftarkontak.model.Kontak

@Dao
interface KontakDao {
    @Insert
    suspend fun insert(kontak: Kontak)

    @Update
    suspend fun update(kontak: Kontak)

    @Query("SELECT * FROM kontak ORDER BY favorit ASC, nama ASC")
    fun getKontak(): Flow<List<Kontak>>

    @Query("SELECT * FROM kontak WHERE id = :id")
    suspend fun getKontakById(id: Long): Kontak?

    @Query("DELETE FROM kontak WHERE id = :id")
    suspend fun deleteById(id: Long)
}