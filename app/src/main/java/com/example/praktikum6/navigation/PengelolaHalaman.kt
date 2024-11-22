package com.example.praktikum6.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.praktikum6.ui.view.screen.MahasiswaFormView
import com.example.praktikum6.ui.view.screen.RencanaStudyView
import com.example.praktikum6.ui.view.screen.SplashView
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
    val MahasiswaUiState = mahasiswaViewModel.mhsStateUi.collectAsState()
    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = modifier.padding()
    ){
        composable(route = Halaman.Splash.name){
            SplashView {
                navController.navigate(Halaman.Mahasiswa.name)
            }
        }
        composable(route = Halaman.Mahasiswa.name)
        {
            MahasiswaFormView(onSubmitClicked = {
                mahasiswaViewModel.saveDataMhs(it)
                navController.navigate(Halaman.Mahasiswa.name)
            },
                onBackButtonClicked = {
                    navController.popBackStack()},
            )
        }
        composable(route = Halaman.Mahasiswa.name){
            RencanaStudyView(
                mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = { krsViewModel.saveDataKRS(it)},
                onBackButtonClicked = { navController.popBackStack()}
            )
        }
    }
}