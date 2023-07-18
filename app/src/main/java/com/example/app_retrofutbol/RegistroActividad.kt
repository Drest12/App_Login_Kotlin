package com.example.app_retrofutbol

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.app_retrofutbol.databinding.RegistroActividadBinding

class RegistroActividad : AppCompatActivity() {


    private lateinit var binding: RegistroActividadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = RegistroActividadBinding.inflate(layoutInflater)
        setContentView(binding.root)







    }


}