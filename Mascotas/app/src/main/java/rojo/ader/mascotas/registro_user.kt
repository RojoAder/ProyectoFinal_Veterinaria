package rojo.ader.mascotas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import rojo.ader.mascotas.databinding.ActivityRegistroUserBinding

class registro_user : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityRegistroUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistroUserBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var button: Button = findViewById(R.id.registrar)
        button.setOnClickListener {
            val intent = Intent(this, registro::class.java)
            startActivity(intent)
        }
    }



}