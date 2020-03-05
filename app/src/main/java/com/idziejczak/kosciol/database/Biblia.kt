package com.idziejczak.kosciol.database

import android.text.Spanned
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Biblia (
    @PrimaryKey(autoGenerate = true) val id: Int,

    @ColumnInfo(name = "ksiega") val ksiega: String?,
    @ColumnInfo(name = "rozdzial") val rozdzial: String?,
    @ColumnInfo(name = "werset") val werset: String?
)