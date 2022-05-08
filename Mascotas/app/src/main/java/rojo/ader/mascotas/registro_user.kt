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

        val et_usuario : EditText = findViewById(R.id.email)
        val et_contra : EditText = findViewById(R.id.contrasenia)


        var button: Button = findViewById(R.id.registrar)
        button.setOnClickListener {
        //iniciar sesion
        var usuario : String = et_usuario.text.toString().trim()
        var contra: String = et_contra.text.toString().trim()

        //empty fields
        if (usuario.isNullOrEmpty() || contra.isNullOrEmpty()){
            Toast.makeText(this, "Todos los campos necesitan estar llenos para continuar", Toast.LENGTH_SHORT).show()
        }else{
            auth.createUserWithEmailAndPassword(usuario, contra)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        //Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser
                        //updateUI(user)
                        startActivity(Intent(this, MainActivity:: class.java))
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("registro", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        //updateUI(null)
                    }
                }
        }
        }


    }



}