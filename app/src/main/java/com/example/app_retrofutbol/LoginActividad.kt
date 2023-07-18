package com.example.app_retrofutbol

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.app_retrofutbol.service.AuthService

class LoginActividad : AppCompatActivity() {

    private lateinit var editUser: EditText
    private lateinit var editPassword: EditText
    private lateinit var btnIniciarSesion: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_actividad)

        editUser = findViewById(R.id.editUser)
        editPassword = findViewById(R.id.editPassword)
        btnIniciarSesion = findViewById(R.id.btn_iniciar_sesion)

        btnIniciarSesion.setOnClickListener {
            validarIniciarSesion()
        }
    }

    private fun validarIniciarSesion() {
        val username = editUser.text.toString()
        val password = editPassword.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty()) {
            // Realiza la llamada a la función de inicio de sesión en ApiService
            AuthService.login(username, password) { token, error ->
                if (error != null) {
                    // Manejar el error de autenticación
                    error.printStackTrace()
                } else {
                    // Iniciar sesión exitosamente
                    // Guardar el token en Shared Preferences o en la sesión del usuario, según tu implementación
                    // Ejemplo: SharedPreferencesManager.saveToken(token)

                    // Redirigir a la siguiente actividad
                    val intent = Intent(this, PrincipalActividad::class.java)
                    startActivity(intent)
                    finish() // Opcional, para finalizar la actividad actual
                }
            }
        } else {
            // Mostrar mensaje de error si algún campo está vacío
            // Ejemplo: mostrarToast("Por favor, ingresa nombre de usuario y contraseña")
        }
    }
}
