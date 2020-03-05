package pl.godziszewo.kosciol.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BibliaDao {
    @Query("SELECT * FROM biblia")
    fun getAll(): LiveData<List<Biblia>>

    @Query("SELECT * FROM biblia WHERE rozdzial = :rozdzial")
    fun getPoRozdziale(rozdzial: String): LiveData<List<Biblia>>

    @Query("SELECT * FROM biblia WHERE rozdzial = :rozdzial")
    fun getPoSpanstr(rozdzial: String): LiveData<List<Biblia>>

    @Query("SELECT ksiega FROM biblia")
    fun getKsiegi(): LiveData<List<String>>

    @Insert
    suspend fun inser(biblia: Biblia)

    @Query("DELETE FROM biblia")
    suspend fun deleteAll()

    @Query("DELETE FROM biblia WHERE rozdzial = 'home'")
    suspend fun deleteHome()

    @Query("DELETE FROM biblia WHERE rozdzial = 'spanstr' AND ksiega = 'Aktualności'")
    suspend fun delSpanstrAkt()

    @Query("DELETE FROM biblia WHERE rozdzial = 'spanstr' AND ksiega = 'Ogłoszenia'")
    suspend fun delSpanstrOgl()

    @Query("DELETE FROM biblia WHERE rozdzial = 'spanstr' AND ksiega = 'Intencje'")
    suspend fun delSpanstrInt()

    @Query("DELETE FROM biblia WHERE rozdzial = 'spanstr' AND ksiega = 'Historia parafii'")
    suspend fun delSpanstrHis()

    @Query("DELETE FROM biblia WHERE rozdzial = 'spanstr' AND ksiega = 'Nasz patron'")
    suspend fun delSpanstrPat()

    @Query("DELETE FROM biblia WHERE rozdzial = 'spanstr' AND ksiega = 'Cmentarz'")
    suspend fun delSpanstrCmt()

    @Query("DELETE FROM biblia WHERE rozdzial = 'spanstr' AND ksiega = 'Sakramenty'")
    suspend fun delSpanstrSak()

    @Query("DELETE FROM biblia WHERE rozdzial = 'spanstr' AND ksiega = 'Kontakt'")
    suspend fun delSpanstrKon()
}