package rojo.ader.mascotas

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class entrenamiento_menu : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val database = Firebase.database
    private lateinit var auth: FirebaseAuth
    val myRef = database.getReference("usuarios")
    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrenamiento_menu)
        auth = Firebase.auth
        val user = auth.currentUser

        drawer = findViewById(R.id.drawer_layout)
        val menuButton:ImageView = findViewById(R.id.menuButton)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        val headerView: View = navigationView.getHeaderView(0)
        navigationView.setNavigationItemSelectedListener(this)

        val nombreUsuario: TextView = headerView.findViewById(R.id.nombre)
        val correoUsuario: TextView = headerView.findViewById(R.id.email)

        myRef.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.getValue<Map<String,Map<String,String>>>()
                val map: Map<String, String>? = value?.get(user?.uid.toString())

                nombreUsuario.setText(map?.get("duenio").toString())
                correoUsuario.setText(map?.get("correo").toString())
                Log.d(ContentValues.TAG, map.toString())
                Log.d(ContentValues.TAG, "Value is: " + value)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }

        })

        var button:ImageView = findViewById(R.id.backEntrenamiento)
        button.setOnClickListener {
            val intent = Intent(this, menu::class.java)
            startActivity(intent)
        }

        var buttonPatita:Button = findViewById(R.id.btnPatita)
        buttonPatita.setOnClickListener {
            val intent = Intent(this, entrenamiento_individual::class.java)
            startActivity(intent)
        }

        var buttonSentarse:Button = findViewById(R.id.btnSentar)
        buttonSentarse.setOnClickListener {
            val intent = Intent(this, entrenamiento_individual::class.java)
            startActivity(intent)
        }

        var buttonPelota:Button = findViewById(R.id.btnPelota)
        buttonPelota.setOnClickListener {
            val intent = Intent(this, entrenamiento_individual::class.java)
            startActivity(intent)
        }
        menuButton.setOnClickListener {
            drawer.openDrawer(GravityCompat.START)
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.calendarioMenu -> startActivity(Intent(this,calendario::class.java))
            R.id.foroTipsMenu -> startActivity(Intent(this,foroMenu::class.java))
            R.id.entrenamientoMenu -> startActivity(Intent(this,entrenamiento_menu::class.java))
            R.id.articulosMenu -> startActivity(Intent(this,menu::class.java))
            R.id.misMascotasMenu -> startActivity(Intent(this,mis_mascotas::class.java))
            R.id.emergenciasMenu -> startActivity(Intent(this,calendario::class.java))
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }


}