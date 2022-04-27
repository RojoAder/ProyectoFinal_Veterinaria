package rojo.ader.mascotas

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import rojo.ader.mascotas.databinding.ActivityMisMascotasBinding

class mis_mascotas : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMisMascotasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMisMascotasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var button:ImageView = findViewById(R.id.btnBack)
        button.setOnClickListener {
            val intent = Intent(this, menu::class.java)
            startActivity(intent)
        }

        var button2:ImageView = findViewById(R.id.btnAgregar)
        button2.setOnClickListener {
            val intent = Intent(this, registro::class.java)
            startActivity(intent)
        }
    }



}