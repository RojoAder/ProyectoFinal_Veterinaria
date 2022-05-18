package rojo.ader.mascotas

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import rojo.ader.mascotas.databinding.ActivityRegistroBinding
import java.lang.Exception


class registro : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    val database = Firebase.database
    val myRef = database.getReference("mascotas")

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityRegistroBinding
    lateinit var  imagenPerfil:ImageView
    val PERM_IMG = 123
    val PICK_IMG = 234

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth

        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imagenPerfil = findViewById(R.id.imagenPerfil)



        imagenPerfil.setOnClickListener {
            if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                seleccionar_imagen()
            }else{
                requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),PERM_IMG)
            }
        }


        var button: Button = findViewById(R.id.registrar)
        button.setOnClickListener {
            val mascota:EditText = findViewById(R.id.mascota)
            val raza:EditText = findViewById(R.id.raza)
            val edad:EditText = findViewById(R.id.edad)

            val mascotaS: String = mascota.text.toString().trim()
            val razaS: String = raza.text.toString().trim()
            val edadS: String = edad.text.toString().trim()
            Log.d(ContentValues.TAG,mascotaS)
            val user = auth.currentUser

            myRef.child(mascotaS).child("usuario").setValue(user?.uid.toString())
            myRef.child(mascotaS).child("raza").setValue(razaS)
            myRef.child(mascotaS).child("edad").setValue(edadS)
            myRef.child(mascotaS).child("nombre").setValue(mascotaS)
            val intent = Intent(this, mis_mascotas::class.java)
            startActivity(intent)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            PERM_IMG -> {
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    seleccionar_imagen()
                }else{
                    Toast.makeText(this,"no acepto Permisos",Toast.LENGTH_SHORT).show()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun seleccionar_imagen() {
        val intent_imgs = Intent(Intent.ACTION_PICK)
        intent_imgs.type = "image/*"
        startActivityForResult(intent_imgs,PICK_IMG)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == PICK_IMG){
            try{
                val img_uri = data?.data
                val img_stream = contentResolver.openInputStream(img_uri!!)

            }catch (e:Exception){
                e.printStackTrace()
                Toast.makeText(this,"Algo falló",Toast.LENGTH_SHORT).show()
            }
        }
    }


}