package rojo.ader.mascotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.ClickableSpan
import android.util.Log
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var button: Button = findViewById(R.id.login)
        button.setOnClickListener {
            val usuario: Usuario = Usuario(this)
            usuario.login()
        }

        val button3:Button = findViewById(R.id.forgot)
            button3.setOnClickListener {
                val intent = Intent(this, Recuperar::class.java)
                startActivity(intent)
            }

        var button2:Button = findViewById(R.id.registrar)
        button2.setOnClickListener {
            val intent = Intent(this, registro_user::class.java)
            startActivity(intent)
        }

        }




    }
