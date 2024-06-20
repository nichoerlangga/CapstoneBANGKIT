package com.example.capstonebangkit.screens

import android.gesture.Prediction
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.pm.ShortcutInfoCompat.Surface
import androidx.navigation.NavController
import com.example.capstonebangkit.R
import com.example.capstonebangkit.components.ButtonComponent
import com.example.capstonebangkit.components.HeadingPrimaryColor
import com.example.capstonebangkit.components.HeadingTextComponent
import com.example.capstonebangkit.components.NormalTextComponent
import com.example.capstonebangkit.components.NormalTextJustifiedComponent
import com.example.capstonebangkit.data.model.PrognosisData
import com.example.capstonebangkit.ui.auth.QuestionViewModel

@Composable
fun PredictionScreen(label : String) {
    val scrollState = rememberScrollState()
    val prognosisList = listOf(
        PrognosisData (
            id = "Infeksi Jamur",
            generalInfo = "Infeksi jamur adalah infeksi yang disebabkan oleh jamur, mikroorganisme yang dapat hidup di lingkungan, pada kulit manusia, dan di dalam tubuh manusia. Infeksi jamur dapat menyerang berbagai bagian tubuh, termasuk kulit, kuku, mulut, alat kelamin, dan sistem organ internal.",
            healingInfo = "1. Obat Anti-Jamur Topikal:\n" +
                    "\n" +
                    "    - Clotrimazole: Salep atau krim untuk infeksi kulit.\n" +
                    "    - Miconazole: Digunakan untuk infeksi kulit dan mulut.\n" +
                    "    - Terbinafine: Krim untuk infeksi kulit dan kuku.\n" +
                    "\n" +
                    "2. Obat Anti-Jamur Oral:\n" +
                    "\n" +
                    "    - Fluconazole: Digunakan untuk infeksi ragi dan beberapa infeksi sistemik.\n" +
                    "    - Itraconazole: Digunakan untuk infeksi jamur yang lebih serius, termasuk aspergillosis.\n" +
                    "    - Terbinafine: Pil untuk infeksi kuku yang parah.\n" +
                    "\n" +
                    "3. Perawatan Rumah:\n" +
                    "\n" +
                    "    - Kebersihan: Menjaga kebersihan kulit dan kuku, serta area genital.\n" +
                    "    - Menghindari Kelembaban: Pastikan area yang terinfeksi tetap kering dan bersih.\n" +
                    "    - Pakaian: Gunakan pakaian yang longgar dan berbahan katun untuk mencegah kelembaban.\n" +
                    "    - Diet: Mengurangi konsumsi gula dan makanan olahan yang dapat memicu pertumbuhan jamur.\n" +
                    "\n" +
                    "4. Perawatan Medis:\n" +
                    "\n" +
                    "    - Dokter Spesialis: Berkonsultasi dengan dokter kulit atau spesialis infeksi untuk infeksi jamur yang parah.\n" +
                    "    - Antibiotik: Dalam beberapa kasus, infeksi jamur sekunder dapat diobati dengan antibiotik.",
            preventionInfo = "- Menjaga kebersihan pribadi.\n" +
                    "- Menghindari berbagi barang-barang pribadi seperti handuk dan sepatu.\n" +
                    "- Menggunakan sandal di tempat umum seperti kamar mandi dan kolam renang.\n" +
                    "- Mengeringkan tubuh dengan baik setelah mandi.\n" +
                    "- Mengonsumsi makanan yang mendukung kesehatan sistem kekebalan tubuh, seperti probiotik dan makanan rendah gula.",
            conclusion = "Infeksi jamur adalah kondisi umum yang dapat diobati dengan berbagai obat anti-jamur baik topikal maupun oral. Menjaga kebersihan dan menghindari kelembaban adalah kunci pencegahan. Jika gejala tidak membaik, penting untuk mencari bantuan medis."
        ),
        PrognosisData(
            id = "Alergi",
            generalInfo = "Alergi adalah reaksi sistem kekebalan tubuh terhadap zat-zat yang biasanya tidak berbahaya, yang disebut alergen. Alergen dapat berupa makanan, serbuk sari, bulu hewan, debu, dan obat-obatan. Sistem kekebalan tubuh menganggap alergen sebagai ancaman dan menghasilkan respon imun yang berlebihan.",
            healingInfo = "1. Antihistamin:\n" +
                    "\n" +
                    "    - Cetirizine (Zyrtec): Mengurangi gejala hidung meler, bersin, dan mata gatal.\n" +
                    "    - Loratadine (Claritin): Mengobati gejala alergi tanpa menyebabkan kantuk.\n" +
                    "    - Diphenhydramine (Benadryl): Efektif untuk reaksi alergi akut tetapi dapat menyebabkan kantuk.\n" +
                    "\n" +
                    "2. Dekongestan:\n" +
                    "\n" +
                    "    - Pseudoephedrine (Sudafed): Mengurangi hidung tersumbat.\n" +
                    "    - Oxymetazoline (Afrin): Semprotan hidung untuk melegakan hidung tersumbat, tetapi tidak boleh digunakan lebih dari tiga hari berturut-turut.\n" +
                    "\n" +
                    "3. Kortikosteroid:\n" +
                    "\n" +
                    "    - Fluticasone (Flonase): Semprotan hidung untuk mengurangi peradangan dan gejala alergi hidung.\n" +
                    "    - Hydrocortisone: Krim untuk mengobati ruam kulit dan gatal-gatal.\n" +
                    "\n" +
                    "4. Leukotriene Modifiers:\n" +
                    "\n" +
                    "    - Montelukast (Singulair): Mengurangi gejala alergi hidung dan asma.\n" +
                    "\n" +
                    "5. Imunoterapi:\n" +
                    "\n" +
                    "    - Suntikan Alergi: Memberikan dosis kecil alergen secara bertahap untuk meningkatkan toleransi tubuh terhadap alergen.\n" +
                    "    - Tablet Sublingual: Ditempatkan di bawah lidah untuk mengurangi gejala alergi serbuk sari.\n" +
                    "\n" +
                    "6. Perawatan Rumah:\n" +
                    "\n" +
                    "    - Menghindari Alergen: Identifikasi dan hindari paparan terhadap alergen yang diketahui.\n" +
                    "    - Kebersihan: Membersihkan rumah secara rutin untuk mengurangi debu dan bulu hewan.\n" +
                    "    - Humidifier: Menggunakan pelembap udara untuk menjaga kelembapan udara dan mengurangi iritasi saluran napas.",
            preventionInfo = "- Mengidentifikasi dan menghindari alergen yang diketahui.\n" +
                    "- Menggunakan penutup kasur dan bantal anti-tungau debu.\n" +
                    "- Menjaga kebersihan hewan peliharaan dan membatasi akses mereka ke area tidur.\n" +
                    "- Menggunakan penyaring udara berkualitas tinggi untuk mengurangi alergen di dalam rumah.\n" +
                    "- Mencuci tangan dan mandi setelah berada di luar rumah untuk menghilangkan serbuk sari.",
            conclusion = "Alergi adalah respon imun yang berlebihan terhadap alergen tertentu. Pengobatan termasuk antihistamin, dekongestan, kortikosteroid, dan imunoterapi. Pencegahan melibatkan menghindari alergen dan menjaga kebersihan lingkungan. Jika gejala alergi parah atau tidak membaik, konsultasikan dengan dokter.\n"
        ),
        PrognosisData(
            id = "GERD",
            generalInfo = "GERD (Gastroesophageal Reflux Disease) adalah kondisi kronis di mana asam lambung atau isi lambung lainnya kembali naik ke esofagus (kerongkongan), menyebabkan iritasi. Ini berbeda dari refluks asam biasa yang terjadi sesekali; pada GERD, gejalanya terjadi lebih sering dan lebih parah.",
            healingInfo = "1. Antasida:\n" +
                    "\n" +
                    "    - Tums (Kalsium Karbonat): Netralisasi asam lambung dan memberikan bantuan cepat dari heartburn.\n" +
                    "    - Mylanta: Kombinasi simetikon, aluminium hidroksida, dan magnesium hidroksida untuk meredakan heartburn dan gas.\n" +
                    "\n" +
                    "2. H2 Receptor Blockers:\n" +
                    "\n" +
                    "    - Ranitidine (Zantac): Mengurangi produksi asam lambung.\n" +
                    "    - Famotidine (Pepcid): Mengurangi produksi asam lambung dan memberikan bantuan jangka panjang.\n" +
                    "\n" +
                    "3. Proton Pump Inhibitors (PPIs):\n" +
                    "\n" +
                    "    - Omeprazole (Prilosec): Mengurangi produksi asam lambung dan membantu penyembuhan esofagus yang iritasi.\n" +
                    "    - Lansoprazole (Prevacid): Mengurangi produksi asam dan membantu penyembuhan jangka panjang.\n" +
                    "\n" +
                    "4. Prokinetik:\n" +
                    "\n" +
                    "    - Metoclopramide (Reglan): Meningkatkan motilitas saluran cerna dan mempercepat pengosongan lambung.\n" +
                    "\n" +
                    "5. Antibiotik (untuk kasus infeksi Helicobacter pylori):\n" +
                    "\n" +
                    "    - Clarithromycin (Biaxin): Mengobati infeksi bakteri yang bisa memperburuk GERD.\n" +
                    "    - Amoxicillin: Kombinasi dengan PPI untuk mengobati infeksi bakteri.\n" +
                    "\n" +
                    "6. Perawatan Rumah:\n" +
                    "\n" +
                    "    - Perubahan Gaya Hidup: Menurunkan berat badan, berhenti merokok, dan menghindari alkohol.\n" +
                    "    - Diet: Menghindari makanan yang memicu refluks seperti makanan berlemak, pedas, kafein, coklat, dan mint.\n" +
                    "    - Posisi Tidur: Tidur dengan kepala dan dada ditinggikan, menggunakan bantal tambahan atau bantal berbentuk irisan (wedge pillow).\n" +
                    "    - Makan Malam Awal: Menghindari makan besar dalam 3 jam sebelum tidur.",
            preventionInfo = "- Menghindari makanan dan minuman yang memicu gejala.\n" +
                    "- Makan dalam porsi kecil dan lebih sering.\n" +
                    "- Mengunyah makanan dengan baik dan makan perlahan.\n" +
                    "- Menjaga berat badan sehat.\n" +
                    "- Menghindari pakaian ketat di sekitar perut.\n" +
                    "- Menghindari berbaring segera setelah makan.\n" +
                    "- Mengelola stres melalui relaksasi dan olahraga.",
            conclusion = "GERD adalah kondisi kronis di mana asam lambung kembali naik ke esofagus, menyebabkan iritasi dan gejala seperti heartburn, regurgitasi, dan nyeri dada. Pengobatan termasuk antasida, H2 receptor blockers, PPIs, dan prokinetik, serta perubahan gaya hidup dan diet. Jika gejala parah atau tidak membaik, konsultasikan dengan dokter."
        ),
        PrognosisData(
            id = "Reaksi Obat",
            generalInfo = "Reaksi obat adalah respons yang tidak diinginkan atau berbahaya dari tubuh terhadap obat yang diminum. Reaksi ini bisa berupa efek samping ringan hingga reaksi alergi yang parah. Reaksi obat dapat terjadi segera setelah mengonsumsi obat atau setelah beberapa waktu penggunaan.",
            healingInfo = "1. Antihistamin:\n" +
                    "\n" +
                    "    - Diphenhydramine (Benadryl): Mengurangi gejala alergi seperti gatal dan ruam.\n" +
                    "    - Cetirizine (Zyrtec): Mengatasi reaksi alergi ringan hingga sedang.\n" +
                    "\n" +
                    "2. Kortikosteroid:\n" +
                    "\n" +
                    "    - Prednisone: Mengurangi peradangan dan reaksi alergi berat.\n" +
                    "    - Hydrocortisone Cream: Untuk ruam kulit akibat alergi.\n" +
                    "\n" +
                    "3. Bronkodilator:\n" +
                    "\n" +
                    "    - Albuterol (Ventolin): Membuka saluran udara untuk mengatasi sesak napas.\n" +
                    "\n" +
                    "4. Epinephrine (Adrenalin):\n" +
                    "\n" +
                    "    - EpiPen: Injeksi darurat untuk reaksi anafilaksis, membuka saluran udara dan meningkatkan tekanan darah.\n" +
                    "\n" +
                    "5. Obat-obatan untuk Efek Samping Spesifik:\n" +
                    "\n" +
                    "    - Loperamide (Imodium): Mengatasi diare akibat obat.\n" +
                    "    - Ondansetron (Zofran): Mengatasi mual dan muntah.\n" +
                    "\n" +
                    "6. Perawatan Rumah:\n" +
                    "\n" +
                    "    - Menghentikan Penggunaan Obat: Segera hentikan penggunaan obat yang dicurigai menyebabkan reaksi.\n" +
                    "    - Hidrasi: Minum banyak air untuk membantu mengeluarkan obat dari sistem tubuh.\n" +
                    "    - Kompres Dingin: Mengurangi pembengkakan dan gatal pada kulit.",
            preventionInfo = "- Riwayat Medis yang Jelas: Informasikan kepada dokter tentang semua alergi dan reaksi obat sebelumnya.\n" +
                    "- Pemantauan Obat Baru: Pantau reaksi tubuh saat pertama kali menggunakan obat baru.\n" +
                    "- Penggunaan Obat yang Tepat: Ikuti instruksi penggunaan obat dengan tepat.\n" +
                    "- Edukasi Diri: Ketahui efek samping potensial dari obat yang diminum.\n" +
                    "- Medical Alert: Kenakan gelang atau kartu identifikasi medis jika memiliki alergi obat yang parah.",
            conclusion = "Reaksi obat adalah respons tubuh terhadap obat yang bisa berupa efek samping ringan hingga reaksi alergi yang parah. Pengobatan termasuk antihistamin, kortikosteroid, bronkodilator, dan epinephrine. Pencegahan melibatkan riwayat medis yang jelas, pemantauan obat baru, dan edukasi diri. Jika mengalami gejala berat, segera konsultasikan dengan dokter."
        ),
        PrognosisData(
            id = "AIDS",
            generalInfo = "AIDS (Acquired Immune Deficiency Syndrome) adalah tahap akhir dari infeksi HIV (Human Immunodeficiency Virus) yang menyebabkan kerusakan parah pada sistem kekebalan tubuh. HIV menyerang dan menghancurkan sel-sel CD4 (T-helper), yang sangat penting untuk sistem kekebalan tubuh. Ketika jumlah sel CD4 turun di bawah ambang tertentu, seseorang dianggap menderita AIDS.",
            healingInfo = "AIDS tidak dapat disembuhkan, tetapi HIV dapat dikelola dengan pengobatan yang tepat sehingga mencegah perkembangan menjadi AIDS. Pengobatan utama untuk HIV adalah terapi antiretroviral (ART).\n" +
                    "\n" +
                    "1. Terapi Antiretroviral (ART):\n" +
                    "    - NRTIs (Nucleoside Reverse Transcriptase Inhibitors):\n" +
                    "        - NNRTIs (Non-Nucleoside Reverse Transcriptase Inhibitors)\n" +
                    "        - PIs (Protease Inhibitors)\n" +
                    "        - Integrase Inhibitors\n" +
                    "        - Entry Inhibitors:\n" +
                    "\n" +
                    "2. Obat untuk Infeksi Oportunistik:\n" +
                    "    - Antibiotik: Untuk mengobati infeksi bakteri.\n" +
                    "    - Antijamur: Untuk infeksi jamur seperti kandidiasis.\n" +
                    "    - Antivirus: Untuk infeksi virus seperti herpes.\n" +
                    "    - Antiparasit: Untuk infeksi parasit seperti toxoplasmosis.\n" +
                    "\n" +
                    "3. Perawatan Rumah:\n" +
                    "    - Nutrisi yang Seimbang: Mengonsumsi makanan bergizi untuk mendukung sistem kekebalan tubuh.\n" +
                    "    - Olahraga Teratur: Membantu mempertahankan kesehatan fisik dan mental.\n" +
                    "    - Istirahat yang Cukup: Membantu tubuh pulih dan melawan infeksi.\n" +
                    "    " +
                    "- Mengelola Stres: Mengurangi stres melalui teknik relaksasi seperti meditasi atau yoga.",
            preventionInfo = "- Penggunaan Kondom: Selalu gunakan kondom saat berhubungan seks untuk mencegah penularan HIV.\n" +
                    "- PrEP (Pre-Exposure Prophylaxis): Obat pencegahan bagi orang yang berisiko tinggi tertular HIV.\n" +
                    "- Tes HIV Rutin: Melakukan tes HIV secara rutin untuk deteksi dini.\n" +
                    "- Tidak Berbagi Jarum Suntik: Hindari penggunaan jarum suntik bersama-sama.\n" +
                    "- Edukasi Seksual: Edukasi tentang cara-cara penularan HIV dan bagaimana mencegahnya.",
            conclusion = "AIDS adalah tahap akhir dari infeksi HIV yang merusak sistem kekebalan tubuh. Gejala AIDS meliputi infeksi oportunistik, penurunan berat badan drastis, demam berkepanjangan, dan masalah neurologis. Terapi antiretroviral (ART) adalah pengobatan utama untuk mengelola HIV. Pencegahan melibatkan penggunaan kondom, PrEP, tes HIV rutin, dan edukasi seksual. Segera konsultasikan dengan dokter jika mengalami gejala HIV atau AIDS."
        ),
        PrognosisData(
            id = "diabetes",
            generalInfo = "Diabetes adalah penyakit kronis yang terjadi ketika tubuh tidak dapat menghasilkan cukup insulin atau tidak dapat menggunakan insulin secara efektif. Insulin adalah hormon yang mengatur kadar gula darah. Ada beberapa jenis diabetes, termasuk diabetes tipe 1, diabetes tipe 2, dan diabetes gestasional.",
            healingInfo = "Diabetes tidak bisa disembuhkan, tetapi dapat dikelola dengan pengobatan yang tepat, perubahan gaya hidup, dan pemantauan kadar gula darah.\n" +
                    "\n" +
                    "1. Insulin:\n" +
                    "    - Insulin kerja cepat: Lispro (Humalog), Aspart (NovoLog)\n" +
                    "    - Insulin kerja pendek: Regular insulin (Humulin R, Novolin R)\n" +
                    "    - Insulin kerja menengah: NPH (Humulin N, Novolin N)\n" +
                    "    - Insulin kerja panjang: Glargine (Lantus), Detemir (Levemir)\n" +
                    "\n" +
                    "2. Obat Oral untuk Diabetes Tipe 2:\n" +
                    "    - Metformin: Menurunkan produksi glukosa di hati.\n" +
                    "    - Sulfonilurea: Meningkatkan produksi insulin (Glipizide, Glyburide).\n" +
                    "    - DPP-4 Inhibitors: Meningkatkan kadar hormon yang merangsang produksi insulin (Sitagliptin, Saxagliptin).\n" +
                    "    - SGLT2 Inhibitors: Mengeluarkan glukosa melalui urin (Canagliflozin, Dapagliflozin).\n" +
                    "    - Thiazolidinediones: Meningkatkan sensitivitas insulin (Pioglitazone, Rosiglitazone).\n" +
                    "\n" +
                    "3. Perubahan Gaya Hidup:\n" +
                    "    - Diet Seimbang: Mengonsumsi makanan sehat yang rendah gula dan lemak, dan tinggi serat.\n" +
                    "    - Olahraga Teratur: Aktivitas fisik membantu mengontrol kadar gula darah dan menjaga berat badan ideal.\n" +
                    "    - Pemantauan Gula Darah: Memantau kadar gula darah secara rutin untuk mengelola diabetes.\n" +
                    "    - Mengelola Stres: Teknik relaksasi seperti meditasi atau yoga dapat membantu mengurangi stres yang dapat mempengaruhi kadar gula darah.",
            preventionInfo = "- Mengadopsi Pola Makan Sehat: Makan makanan seimbang dan menghindari makanan tinggi gula dan lemak.\n" +
                    "- Aktivitas Fisik Teratur: Berolahraga setidaknya 30 menit sehari.\n" +
                    "- Menjaga Berat Badan Ideal: Menghindari kelebihan berat badan atau obesitas.\n" +
                    "- Menghindari Merokok: Merokok dapat meningkatkan risiko diabetes tipe 2.\n" +
                    "- Mengelola Tekanan Darah dan Kolesterol: Memantau dan mengelola tekanan darah dan kadar kolesterol.",
            conclusion = "Diabetes adalah penyakit kronis yang mempengaruhi kemampuan tubuh untuk mengatur kadar gula darah. Ada beberapa jenis diabetes, termasuk diabetes tipe 1, tipe 2, dan gestasional. Gejala diabetes meliputi sering buang air kecil, rasa haus berlebihan, dan kelelahan. Pengobatan melibatkan penggunaan insulin, obat oral, dan perubahan gaya hidup. Pencegahan melibatkan pola makan sehat, olahraga teratur, dan menjaga berat badan ideal. Konsultasikan dengan dokter jika mengalami gejala diabetes atau membutuhkan bantuan dalam pengelolaan penyakit."
        ),
        PrognosisData(
            id = "Asma",
            generalInfo = "",
            healingInfo = "",
            preventionInfo = "",
            conclusion = ""
        ),
        PrognosisData(
            id = "Asma",
            generalInfo = "",
            healingInfo = "",
            preventionInfo = "",
            conclusion = ""
        ),
        PrognosisData(
            id = "Asma",
            generalInfo = "",
            healingInfo = "",
            preventionInfo = "",
            conclusion = ""
        ),
        PrognosisData(
            id = "Asma",
            generalInfo = "",
            healingInfo = "",
            preventionInfo = "",
            conclusion = ""
        ),
        PrognosisData(
            id = "Asma",
            generalInfo = "",
            healingInfo = "",
            preventionInfo = "",
            conclusion = ""
        ),
        PrognosisData(
            id = "Asma",
            generalInfo = "",
            healingInfo = "",
            preventionInfo = "",
            conclusion = ""
        ),
        PrognosisData(
            id = "Asma",
            generalInfo = "",
            healingInfo = "",
            preventionInfo = "",
            conclusion = ""
        ),
        PrognosisData(
            id = "Asma",
            generalInfo = "",
            healingInfo = "",
            preventionInfo = "",
            conclusion = ""
        ),
        PrognosisData(
            id = "Asma",
            generalInfo = "",
            healingInfo = "",
            preventionInfo = "",
            conclusion = ""
        ),
        PrognosisData(
            id = "Asma",
            generalInfo = "",
            healingInfo = "",
            preventionInfo = "",
            conclusion = ""
        ),
        PrognosisData(
            id = "Asma",
            generalInfo = "",
            healingInfo = "",
            preventionInfo = "",
            conclusion = ""
        ),
        PrognosisData(
            id = "Asma",
            generalInfo = "",
            healingInfo = "",
            preventionInfo = "",
            conclusion = ""
        ),
        PrognosisData(
            id = "Asma",
            generalInfo = "",
            healingInfo = "",
            preventionInfo = "",
            conclusion = ""
        ),
    )
    Surface (
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.healhub),
                contentDescription = "Healhub Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HeadingTextComponent("Berdasarkan gejala yang anda miliki, anda mungkin mengalami : ")
                HeadingTextComponent(label)
            }
            Column(
                modifier = Modifier
                    .height(400.dp)
                    .padding(16.dp)
                    .verticalScroll(scrollState)
            ) {
                for (prognosisData in prognosisList) {
                    if (prognosisData.id == label) {
                        HeadingPrimaryColor("Apa itu " + prognosisData.id + "?")
                        NormalTextJustifiedComponent(prognosisData.generalInfo)
                        Spacer(modifier = Modifier.height(20.dp))
                        HeadingPrimaryColor("Bagaimana cara mengatasinya?")
                        NormalTextJustifiedComponent(prognosisData.healingInfo)
                        Spacer(modifier = Modifier.height(20.dp))
                        HeadingPrimaryColor("Bagaimana cara mencegah?")
                        NormalTextJustifiedComponent(prognosisData.preventionInfo)
                        Spacer(modifier = Modifier.height(20.dp))
                        HeadingPrimaryColor("Kesimpulan")
                        NormalTextJustifiedComponent(prognosisData.conclusion)
                    }
                }
            }
            ButtonComponent("Back to Home") {
            }
        }

    }
}

/*
@Preview
@Composable
fun DefaultPreviewOfPredictionScreen() {
    PredictionScreen()
}*/
