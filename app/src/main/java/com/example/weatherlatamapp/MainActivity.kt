package com.example.weatherlatamapp

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherlatamapp.ui.theme.WeatherLatamAppTheme
import com.google.firebase.crashlytics.FirebaseCrashlytics

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Log un mensaje a Crashlytics
        FirebaseCrashlytics.getInstance().log("Este es un mensaje de prueba")

        //setear una clave
        val buildVariant = BuildConfig.ENVIROMENT
        FirebaseCrashlytics.getInstance().setCustomKey("app_env", buildVariant)

        //setear un color de fondo basado en la variable de entorno
        val backgroundColor = when (buildVariant) {
            "dev" -> android.R.color.holo_red_dark
            "qa" -> android.R.color.holo_orange_light
            "prod" -> android.R.color.black
            else -> android.R.color.white
        }
        findViewById<View>(R.id.main_layout).setBackgroundColor(resources.getColor(backgroundColor))
    }
}