package com.cumulation.retrofitexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cumulation.retrofitexample.navigation.SetUpNavigation
import com.cumulation.retrofitexample.netwok.api.NetworkResult
import com.cumulation.retrofitexample.repo.NetworkRepositry
import com.cumulation.retrofitexample.ui.theme.RetrofitExampleTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitExampleTheme {
                navController = rememberNavController()
                SetUpNavigation(navController)
            }
        }
    }
}

