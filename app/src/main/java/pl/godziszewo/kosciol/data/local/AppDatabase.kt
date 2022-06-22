package pl.godziszewo.kosciol.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import pl.godziszewo.kosciol.data.model.Biblia
import pl.godziszewo.kosciol.data.model.GalleryInfo

@Database(entities = [Biblia::class, GalleryInfo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bibliaDao(): BibliaDao
    abstract fun galleryInfoDao(): GalleryInfoDao

    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let {
                scope.launch {
//                    val bibliaDao = database.bibliaDao()
//                    val galleryInfoDao = database.galleryInfoDao()
//                    // Add sample words.
//                    val ksiega = Biblia(0, "test", "", "")
//                    val ksiega2 = Biblia(0, "tes", "", "")
//                    bibliaDao.inser(ksiega)
//                    bibliaDao.inser(ksiega2)
                }
            }
        }


    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "biblia"
                ).addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}