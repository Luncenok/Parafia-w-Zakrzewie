package pl.godziszewo.kosciol.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Biblia::class,GalleryInfo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bibliaDao(): BibliaDao
    abstract fun galleryInfoDao(): GalleryInfoDao

    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
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