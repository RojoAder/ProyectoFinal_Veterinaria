package rojo.ader.mascotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var button: Button = findViewById(R.id.login)
        button.setOnClickListener {
            val intent = Intent(this, menu::class.java)
            startActivity(intent)
        }

        var button2:Button = findViewById(R.id.registrar)
        button2.setOnClickListener {
            val intent = Intent(this, registro_user::class.java)
            startActivity(intent)
        }
    }
}