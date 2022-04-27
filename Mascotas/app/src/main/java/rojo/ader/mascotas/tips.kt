package rojo.ader.mascotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class tips : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips)

        var button: ImageView = findViewById(R.id.btnBack)
        button.setOnClickListener {
            val intent: Intent = Intent(this, foroMenu::class.java)
            startActivity(intent)
        }
    }
}