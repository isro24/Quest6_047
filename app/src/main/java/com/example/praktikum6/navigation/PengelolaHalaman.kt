package com.example.praktikum6.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.praktikum6.ui.view.viewmodel.MahasiswaViewModel
import com.example.praktikum6.ui.view.viewmodel.RencanaStudyViewModel

enum class Halaman {
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
)
{

}