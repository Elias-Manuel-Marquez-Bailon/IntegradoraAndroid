package com.example.integradora_android_4a.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
<<<<<<< HEAD
import com.example.integradora_android_4a.R
=======
import com.example.myroute.R
>>>>>>> d3b27e812d129f78167a39f1863b4cf3350aa528
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        emailField = findViewById(R.id.etEmail)
        passwordField = findViewById(R.id.etPassword)
        loginButton = findViewById(R.id.btnLogin)
        registerButton = findViewById(R.id.btnRegister)

        loginButton.setOnClickListener { loginUser() }
        registerButton.setOnClickListener { registerUser() }
    }

    private fun loginUser() {
        val email = emailField.text.toString()
        val password = passwordField.text.toString()

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Login Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
            }
<<<<<<< HEAD
        }
    }

    private fun registerUser() {
        val email = emailField.text.toString()
        val password = passwordField.text.toString()

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Registration Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
            }
=======
>>>>>>> d3b27e812d129f78167a39f1863b4cf3350aa528
        }
    }

    private fun registerUser() {
        val email = emailField.text.toString()
        val password = passwordField.text.toString()

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Registration Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
