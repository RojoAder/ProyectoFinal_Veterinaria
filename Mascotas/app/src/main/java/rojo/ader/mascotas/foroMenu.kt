package rojo.ader.mascotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class foroMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foro_menu)

        var button: ImageView = findViewById(R.id.btnBack)
        button.setOnClickListener {
            val intent:Intent = Intent(this, menu::class.java)
            startActivity(intent)
        }
    }


}