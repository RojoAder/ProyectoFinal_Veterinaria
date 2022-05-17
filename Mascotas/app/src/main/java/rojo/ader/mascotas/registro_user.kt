package rojo.ader.mascotas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import rojo.ader.mascotas.databinding.ActivityRegistroUserBinding

class registro_user : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityRegistroUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase Auth
        auth = Firebase.auth

        binding = ActivityRegistroUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var button: Button = findViewById(R.id.registrar)
        button.setOnClickListener {
        val usuario = Usuario(this)
            usuario.registar()
            }
        }

    }