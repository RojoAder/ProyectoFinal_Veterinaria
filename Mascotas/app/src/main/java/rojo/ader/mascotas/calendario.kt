package rojo.ader.mascotas

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
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

class calendario : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val database = Firebase.database
    private lateinit var auth: FirebaseAuth
    val myRef = database.getReference("usuarios")
    val myRef2 = database.getReference("citas")
    var citasL :ArrayList<Cita> = ArrayList()
    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)
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

        var context: Context = this

        myRef2.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //This method is called once with the initial value and again
                //whenever data at this location is updated.
                val value = snapshot.getValue<Map<String, Map<String, String>>>()
                val keys: Set<String>? = value?.keys

                var citasArray = ArrayList<Map<String, String>?>()
                var citasUsuario = ArrayList<Map<String, String>?>()

                if (keys != null) {
                    for (item in keys) {
                        citasArray.add(value.get(item))
                        if (citasArray[0]?.get("usuario").equals(user?.uid.toString())) {
                            citasUsuario.add((value[item]))
                            citasArray.clear()
                        }
                        citasArray.clear()
                    }
                }


                for (item in citasUsuario) {
                    var nombreEvento: String = item?.get("nombreEvento").toString()
                    Log.d(ContentValues.TAG, nombreEvento.toString())

                    var fechaS: String = item?.get("fecha").toString()
                    var cita1: Cita = Cita(fechaS,nombreEvento)
                    citasL.add(cita1)
                }

                var listView: ListView = findViewById(R.id.list_View)
                var adaptador = adaptadorCitas(context,citasL)
                listView.adapter = adaptador


                Log.d(ContentValues.TAG, citasUsuario.toString())
                Log.d(ContentValues.TAG, "Value is: " + value)
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }
        })

        var button: ImageView = findViewById(R.id.backCalendario)
        button.setOnClickListener {
            val intent = Intent(this, menu::class.java)
            startActivity(intent)
        }
        menuButton.setOnClickListener {
            drawer.openDrawer(GravityCompat.START)
        }

        val add:ImageView = findViewById(R.id.btnAgregar)
        add.setOnClickListener {
            startActivity(Intent(this,citasPicker::class.java))
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