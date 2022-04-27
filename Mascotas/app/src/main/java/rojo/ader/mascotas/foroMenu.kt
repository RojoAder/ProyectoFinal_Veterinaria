package rojo.ader.mascotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class foroMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foro_menu)
    }

    var button:Button = findViewById(R.id.btnBack)
    button.setOnClickListener {
        val intent = Intent(this@MainActivity, menu::class.java)
        startActivity(intent)
    }
}