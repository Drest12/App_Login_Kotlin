package com.example.app_retrofutbol


import android.content.Intent
import android.os.Bundle
import android.widget.Button

import androidx.appcompat.app.AppCompatActivity

import com.example.app_retrofutbol.databinding.InicioActividadBinding


class InicioActividad : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio_actividad)

        // Configurar el clic del botón para redireccionar a la actividad de inicio de sesión
        val btn_login = findViewById<Button>(R.id.btn_login)
        btn_login.setOnClickListener {
            val intent = Intent(this, LoginActividad::class.java)
            startActivity(intent)
        }
        val btn_registrar=findViewById<Button>(R.id.btn_registrar)
        btn_registrar.setOnClickListener {
            val intent =Intent(this,RegistroActividad::class.java)
            startActivity(intent)
        }


    }



}