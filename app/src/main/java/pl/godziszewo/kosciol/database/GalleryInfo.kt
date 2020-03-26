package pl.godziszewo.kosciol.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gallery")
data class GalleryInfo(
    @PrimaryKey(autoGenerate = true) val id: Int,

    @ColumnInfo(name = "photosrc") val photosrc: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "date") val date: String
)