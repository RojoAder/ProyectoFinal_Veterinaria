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
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize Firebase Auth
        auth = Firebase.auth

        val et_usuario : EditText = findViewById(R.id.usuario)
        val et_contra : EditText = findViewById(R.id.contrasenia)
        val btn_login : Button = findViewById(R.id.login)

        var button: Button = findViewById(R.id.login)
        button.setOnClickListener {
            //iniciar sesion
            var usuario : String = et_usuario.text.toString().trim()
            var contra: String = et_contra.text.toString().trim()

            //empty fields
            if (usuario.isNullOrEmpty() || contra.isNullOrEmpty()){
                Toast.makeText(this, "Todos los campos necesitan estar llenos para continuar", Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(usuario, contra)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success")
                            val user = auth.currentUser
                            //updateUI(user)
                            startActivity(Intent(this, menu:: class.java))
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("login", "signInWithEmail:failure", task.exception)
                            Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                            //updateUI(null)
                        }
                    }
            }

        val recuperar:Button = findViewById(R.id.forgot)
            recuperar.setOnClickListener {
                val intent = Intent(this,Recuperar::class.java)
                startActivity(intent)
            }

        }

        var button2:Button = findViewById(R.id.registrar)
        button2.setOnClickListener {
            val intent = Intent(this, registro_user::class.java)
            startActivity(intent)
        }


    }
}