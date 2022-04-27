package rojo.ader.mascotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var button:Button = findViewById(R.id.login)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, menu::class.java)
            startActivity(intent)
        }
        var button2:Button = findViewById(R.id.registrar)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, registro_user::class.java)
            startActivity(intent)
        }
    }
}