package pl.godziszewo.kosciol.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.godziszewo.kosciol.data.model.Biblia
import pl.godziszewo.kosciol.data.model.GalleryInfo

@Database(
    entities = [Biblia::class, GalleryInfo::class], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bibliaDao(): BibliaDao
    abstract fun galleryInfoDao(): GalleryInfoDao
}