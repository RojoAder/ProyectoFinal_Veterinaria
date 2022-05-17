package rojo.ader.mascotas

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Usuario {
    private lateinit var auth:FirebaseAuth
    lateinit var activity:Activity
    val database = Firebase.database
    val myRef = database.getReference("usuarios")

    constructor(activity: Activity){
        this.activity = activity

        auth = Firebase.auth
    }

    fun registar(){
        val duenio:EditText = activity.findViewById(R.id.duenio)
        val contrasenia:EditText = activity.findViewById(R.id.contrasenia)
        val email:EditText = activity.findViewById(R.id.email)
        val usuario:EditText = activity.findViewById(R.id.usuario)

        var duenioS:String = duenio.text.toString().trim()
        val contraseniaS:String = contrasenia.text.toString().trim()
        val emailS:String = email.text.toString().trim()
        val usuarioS:String = usuario.text.toString().trim()

        if (usuarioS.isEmpty() || contraseniaS.isEmpty()){
            Toast.makeText(activity, "Todos los campos necesitan estar llenos para continuar", Toast.LENGTH_SHORT).show()
        }else{
            auth.createUserWithEmailAndPassword(emailS, contraseniaS)
                .addOnCompleteListener(activity) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser

                        myRef.child(user?.uid.toString()).child("correo").setValue(emailS)
                        myRef.child(user?.uid.toString()).child("duenio").setValue(duenioS)
                        myRef.child(user?.uid.toString()).child("usuario").setValue(usuarioS)


                        activity.startActivity(Intent(activity, MainActivity:: class.java))
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("registro", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(activity, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        //updateUI(null)
                    }
                }
        }
    }

    fun login(){
        val correo:EditText = activity.findViewById(R.id.correo)
        val contrasenia:EditText = activity.findViewById(R.id.contrasenia)

        var correoS:String = correo.text.toString().trim()
        var contraseniaS:String = contrasenia.text.toString().trim()

        if (correoS.isNullOrEmpty() || contraseniaS.isNullOrEmpty()){
            Toast.makeText(activity, "Todos los campos necesitan estar llenos para continuar", Toast.LENGTH_SHORT).show()
        }else{
            auth.signInWithEmailAndPassword(correoS, contraseniaS)
                .addOnCompleteListener(activity) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        //Log.d(TAG, "signInWithEmail:success")
                        val user = auth.currentUser
                        //updateUI(user)
                        activity.startActivity(Intent(activity, menu:: class.java))
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("login", "signInWithEmail:failure", task.exception)
                        Toast.makeText(activity, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        //updateUI(null)
                    }
                }
        }
    }
}