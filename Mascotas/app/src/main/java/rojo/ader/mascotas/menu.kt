package rojo.ader.mascotas

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.core.view.get
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

class menu : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val database = Firebase.database
    private lateinit var auth: FirebaseAuth
    val myRef = database.getReference("usuarios")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        auth = Firebase.auth
        val user = auth.currentUser

        val drawer:DrawerLayout = findViewById(R.id.drawer_layout)
        val menuButton:ImageView = findViewById(R.id.menuButton)

        val btnForo: ImageView  = findViewById(R.id.btnForo)
        val btnCalendario:ImageView = findViewById(R.id.btnCalendario)
        val btnEntrenamiento:ImageView = findViewById(R.id.btnEntrenamiento)
        val btnCompras:ImageView = findViewById(R.id.btnCompras)
        val btnMisMascotas:ImageView = findViewById(R.id.btnMisMascotas)
        val btnEmergencias:ImageView = findViewById(R.id.btnEmergencias)

        val navigationView:NavigationView = findViewById(R.id.nav_view)
        val headerView: View = navigationView.getHeaderView(0)
        val drawerView: Menu = navigationView.menu

        val calendarioMenu = drawerView[0]
        val foroTipsMenu = drawerView[1]
        val entrenamientoMenu = drawerView[2]
        val articulosMenu = drawerView[3]
        val misMascotasMenu = drawerView[4]
        val emergenciasMenu = drawerView[5]





        val nombreUsuario:TextView = headerView.findViewById(R.id.nombre)
        val correoUsuario:TextView = headerView.findViewById(R.id.email)

        myRef.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.getValue<Map<String,Map<String,String>>>()
                val map: Map<String, String>? = value?.get(user?.uid.toString())

                nombreUsuario.setText(map?.get("duenio").toString())
                correoUsuario.setText(map?.get("correo").toString())
                Log.d(TAG, map.toString())
                Log.d(TAG, "Value is: " + value)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }

        })



        btnForo.setOnClickListener {
            val intent = Intent(this, foroMenu::class.java)
            startActivity(intent)
        }

        btnCalendario.setOnClickListener {
            val intent = Intent(this, calendario::class.java)
            startActivity(intent)
        }


        btnEntrenamiento.setOnClickListener {
            val intent = Intent(this, entrenamiento_menu::class.java)
            startActivity(intent)
        }


        btnCompras.setOnClickListener {
            val intent = Intent(this, entrenamiento_menu::class.java)
            startActivity(intent)
        }


        btnMisMascotas.setOnClickListener {
            val intent = Intent(this, mis_mascotas::class.java)
            startActivity(intent)
        }


        btnEmergencias.setOnClickListener {
            val intent = Intent(this, mis_mascotas::class.java)
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
    }


}