package com.example.app_retrofutbol.service
import okhttp3.*
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import java.io.IOException
object AuthService {
    private val client = OkHttpClient()
    private val gson = Gson()
    private val baseUrl = "http://192.168.0.2:8080" // Reemplaza con la URL base de tu API

    data class LoginRequest(val username: String, val password: String)

    data class JwtResponse(val token: String)

    fun login(username: String, password: String, callback: (String?, Exception?) -> Unit) {
        val url = "$baseUrl/generate-token" // Reemplaza con la URL correcta de tu servicio de inicio de sesión

        // Crear el objeto de solicitud de inicio de sesión
        val loginRequest = LoginRequest(username, password)

        // Serializar el objeto LoginRequest a JSON
        val json = gson.toJson(loginRequest)

        // Crear el cuerpo de la solicitud POST
        val requestBody = RequestBody.create("application/json".toMediaTypeOrNull(), json)

        // Crear la solicitud POST
        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()

        // Ejecutar la solicitud POST de forma asíncrona
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                // Manejar el error de conexión
                callback(null, e)
            }

            override fun onResponse(call: Call, response: Response) {
                val responseBody = response.body?.string()

                if (response.isSuccessful && responseBody != null) {
                    // Deserializar la respuesta JSON a un objeto JwtResponse
                    val jwtResponse = gson.fromJson(responseBody, JwtResponse::class.java)

                    // Obtener el token de la respuesta
                    val token = jwtResponse.token

                    // Llamar al callback con el token
                    callback(token, null)
                } else {
                    // Manejar la respuesta no exitosa
                    callback(null, Exception("Error en la respuesta del servidor"))
                }
            }
        })
    }
}