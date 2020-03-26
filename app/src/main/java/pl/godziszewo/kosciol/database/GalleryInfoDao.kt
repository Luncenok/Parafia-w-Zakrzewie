package pl.godziszewo.kosciol.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GalleryInfoDao {
    @Query("SELECT * FROM gallery")
    fun getAll(): LiveData<List<GalleryInfo>>

    @Insert
    suspend fun insert(galleryInfo: GalleryInfo)

    @Query("DELETE FROM gallery")
    suspend fun deleteAll()
}
