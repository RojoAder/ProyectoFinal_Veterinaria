package rojo.ader.mascotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }
    var button:Button = findViewById(R.id.btnForo)
    button.setOnClickListener {
        val intent = Intent(this@MainActivity, foroMenu::class.java)
        startActivity(intent)
    }
    var button:Button = findViewById(R.id.btnCalendario)
    button.setOnClickListener {
        val intent = Intent(this@MainActivity, foroMenu::class.java)
        startActivity(intent)
    }
    var button:Button = findViewById(R.id.btnEntrenamiento)
    button.setOnClickListener {
        val intent = Intent(this@MainActivity, entrenamiento_menu::class.java)
        startActivity(intent)
    }
    var button:Button = findViewById(R.id.btnCompras)
    button.setOnClickListener {
        val intent = Intent(this@MainActivity, entrenamiento_menu::class.java)
        startActivity(intent)
    }
    var button:Button = findViewById(R.id.btnMisMascotas)
    button.setOnClickListener {
        val intent = Intent(this@MainActivity, mis_mascotas::class.java)
        startActivity(intent)
    }
    var button:Button = findViewById(R.id.btnEmergencias)
    button.setOnClickListener {
        val intent = Intent(this@MainActivity, mis_mascotas::class.java)
        startActivity(intent)
    }
}