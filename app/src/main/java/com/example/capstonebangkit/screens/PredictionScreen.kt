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
            id = "Muntaber",
            generalInfo = "Muntaber adalah istilah umum yang digunakan untuk menggambarkan kondisi medis yang melibatkan muntah dan diare secara bersamaan. Muntaber dapat disebabkan oleh berbagai faktor seperti infeksi virus, bakteri, atau parasit, serta keracunan makanan.",
            healingInfo = "Muntaber biasanya bisa sembuh sendiri dalam beberapa hari dengan perawatan yang tepat di rumah. Namun, pengobatan medis mungkin diperlukan dalam kasus yang parah atau jika ada risiko dehidrasi.\n" +
                    "\n" +
                    "1. Rehidrasi:\n" +
                    "    - Oral Rehydration Salts (ORS): Solusi rehidrasi oral untuk menggantikan cairan dan elektrolit yang hilang.\n" +
                    "    - Minum Cairan: Air, kaldu, dan jus buah encer untuk mencegah dehidrasi.\n" +
                    "\n" +
                    "2. Obat untuk Mengatasi Gejala:\n" +
                    "   - Antiemetik: Obat untuk mengurangi muntah seperti domperidone atau ondansetron.\n" +
                    "   - Antidiare: Obat untuk mengurangi diare seperti loperamide, tetapi harus digunakan dengan hati-hati dan sebaiknya setelah berkonsultasi dengan dokter.\n" +
                    "   - Probiotik: Suplemen probiotik untuk membantu memulihkan keseimbangan flora usus.\n" +
                    "\n" +
                    "3. Pengobatan Infeksi:\n" +
                    "   - Antibiotik: Diberikan jika muntaber disebabkan oleh infeksi bakteri, misalnya ciprofloxacin atau azithromycin (hanya digunakan setelah konfirmasi oleh dokter).\n" +
                    "\n" +
                    "4. Perubahan Gaya Hidup:\n" +
                    "   - Istirahat yang Cukup: Memberikan waktu bagi tubuh untuk pulih.\n" +
                    "   - Diet BRAT: Makanan yang mudah dicerna seperti pisang (Banana), nasi (Rice), saus apel (Applesauce), dan roti panggang (Toast) sampai gejala mereda.",
            preventionInfo = "- Kebersihan Tangan: Cuci tangan dengan sabun dan air mengalir, terutama setelah menggunakan toilet dan sebelum makan.\n" +
                    "- Kebersihan Makanan: Pastikan makanan dimasak dengan baik dan disimpan dengan benar untuk mencegah kontaminasi.\n" +
                    "- Air Bersih: Minum air yang bersih dan aman.\n" +
                    "- Imunisasi: Vaksinasi terhadap rotavirus untuk mencegah infeksi pada anak-anak.\n" +
                    "- Hindari Kontak dengan Orang Sakit: Jauhi orang yang sedang mengalami muntaber.",
            conclusion = "Muntaber adalah kondisi medis yang melibatkan muntah dan diare, yang dapat disebabkan oleh infeksi virus, bakteri, parasit, atau keracunan makanan. Gejalanya meliputi muntah-muntah, diare berair, dan nyeri perut. Pengobatan utama adalah rehidrasi, mengelola gejala dengan obat-obatan, dan perubahan gaya hidup. Pencegahan melibatkan kebersihan tangan, makanan, dan air yang baik. Segera konsultasikan dengan dokter jika mengalami gejala dehidrasi atau muntaber yang parah."
        ),
        PrognosisData(
            id = "Asma",
            generalInfo = "Asma adalah penyakit kronis pada saluran pernapasan yang ditandai dengan peradangan dan penyempitan saluran napas. Hal ini menyebabkan sesak napas, batuk, dan napas berbunyi (mengi). Serangan asma bisa dipicu oleh berbagai faktor seperti alergen, aktivitas fisik, atau stres.",
            healingInfo = "Asma tidak bisa disembuhkan, tetapi gejalanya bisa dikendalikan dengan pengobatan yang tepat dan perubahan gaya hidup.\n" +
                    "\n" +
                    "1. Pengobatan Asma:\n" +
                    "\n" +
                    "    a. Obat Kontrol Jangka Panjang:\n" +
                    "        - Inhaled Corticosteroids: Fluticasone (Flovent), Budesonide (Pulmicort)\n" +
                    "        - Leukotriene Modifiers: Montelukast (Singulair)\n" +
                    "        - Long-acting Beta Agonists (LABAs): Salmeterol (Serevent), Formoterol (Foradil)\n" +
                    "        - Combination Inhalers: Fluticasone and Salmeterol (Advair), Budesonide and Formoterol (Symbicort)\n" +
                    "        - Theophylline: Obat oral yang membantu membuka saluran napas.\n" +
                    "\n" +
                    "    b. Obat Pengendali Jangka Pendek:\n" +
                    "        - Short-acting Beta Agonists (SABAs): Albuterol (ProAir, Ventolin)\n" +
                    "        - Anticholinergics: Ipratropium (Atrovent)\n" +
                    "        - Oral and Intravenous Corticosteroids: Prednisone, Methylprednisolone (untuk serangan asma yang parah)\n" +
                    "\n" +
                    "2. Perubahan Gaya Hidup:\n" +
                    "    a. Menghindari Pemicu Asma:\n" +
                    "        - Menjaga kebersihan rumah dari debu dan alergen.\n" +
                    "        - Menggunakan alat pelindung saat terpapar polusi atau alergen.\n" +
                    "    b. Olahraga Teratur:\n" +
                    "        - Melakukan aktivitas fisik yang sesuai dengan kondisi kesehatan dan mengikuti saran dokter.\n" +
                    "    c. Mengelola Stres:\n" +
                    "        - Teknik relaksasi seperti meditasi, yoga, atau latihan pernapasan.\n" +
                    "\n" +
                    "3. Rencana Aksi Asma:\n" +
                    "    a. Membuat dan mengikuti rencana aksi asma yang disusun oleh dokter.\n" +
                    "    b. Mengenali tanda-tanda serangan asma dan mengambil tindakan yang sesuai.",
            preventionInfo = "1. Menghindari Alergen:\n" +
                    "\n" +
                    "    - Mengurangi paparan terhadap alergen seperti debu, serbuk sari, bulu hewan, dan jamur.\n" +
                    "\n" +
                    "2. Menghindari Asap Rokok:\n" +
                    "\n" +
                    "    - Tidak merokok dan menghindari paparan asap rokok.\n" +
                    "\n" +
                    "3. Memonitor Kesehatan Saluran Pernapasan:\n" +
                    "\n" +
                    "    - Mengikuti anjuran dokter dan menjalani pemeriksaan rutin.\n" +
                    "\n" +
                    "4. Vaksinasi:\n" +
                    "\n" +
                    "    - Mendapatkan vaksinasi flu tahunan dan vaksin pneumonia jika dianjurkan oleh dokter.",
            conclusion = "Asma adalah penyakit kronis yang mempengaruhi saluran pernapasan, menyebabkan sesak napas, napas berbunyi, dan batuk. Penyebab asma meliputi faktor genetik, lingkungan, infeksi saluran pernapasan, dan faktor lain seperti aktivitas fisik dan stres. Pengobatan asma mencakup penggunaan obat kontrol jangka panjang dan pengendali jangka pendek, serta perubahan gaya hidup. Pencegahan asma melibatkan menghindari alergen, menghindari asap rokok, dan memonitor kesehatan saluran pernapasan. Konsultasikan dengan dokter jika mengalami gejala asma atau membutuhkan bantuan dalam pengelolaan penyakit."
        ),
        PrognosisData(
            id = "Hipertensi",
            generalInfo = "Hipertensi, atau tekanan darah tinggi, adalah kondisi kronis di mana tekanan darah terhadap dinding arteri terlalu tinggi. Tekanan darah yang tinggi dapat menyebabkan kerusakan pada pembuluh darah dan organ vital seperti jantung, ginjal, otak, dan mata. Hipertensi sering disebut sebagai \"pembunuh diam-diam\" karena sering tidak menunjukkan gejala yang jelas.",
            healingInfo = "Pengelolaan hipertensi melibatkan perubahan gaya hidup dan penggunaan obat-obatan sesuai anjuran dokter.\n" +
                    "\n" +
                    "1. Pengobatan Hipertensi:\n" +
                    "    a. Diuretics:\n" +
                    "        - Hydrochlorothiazide (Microzide), Chlorthalidone.\n" +
                    "    b. Angiotensin-Converting Enzyme (ACE) Inhibitors:\n" +
                    "        - Lisinopril (Prinivil, Zestril), Enalapril (Vasotec).\n" +
                    "    c. Angiotensin II Receptor Blockers (ARBs):\n" +
                    "        - Losartan (Cozaar), Valsartan (Diovan).\n" +
                    "    d. Calcium Channel Blockers:\n" +
                    "        - Amlodipine (Norvasc), Diltiazem (Cardizem).\n" +
                    "    e. Beta Blockers:\n" +
                    "        - Atenolol (Tenormin), Metoprolol (Lopressor, Toprol-XL).\n" +
                    "    f. Renin Inhibitors:\n" +
                    "        - Aliskiren (Tekturna).\n" +
                    "\n" +
                    "2. Perubahan Gaya Hidup:\n" +
                    "    a. Diet Sehat:\n" +
                    "        - Mengurangi asupan garam dan lemak.\n" +
                    "        - Meningkatkan konsumsi buah, sayuran, biji-bijian, dan protein tanpa lemak.\n" +
                    "    b. Olahraga Teratur:\n" +
                    "        - Aktivitas fisik minimal 30 menit sehari, seperti jalan kaki, bersepeda, atau berenang.\n" +
                    "    c. Menghindari Alkohol dan Merokok:\n" +
                    "        - Mengurangi atau menghindari konsumsi alkohol.\n" +
                    "        - Berhenti merokok dan menghindari asap rokok.\n" +
                    "    d. Mengelola Stres:\n" +
                    "        - Teknik relaksasi seperti meditasi, yoga, atau latihan pernapasan.",
            preventionInfo = "1. Pola Makan Sehat:\n" +
                    "    - Diet rendah garam dan lemak, tinggi serat.\n" +
                    "2. Aktivitas Fisik:\n" +
                    "    - Olahraga teratur untuk menjaga berat badan ideal.\n" +
                    "3. Menghindari Kebiasaan Buruk:\n" +
                    "    - Tidak merokok dan membatasi konsumsi alkohol.\n" +
                    "4. Pemeriksaan Kesehatan Rutin:\n" +
                    "    - Memantau tekanan darah secara rutin.\n" +
                    "5. Mengelola Stres:\n" +
                    "    - Menggunakan teknik relaksasi dan menjaga keseimbangan antara pekerjaan dan kehidupan pribadi.",
            conclusion = "Hipertensi adalah kondisi kronis di mana tekanan darah terhadap dinding arteri terlalu tinggi, sering tanpa gejala yang jelas. Penyebabnya meliputi faktor genetik, gaya hidup, dan kondisi medis tertentu. Pengobatan hipertensi mencakup penggunaan obat-obatan seperti diuretik, ACE inhibitors, dan beta blockers, serta perubahan gaya hidup seperti diet sehat, olahraga teratur, dan menghindari kebiasaan buruk. Pencegahan melibatkan pola makan sehat, aktivitas fisik, dan pemeriksaan kesehatan rutin. Konsultasikan dengan dokter jika mengalami gejala hipertensi atau membutuhkan bantuan dalam pengelolaan penyakit."
        ),
        PrognosisData(
            id = "Malaria",
            generalInfo = "Malaria adalah penyakit infeksi yang disebabkan oleh parasit Plasmodium, yang ditularkan melalui gigitan nyamuk Anopheles yang terinfeksi. Malaria dapat menyebabkan gejala seperti demam, menggigil, dan anemia, dan dapat berakibat fatal jika tidak diobati.",
            healingInfo = """
        Pengobatan malaria tergantung pada jenis Plasmodium yang menyebabkan infeksi, tingkat keparahan gejala, dan wilayah geografis di mana infeksi terjadi.
        
        1. Obat-Obatan untuk Malaria:
            - Chloroquine:
                - Digunakan untuk jenis Plasmodium yang masih sensitif terhadap obat ini.
            - Artemisinin-based Combination Therapies (ACTs):
                - Artemether-lumefantrine (Coartem).
                - Artesunate-amodiaquine.
                - Artesunate-mefloquine.
            - Quinine Sulfate:
                - Digunakan bersama dengan doksisiklin atau klindamisin.
            - Atovaquone-proguanil (Malarone):
                - Digunakan untuk pencegahan dan pengobatan.
            - Mefloquine:
                - Digunakan untuk pencegahan dan pengobatan.
            - Primaquine:
                - Digunakan untuk membunuh bentuk parasit yang dapat menyebabkan kambuh.
        
        2. Perawatan Tambahan:
            - Transfusi darah:
                - Dapat diperlukan pada kasus malaria berat dengan anemia parah.
            - Rehidrasi:
                - Penting untuk menggantikan cairan yang hilang karena demam dan keringat.
        
        3. Pencegahan dan Pengendalian:
            - Kelambu berinsektisida.
            - Menggunakan obat nyamuk.
            - Profilaksis antimalaria untuk orang yang bepergian ke daerah endemik.
            - Menguras genangan air untuk mengurangi tempat berkembang biak nyamuk.
    """,
            preventionInfo = """
        Pencegahan malaria melibatkan beberapa langkah penting:
        
        - Menghindari Gigitan Nyamuk:
            - Menggunakan kelambu saat tidur.
            - Menggunakan pakaian yang menutupi tubuh.
            - Menggunakan obat nyamuk.
        
        - Obat Pencegahan (Profilaksis):
            - Mengonsumsi obat antimalaria sebelum, selama, dan setelah bepergian ke daerah endemik.
        
        - Kontrol Vektor:
            - Menjaga kebersihan lingkungan dan menghilangkan tempat berkembang biak nyamuk.
        
        - Edukasi dan Kesadaran:
            - Meningkatkan kesadaran tentang cara mencegah gigitan nyamuk dan gejala malaria.
    """,
            conclusion = """
        Malaria adalah penyakit infeksi yang disebabkan oleh parasit Plasmodium dan ditularkan melalui gigitan nyamuk Anopheles. Gejalanya meliputi demam, menggigil, dan anemia. Pengobatan malaria tergantung pada jenis Plasmodium dan dapat mencakup obat-obatan seperti chloroquine, ACTs, dan quinine sulfate. Pencegahan melibatkan menghindari gigitan nyamuk, menggunakan obat pencegahan, dan kontrol vektor. Konsultasikan dengan dokter jika mengalami gejala malaria atau membutuhkan bantuan dalam pengelolaan penyakit.
    """
        ),
        PrognosisData(
            id = "Cacar Air",
            generalInfo = "Cacar air adalah penyakit menular yang disebabkan oleh virus varicella-zoster. Penyakit ini umumnya terjadi pada anak-anak dan ditandai dengan munculnya ruam kulit berbentuk bintik-bintik merah yang berubah menjadi lepuhan gatal, kemudian menjadi koreng.",
            healingInfo = """
        Pengobatan cacar air bertujuan untuk mengurangi gejala dan mencegah komplikasi.
        
        1. Obat-Obatan untuk Cacar Air:
            - Antihistamin:
                - Untuk mengurangi gatal (Cetirizine, Diphenhydramine).
            - Obat Pereda Nyeri:
                - Untuk mengurangi demam dan rasa sakit (Paracetamol).
                - Hindari penggunaan aspirin karena dapat menyebabkan sindrom Reye pada anak-anak.
            - Antiviral:
                - Aciclovir: Dapat digunakan pada kasus berat atau untuk individu dengan risiko komplikasi tinggi.
        
        2. Perawatan di Rumah:
            - Mandi dengan air hangat yang dicampur dengan oatmeal koloid atau soda kue untuk mengurangi gatal.
            - Menggunakan losion kalamin pada ruam untuk mengurangi gatal.
            - Menghindari menggaruk lepuhan untuk mencegah infeksi bakteri sekunder.
            - Memotong kuku pendek untuk mengurangi kerusakan akibat garukan.
        
        3. Pencegahan:
            - Vaksin Varicella:
                - Vaksin ini sangat efektif dalam mencegah cacar air.
    """,
            preventionInfo = """
        Pencegahan cacar air melibatkan beberapa langkah penting:
        
        - Vaksinasi:
            - Vaksin varicella sangat efektif dalam mencegah cacar air dan direkomendasikan untuk semua anak, serta orang dewasa yang belum pernah terinfeksi atau divaksinasi.
        
        - Menghindari Kontak:
            - Menghindari kontak dengan orang yang terinfeksi hingga semua lepuhan berubah menjadi koreng.
        
        - Mengisolasi Pasien:
            - Mengisolasi individu yang terinfeksi untuk mencegah penyebaran virus ke orang lain.
    """,
            conclusion = """
        Cacar air adalah penyakit menular yang disebabkan oleh virus varicella-zoster dan ditandai dengan ruam kulit yang berubah menjadi lepuhan gatal. Pengobatan cacar air fokus pada pengurangan gejala dan pencegahan komplikasi, termasuk penggunaan antihistamin, obat pereda nyeri, dan antiviral seperti aciclovir. Pencegahan cacar air yang paling efektif adalah melalui vaksinasi varicella. Konsultasikan dengan dokter jika mengalami gejala cacar air atau membutuhkan bantuan dalam pengelolaan penyakit.
    """
        ),
        PrognosisData(
            id = "Demam Berdarah",
            generalInfo = "Demam Berdarah Dengue (DBD) adalah penyakit yang disebabkan oleh virus dengue yang ditularkan melalui gigitan nyamuk Aedes aegypti. Penyakit ini ditandai dengan demam tinggi mendadak, nyeri sendi dan otot, sakit kepala parah, ruam, dan penurunan jumlah trombosit yang dapat menyebabkan perdarahan.",
            healingInfo = """
        Pengobatan Demam Berdarah Dengue (DBD) berfokus pada mengelola gejala dan mendukung pemulihan pasien.
        
        1. Pengobatan untuk Demam Berdarah:
            - Tidak ada obat antivirus spesifik untuk DBD.
            - Penanganan gejala dilakukan untuk mencegah komplikasi serius.
        
        2. Obat-Obatan:
            - Obat Pereda Nyeri dan Demam:
                - Paracetamol: Digunakan untuk menurunkan demam dan mengurangi nyeri.
                - Hindari penggunaan aspirin dan ibuprofen karena dapat meningkatkan risiko perdarahan.
        
        3. Terapi Cairan:
            - Rehidrasi: Penting untuk mencegah dehidrasi, terutama pada kasus DBD yang berat.
            - Pemberian cairan melalui oral atau infus, tergantung pada tingkat dehidrasi.
        
        4. Pengawasan Medis:
            - Pemantauan ketat terhadap jumlah trombosit dan hematokrit untuk mendeteksi tanda-tanda perdarahan atau kebocoran plasma.
            - Pengawasan di rumah sakit mungkin diperlukan untuk kasus yang parah.
    """,
            preventionInfo = """
        Pencegahan Demam Berdarah Dengue melibatkan langkah-langkah berikut:
        
        - Pengendalian Nyamuk:
            - Menguras, menutup, dan mendaur ulang wadah yang dapat menampung air untuk mencegah perkembangbiakan nyamuk.
            - Menggunakan insektisida di dalam dan di luar rumah.
        
        - Perlindungan Diri:
            - Menggunakan pakaian lengan panjang dan celana panjang.
            - Menggunakan repelan nyamuk yang mengandung DEET, picaridin, atau minyak lemon eucalyptus.
        
        - Vaksinasi:
            - Vaksin Dengvaxia direkomendasikan di beberapa negara untuk individu yang pernah terinfeksi dengue sebelumnya.
        
        - Menghindari Gigitan Nyamuk:
            - Menggunakan kelambu saat tidur, terutama di daerah endemis.
            - Memasang kawat kasa di jendela dan pintu untuk mencegah masuknya nyamuk.
    """,
            conclusion = """
        Demam Berdarah Dengue (DBD) adalah penyakit yang disebabkan oleh virus dengue dan ditularkan melalui gigitan nyamuk Aedes aegypti. Pengobatan DBD berfokus pada mengelola gejala seperti demam dan nyeri, serta menjaga hidrasi pasien. Pencegahan DBD melibatkan pengendalian nyamuk, perlindungan diri dari gigitan nyamuk, dan vaksinasi di daerah endemis. Konsultasikan dengan dokter jika mengalami gejala DBD atau membutuhkan informasi lebih lanjut mengenai pencegahan dan pengelolaan penyakit ini.
    """
        ),
        PrognosisData(
            id = "Tipes",
            generalInfo = "Tipes, atau demam tifoid, adalah penyakit bakteri yang disebabkan oleh Salmonella typhi. Penyakit ini menyebar melalui makanan dan air yang terkontaminasi. Gejala tipes meliputi demam tinggi, sakit perut, sakit kepala, lemas, dan terkadang ruam kulit.",
            healingInfo = """
        Pengobatan Tipes berfokus pada mengeliminasi bakteri penyebab dan mengelola gejala yang muncul.
        
        1. Pengobatan untuk Tipes:
            - Pengobatan utama untuk tipes adalah antibiotik.
        
        2. Obat-Obatan:
            - Antibiotik:
                - Ciprofloxacin: Biasanya digunakan pada orang dewasa yang tidak hamil.
                - Azithromycin: Alternatif bagi mereka yang tidak bisa menggunakan ciprofloxacin.
                - Ceftriaxone: Digunakan untuk kasus yang parah atau bagi mereka yang tidak bisa minum obat oral.
        
        3. Terapi Supportif:
            - Rehidrasi: Penting untuk mencegah dehidrasi, terutama pada kasus dengan diare berat.
            - Pemberian cairan oral atau infus, tergantung pada tingkat dehidrasi.
        
        4. Perawatan di Rumah:
            - Istirahat yang cukup untuk membantu pemulihan.
            - Makan makanan lunak yang mudah dicerna dan menghindari makanan pedas atau berlemak.
            - Memantau suhu tubuh secara teratur dan mengonsumsi obat penurun demam sesuai anjuran dokter.
        
        5. Pengawasan Medis:
            - Pemantauan ketat untuk menghindari komplikasi seperti perdarahan usus atau perforasi usus.
            - Konsultasi rutin dengan dokter untuk memantau perkembangan kondisi.
    """,
            preventionInfo = """
        Pencegahan Tipes melibatkan langkah-langkah berikut:
        
        - Kebersihan Makanan dan Air:
            - Memastikan makanan dimasak dengan baik dan disajikan dalam keadaan panas.
            - Menghindari makanan dan minuman dari sumber yang tidak terpercaya.
            - Minum air yang telah direbus atau menggunakan air minum kemasan.
        
        - Vaksinasi:
            - Vaksin tifoid oral atau suntik tersedia untuk orang yang bepergian ke daerah endemis.
        
        - Kebersihan Pribadi:
            - Cuci tangan dengan sabun dan air mengalir sebelum makan dan setelah menggunakan toilet.
            - Menghindari kontak langsung dengan orang yang terinfeksi.
        
        - Sanitasi Lingkungan:
            - Memastikan sanitasi yang baik dan akses ke air bersih di lingkungan tempat tinggal.
    """,
            conclusion = """
        Tipes, atau demam tifoid, adalah penyakit bakteri yang disebabkan oleh Salmonella typhi dan menyebar melalui makanan dan air yang terkontaminasi. Pengobatan utama untuk tipes adalah antibiotik, dengan terapi supportif seperti rehidrasi dan istirahat yang cukup. Pencegahan tipes melibatkan kebersihan makanan dan air, vaksinasi, kebersihan pribadi, dan sanitasi lingkungan. Konsultasikan dengan dokter jika mengalami gejala tipes atau membutuhkan informasi lebih lanjut mengenai pencegahan dan pengelolaan penyakit ini.
    """
        )
        ,
        PrognosisData(
            id = "Hepatitis A",
            generalInfo = "Hepatitis A adalah infeksi virus yang menyerang hati dan umumnya disebabkan oleh pola makan atau minuman yang terkontaminasi. Gejala umumnya meliputi demam, kelelahan, kehilangan nafsu makan, mual, muntah, dan kuning pada kulit dan mata (jaundice).",
            healingInfo = """
        Pengobatan Hepatitis A berfokus pada memberikan dukungan pada fungsi hati dan mengelola gejalanya.
        
        1. Pengobatan untuk Hepatitis A:
            - Tidak ada pengobatan antivirus khusus untuk Hepatitis A.
            - Terapi lebih bersifat suportif untuk mengurangi gejala dan memfasilitasi pemulihan.
        
        2. Istirahat dan Diet:
            - Istirahat yang cukup dan diet seimbang membantu pemulihan.
            - Hindari konsumsi alkohol untuk mencegah kerusakan hati lebih lanjut.
        
        3. Obat-Obatan:
            - Tergantung pada gejala individu, dokter dapat meresepkan obat untuk mengurangi mual atau muntah.
        
        4. Pemantauan Medis:
            - Pemantauan terhadap fungsi hati dengan pemeriksaan darah secara berkala.
            - Konsultasi rutin dengan dokter untuk memantau kemajuan pemulihan.
    """,
            preventionInfo = """
        Pencegahan Hepatitis A melibatkan langkah-langkah berikut:
        
        - Kebersihan dan Sanitasi:
            - Mencuci tangan dengan sabun dan air mengalir sebelum makan dan setelah menggunakan toilet.
            - Menghindari mengonsumsi makanan atau minuman yang tidak terjamin kebersihannya.
        
        - Vaksinasi:
            - Vaksin Hepatitis A direkomendasikan untuk individu yang berisiko tinggi, seperti mereka yang bepergian ke daerah dengan tingkat kejadian tinggi atau pekerja kesehatan.
        
        - Perlindungan Seksual:
            - Penggunaan kondom dapat membantu mencegah penularan melalui kontak seksual.
        
        - Pencegahan di Komunitas:
            - Menyediakan akses air bersih dan fasilitas sanitasi yang memadai.
            - Edukasi masyarakat mengenai pentingnya kebersihan dan vaksinasi.
    """,
            conclusion = """
        Hepatitis A adalah infeksi virus pada hati yang umumnya ditularkan melalui makanan atau minuman yang terkontaminasi. Pengobatan terutama bersifat suportif dengan fokus pada istirahat, diet seimbang, dan pemantauan medis. Pencegahan Hepatitis A melibatkan praktik kebersihan yang baik, vaksinasi untuk individu berisiko, dan edukasi masyarakat. Konsultasikan dengan dokter untuk informasi lebih lanjut mengenai pencegahan dan penanganan Hepatitis A.
    """
        ),
        PrognosisData(
            id = "Hepatitis C",
            generalInfo = "Hepatitis C adalah infeksi virus pada hati yang umumnya ditularkan melalui kontak dengan darah yang terinfeksi. Infeksi Hepatitis C dapat menyebabkan peradangan hati yang kronis dan merusak hati secara bertahap tanpa gejala yang jelas pada tahap awal.",
            healingInfo = """
        Pengobatan Hepatitis C telah mengalami kemajuan signifikan dalam beberapa tahun terakhir.
        
        1. Pengobatan untuk Hepatitis C:
            - Terapi antivirus direkomendasikan untuk mengobati infeksi Hepatitis C.
            - Obat antiviral langsung (DAA) seperti sofosbuvir, ledipasvir, daclatasvir, atau glecaprevir/pibrentasvir digunakan untuk menghilangkan virus dari tubuh dengan tingkat keberhasilan yang tinggi.
        
        2. Durasi Pengobatan:
            - Durasi pengobatan tergantung pada genotipe virus Hepatitis C dan kondisi kesehatan pasien.
            - Rata-rata pengobatan dapat berlangsung antara 8 hingga 12 minggu tergantung pada rencana terapi yang disusun oleh dokter.
        
        3. Pemantauan Medis:
            - Pemantauan rutin terhadap respons terapi dan fungsi hati diperlukan selama dan setelah pengobatan.
            - Tes darah untuk mengukur level virus dan fungsi hati akan dilakukan secara berkala.
        
        4. Pencegahan Transmisi:
            - Menghindari berbagi jarum suntik, alat cukur, atau alat pribadi lainnya dengan orang lain.
            - Praktik seks yang aman dapat mengurangi risiko penularan melalui kontak seksual.
    """,
            preventionInfo = """
        Pencegahan Hepatitis C melibatkan tindakan-tindakan berikut:
        
        - Penggunaan Alat Pribadi:
            - Tidak berbagi jarum suntik, sikat gigi, atau alat cukur dengan orang lain.
            - Pastikan alat-alat medis atau kosmetik yang digunakan steril atau hanya digunakan oleh satu orang.
        
        - Edukasi dan Kesadaran Masyarakat:
            - Meningkatkan pemahaman masyarakat tentang cara penularan Hepatitis C dan langkah-langkah pencegahan yang efektif.
        
        - Pemeriksaan dan Tes:
            - Tes darah secara rutin dapat membantu dalam mendeteksi infeksi Hepatitis C pada tahap awal.
            - Konsultasikan dengan dokter untuk pemantauan kesehatan secara berkala.
    """,
            conclusion = """
        Hepatitis C adalah infeksi virus pada hati yang dapat menyebabkan kerusakan hati kronis jika tidak diobati. Pengobatan saat ini sangat efektif dengan terapi antivirus langsung (DAA) yang menghilangkan virus dari tubuh. Pencegahan melibatkan praktik kebersihan yang baik dan menghindari perilaku berisiko. Konsultasikan dengan dokter untuk informasi lebih lanjut mengenai pencegahan, diagnosis, dan penanganan Hepatitis C.
    """
        ),
        PrognosisData(
            id = "Hepatitis C",
            generalInfo = "Hepatitis C adalah infeksi virus pada hati yang umumnya ditularkan melalui kontak dengan darah yang terinfeksi. Infeksi Hepatitis C dapat menyebabkan peradangan hati yang kronis dan merusak hati secara bertahap tanpa gejala yang jelas pada tahap awal.",
            healingInfo = """
        Pengobatan Hepatitis C telah mengalami kemajuan signifikan dalam beberapa tahun terakhir.
        
        1. Pengobatan untuk Hepatitis C:
            - Terapi antivirus direkomendasikan untuk mengobati infeksi Hepatitis C.
            - Obat antiviral langsung (DAA) seperti sofosbuvir, ledipasvir, daclatasvir, atau glecaprevir/pibrentasvir digunakan untuk menghilangkan virus dari tubuh dengan tingkat keberhasilan yang tinggi.
        
        2. Durasi Pengobatan:
            - Durasi pengobatan tergantung pada genotipe virus Hepatitis C dan kondisi kesehatan pasien.
            - Rata-rata pengobatan dapat berlangsung antara 8 hingga 12 minggu tergantung pada rencana terapi yang disusun oleh dokter.
        
        3. Pemantauan Medis:
            - Pemantauan rutin terhadap respons terapi dan fungsi hati diperlukan selama dan setelah pengobatan.
            - Tes darah untuk mengukur level virus dan fungsi hati akan dilakukan secara berkala.
        
        4. Pencegahan Transmisi:
            - Menghindari berbagi jarum suntik, alat cukur, atau alat pribadi lainnya dengan orang lain.
            - Praktik seks yang aman dapat mengurangi risiko penularan melalui kontak seksual.
    """,
            preventionInfo = """
        Pencegahan Hepatitis C melibatkan tindakan-tindakan berikut:
        
        - Penggunaan Alat Pribadi:
            - Tidak berbagi jarum suntik, sikat gigi, atau alat cukur dengan orang lain.
            - Pastikan alat-alat medis atau kosmetik yang digunakan steril atau hanya digunakan oleh satu orang.
        
        - Edukasi dan Kesadaran Masyarakat:
            - Meningkatkan pemahaman masyarakat tentang cara penularan Hepatitis C dan langkah-langkah pencegahan yang efektif.
        
        - Pemeriksaan dan Tes:
            - Tes darah secara rutin dapat membantu dalam mendeteksi infeksi Hepatitis C pada tahap awal.
            - Konsultasikan dengan dokter untuk pemantauan kesehatan secara berkala.
    """,
            conclusion = """
        Hepatitis C adalah infeksi virus pada hati yang dapat menyebabkan kerusakan hati kronis jika tidak diobati. Pengobatan saat ini sangat efektif dengan terapi antivirus langsung (DAA) yang menghilangkan virus dari tubuh. Pencegahan melibatkan praktik kebersihan yang baik dan menghindari perilaku berisiko. Konsultasikan dengan dokter untuk informasi lebih lanjut mengenai pencegahan, diagnosis, dan penanganan Hepatitis C.
    """
        ),
        PrognosisData(
            id = "Tuberkulosis",
            generalInfo = "Tuberkulosis (TB) adalah penyakit menular yang disebabkan oleh bakteri Mycobacterium tuberculosis. Penyakit ini umumnya menyerang paru-paru, tetapi juga dapat mempengaruhi bagian tubuh lain seperti ginjal, tulang, atau otak. Gejala utama TB termasuk batuk kronis, demam, penurunan berat badan, dan keringat malam.",
            healingInfo = """
        Pengobatan Tuberkulosis biasanya memerlukan kombinasi obat antibakteri untuk periode waktu yang cukup lama.
        
        1. Pengobatan untuk Tuberkulosis:
            - Terapi standar untuk TB adalah pengobatan kombinasi dengan beberapa jenis antibiotik.
            - Regimen pengobatan yang umum digunakan termasuk isoniazid, rifampisin, pyrazinamide, dan ethambutol.
        
        2. Durasi Pengobatan:
            - Pengobatan awal TB biasanya berlangsung selama 6 hingga 9 bulan tergantung pada jenis dan tingkat keparahan TB.
            - Penting untuk mengikuti jadwal pengobatan yang disarankan oleh dokter untuk memastikan eradikasi bakteri TB secara efektif.
        
        3. Pemantauan Medis:
            - Pemantauan secara rutin terhadap respons terapi dan efek samping obat diperlukan.
            - Tes darah dan pemeriksaan dahak mungkin dilakukan untuk menilai kemajuan pengobatan.
        
        4. Pencegahan Penularan:
            - Meningkatkan kebersihan dan ventilasi ruangan untuk mengurangi risiko penularan TB di lingkungan yang padat.
            - Mengamankan pengobatan yang konsisten dan tepat waktu untuk individu yang terinfeksi atau berisiko tinggi.
    """,
            preventionInfo = """
        Pencegahan Tuberkulosis melibatkan tindakan-tindakan berikut:
        
        - Vaksinasi:
            - Vaksin BCG (Bacille Calmette-Guérin) dapat membantu melindungi terhadap infeksi TB pada anak-anak.
            - Meskipun tidak memberikan perlindungan total, vaksin BCG dapat mengurangi keparahan penyakit pada anak-anak.
        
        - Menghindari Paparan dan Kontak:
            - Mencegah kontak dengan individu yang didiagnosis menderita TB aktif.
            - Mengamati praktik kebersihan pernapasan seperti menutup mulut saat batuk atau bersin.
        
        - Deteksi Dini dan Pengobatan Awal:
            - Tes screening secara rutin dan deteksi dini TB pada populasi berisiko tinggi dapat membantu dalam pengobatan dini dan pencegahan penularan lebih lanjut.
        
        - Edukasi Masyarakat:
            - Meningkatkan kesadaran masyarakat tentang gejala TB, cara penularannya, dan pentingnya pengobatan yang tepat waktu.
    """,
            conclusion = """
        Tuberkulosis adalah penyakit menular yang disebabkan oleh bakteri Mycobacterium tuberculosis. Pengobatan TB melibatkan regimen antibiotik yang diberikan dalam jangka waktu yang cukup lama untuk memastikan eradikasi bakteri secara efektif. Pencegahan melibatkan vaksinasi, praktik kebersihan yang baik, deteksi dini, dan pengobatan awal. Konsultasikan dengan dokter untuk informasi lebih lanjut mengenai pencegahan, diagnosis, dan penanganan Tuberkulosis.
    """
        ),
        PrognosisData(
            id = "Paru-Paru Basah",
            generalInfo = "Paru-paru basah atau pneumonia adalah infeksi pada salah satu atau kedua paru-paru yang disebabkan oleh bakteri, virus, atau jamur. Gejalanya dapat bervariasi, termasuk batuk dengan dahak, demam, napas cepat atau sesak napas, nyeri dada, dan kelelahan.",
            healingInfo = """
        Pengobatan Paru-paru Basah tergantung pada penyebabnya dan tingkat keparahannya.
        
        1. Pengobatan untuk Paru-paru Basah:
            - Jika disebabkan oleh bakteri, antibiotik seperti amoksisilin, azitromisin, atau seftriakson biasanya diresepkan.
            - Virus penyebab pneumonia sering kali tidak merespons terhadap antibiotik, dan perawatan dapat berfokus pada meringankan gejala.
        
        2. Terapi Oksigen:
            - Dalam kasus yang parah, terapi oksigen mungkin diperlukan untuk membantu pasien bernapas lebih mudah.
            - Penggunaan ventilator dapat diperlukan jika kondisi napas sangat terganggu.
        
        3. Pemantauan Medis:
            - Pemantauan terhadap respons terapi dan pemantauan fungsi paru-paru dengan pemeriksaan fisik dan tes darah.
            - Dalam beberapa kasus, rontgen dada dapat diperlukan untuk memantau perkembangan penyakit.
        
        4. Istirahat dan Pemulihan:
            - Istirahat yang cukup dan asupan cairan yang adekuat membantu dalam proses penyembuhan.
            - Pasien mungkin memerlukan waktu untuk pulih sepenuhnya tergantung pada keparahan pneumonia.
    """,
            preventionInfo = """
        Pencegahan Paru-paru Basah melibatkan langkah-langkah berikut:
        
        - Vaksinasi:
            - Vaksin pneumonia (pneumococcal vaccine) direkomendasikan untuk individu yang berisiko tinggi, seperti lanjut usia atau mereka dengan kondisi medis tertentu.
            - Vaksin influenza juga dapat membantu mengurangi risiko pneumonia yang disebabkan oleh virus flu.
        
        - Kebersihan Tangan:
            - Mencuci tangan secara teratur dengan sabun dan air mengurangi risiko penularan infeksi saluran pernapasan.
        
        - Hindari Merokok:
            - Merokok meningkatkan risiko pneumonia serta memperparah kondisi paru-paru.
        
        - Perhatikan Kesehatan Umum:
            - Mempertahankan gaya hidup sehat dengan diet seimbang, olahraga teratur, dan tidur yang cukup membantu menjaga sistem kekebalan tubuh yang kuat.
    """,
            conclusion = """
        Paru-paru basah adalah infeksi pada paru-paru yang dapat disebabkan oleh berbagai mikroorganisme. Pengobatan tergantung pada penyebabnya, dengan penggunaan antibiotik untuk infeksi bakteri. Pencegahan melibatkan vaksinasi, praktik kebersihan yang baik, dan menjaga kesehatan umum. Konsultasikan dengan dokter untuk informasi lebih lanjut mengenai pencegahan, diagnosis, dan penanganan Paru-paru Basah.
    """
        ),
        PrognosisData(
            id = "Vertigo",
            generalInfo = "Vertigo adalah sensasi pusing atau perasaan berputar yang dapat disertai dengan mual, muntah, atau ketidakseimbangan. Hal ini sering kali disebabkan oleh gangguan pada sistem keseimbangan dalam telinga dalam (sistem vestibular). Vertigo dapat bersifat sementara atau kronis, tergantung pada penyebabnya.",
            healingInfo = """
        Pengobatan Vertigo tergantung pada jenis vertigo yang dialami oleh individu.
        
        1. Pengobatan untuk Vertigo:
            - Untuk Vertigo Benigna Paroksismal Posisional (BPPV), manuver terapeutik seperti manuver Epley atau Semont dapat membantu menggeser partikel yang menyebabkan vertigo dalam telinga dalam.
            - Untuk Vertigo Vestibular Meniere, pengelolaan diet rendah garam, obat diuretik, atau terapi rehabilitasi vestibular dapat direkomendasikan.
            - Vertigo yang disebabkan oleh infeksi telinga bagian dalam (labirinitis atau neuronitis vestibular) dapat memerlukan penggunaan obat antiemetik untuk mengurangi mual dan muntah.
        
        2. Terapi Fisik:
            - Terapi rehabilitasi vestibular, yang meliputi latihan dan teknik untuk memperbaiki keseimbangan, sering kali dianjurkan untuk mengatasi gejala vertigo kronis.
        
        3. Obat-Obatan:
            - Obat antiemetik seperti dimenhidrinat atau prometazin dapat membantu mengatasi mual dan muntah yang terkait dengan vertigo.
            - Pada kasus tertentu, dokter dapat meresepkan obat-obatan tertentu untuk mengurangi frekuensi serangan vertigo atau mengontrol gejala.
        
        4. Modifikasi Gaya Hidup:
            - Menghindari posisi yang memicu serangan vertigo, seperti gerakan kepala tiba-tiba atau posisi tertentu.
            - Menjaga lingkungan yang aman untuk mengurangi risiko jatuh akibat ketidakseimbangan.
    """,
            preventionInfo = """
        Pencegahan Vertigo terutama berkaitan dengan mengidentifikasi dan mengelola penyebab yang mendasarinya:
        
        - Menjaga Kesehatan Telinga:
            - Menghindari paparan terhadap faktor risiko yang dapat merusak telinga, seperti kebisingan tinggi atau trauma kepala.
        
        - Perawatan Kesehatan yang Tepat:
            - Mengelola kondisi kesehatan yang dapat menyebabkan vertigo, seperti hipertensi atau diabetes, dengan perawatan yang tepat.
        
        - Modifikasi Gaya Hidup:
            - Menghindari stres berlebihan dan mempraktikkan teknik relaksasi dapat membantu mengurangi gejala vertigo yang dipicu oleh faktor psikologis.
        
        - Konsultasi Medis:
            - Konsultasikan dengan dokter jika mengalami sering vertigo atau gejala yang mengganggu, untuk mendapatkan diagnosis dan pengelolaan yang tepat.
    """,
            conclusion = """
        Vertigo adalah kondisi yang dapat disebabkan oleh berbagai faktor, terutama gangguan pada sistem keseimbangan telinga dalam. Pengobatan tergantung pada penyebabnya, dengan pilihan terapi seperti manuver terapeutik, terapi fisik, atau penggunaan obat-obatan. Pencegahan melibatkan mengidentifikasi penyebab yang mendasarinya dan mengelola faktor risiko. Konsultasikan dengan dokter untuk informasi lebih lanjut mengenai pencegahan, diagnosis, dan penanganan Vertigo.
    """
        ),
        PrognosisData(
            id = "Infeksi Saluran Kemih",
            generalInfo = "Infeksi Saluran Kemih (ISK) adalah kondisi di mana bakteri menginfeksi bagian saluran kemih, seperti kandung kemih atau uretra. Gejala ISK bisa mencakup sering buang air kecil, rasa terbakar saat buang air kecil, urin berbau tidak sedap, dan nyeri pada bagian perut atau pinggang.",
            healingInfo = """
        Pengobatan Infeksi Saluran Kemih tergantung pada lokasi dan tingkat keparahannya.
        
        1. Pengobatan untuk Infeksi Saluran Kemih:
            - Antibiotik adalah pengobatan utama untuk ISK bakterial.
            - Antibiotik yang umum diresepkan untuk ISK meliputi nitrofurantoin, trimethoprim-sulfamethoxazole, atau ciprofloxacin.
            - Durasi pengobatan biasanya bervariasi tergantung pada faktor seperti jenis bakteri, lokasi infeksi, dan respons terhadap antibiotik.
        
        2. Pemantauan dan Evaluasi:
            - Setelah memulai pengobatan, penting untuk memantau gejala dan melakukan evaluasi lanjutan jika diperlukan.
            - Pemeriksaan urine untuk memastikan pengobatan berhasil dalam menghilangkan bakteri penyebab.
        
        3. Perawatan Diri:
            - Minum banyak cairan untuk membantu membersihkan bakteri dari saluran kemih.
            - Hindari mengonsumsi alkohol, kafein, atau makanan pedas yang dapat memperburuk gejala.
        
        4. Pencegahan:
            - Praktik kebersihan pribadi yang baik, seperti membersihkan area genital secara teratur dan menghindari penggunaan sabun yang berpotensi mengiritasi.
            - Buang air kecil setelah berhubungan seksual untuk mencegah penyebaran bakteri ke saluran kemih.
    """,
            preventionInfo = """
        Pencegahan Infeksi Saluran Kemih melibatkan tindakan-tindakan berikut:
        
        - Minum banyak cairan:
            - Menjaga agar tubuh tetap terhidrasi membantu untuk membersihkan bakteri dari saluran kemih.
        
        - Praktik Kebersihan:
            - Membersihkan area genital dengan hati-hati dan menggunakan produk yang tidak mengiritasi.
            - Mengganti pembalut atau tampon secara teratur selama menstruasi.
        
        - Buang Air Kecil Setelah Berhubungan Seksual:
            - Melakukan buang air kecil setelah berhubungan seksual dapat membantu mengurangi risiko bakteri masuk ke saluran kemih.
        
        - Menghindari Produk Kimia yang Mengiritasi:
            - Menggunakan sabun atau produk pembersih yang lembut dan tidak mengandung pewangi atau bahan kimia yang dapat menyebabkan iritasi.
    """,
            conclusion = """
        Infeksi Saluran Kemih adalah kondisi umum yang disebabkan oleh infeksi bakteri pada bagian saluran kemih. Pengobatan utamanya adalah dengan antibiotik, sementara pencegahan melibatkan praktik kebersihan yang baik dan penyesuaian gaya hidup. Konsultasikan dengan dokter untuk informasi lebih lanjut mengenai pencegahan, diagnosis, dan penanganan Infeksi Saluran Kemih.
    """
        )
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
