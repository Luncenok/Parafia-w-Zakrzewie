package pl.godziszewo.kosciol.repository

import androidx.lifecycle.LiveData
import pl.godziszewo.kosciol.data.local.BibliaDao
import pl.godziszewo.kosciol.data.model.Biblia

class BibliaRepository(private val bibliaDao: BibliaDao) {
    val allBiblia: LiveData<List<Biblia>> = bibliaDao.getAll()
    val allBibliaPoRozdziale: LiveData<List<Biblia>> = bibliaDao.getPoRozdziale("home")
    val allBibliaPoSpanstr: LiveData<List<Biblia>> = bibliaDao.getPoSpanstr("spanstr")

    suspend fun inser(biblia: Biblia) {
        bibliaDao.inser(biblia)
    }

    suspend fun delall() {
        bibliaDao.deleteAll()
    }

    suspend fun delHome() {
        bibliaDao.deleteHome()
    }

    suspend fun delSpanstrAkt() {
        bibliaDao.delSpanstrAkt()
    }

    suspend fun delSpanstrCmt() {
        bibliaDao.delSpanstrCmt()
    }

    suspend fun delSpanstrHis() {
        bibliaDao.delSpanstrHis()
    }

    suspend fun delSpanstrInt() {
        bibliaDao.delSpanstrInt()
    }

    suspend fun delSpanstrOgl() {
        bibliaDao.delSpanstrOgl()
    }

    suspend fun delSpanstrPat() {
        bibliaDao.delSpanstrPat()
    }

    suspend fun delSpanstrSak() {
        bibliaDao.delSpanstrSak()
    }

    suspend fun delSpanstrKon() {
        bibliaDao.delSpanstrKon()
    }
}