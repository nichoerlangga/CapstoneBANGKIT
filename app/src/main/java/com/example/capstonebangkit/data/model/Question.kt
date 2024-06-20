package com.example.capstonebangkit.data.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.painter.Painter

val ANSWER_OPTIONS = listOf(
    "Gatal gatal", "Ruam kulit", "Erupsi kulit nodal", "Bersin terus-menerus", "Menggigil",
    "Demam", "Nyeri sendi", "Sakit perut", "Asam lambung", "Luka pada lidah", "Pengikisan otot",
    "Muntah", "Nyeri saat buang air kecil", "Spotting urination", "Kelelahan", "Penurunan berat badan",
    "Gelisah", "Lesu", "Bercak di tenggorokan", "Kadar gula tidak teratur", "Batuk", "Demam tinggi",
    "Mata cekung", "Sesak napas", "Berkeringat", "Dehidrasi", "Sakit kepala", "Kulit kekuningan",
    "Urine gelap", "Mual", "Hilang nafsu makan", "Nyeri di belakang mata", "Sakit punggung",
    "Sembelit", "Nyeri perut", "Diare", "Demam ringan", "Urine kuning", "Mata menguning",
    "Pembengkakan kelenjar getah bening", "Rasa tidak enak badan", "Penglihatan kabur dan terdistorsi",
    "Dahak", "Nyeri dada", "Denyut jantung cepat", "Pusing", "Kegemukan", "Rasa lapar berlebihan",
    "Hubungan di luar nikah", "Gerakan berputar", "Kehilangan keseimbangan", "Ketidakstabilan",
    "Ketidaknyamanan kandung kemih", "Foul smell of urine", "Rasa ingin buang air kecil yang terus-menerus",
    "Tampak beracun (tifos)", "Nyeri otot", "Bintik merah di seluruh tubuh", "Sakit perut",
    "Dischromic patches", "Mata berair", "Nafsu makan meningkat", "Poliuria", "Riwayat keluarga",
    "Dahak mukoid", "Dahak berkarat", "Kurang konsentrasi", "Menerima transfusi darah",
    "Menerima suntikan tidak steril", "Darah dalam dahak"
)

data class Questions(
    val image: Painter,
    val title: String,
    val symptomsList: List<String> = ANSWER_OPTIONS
)