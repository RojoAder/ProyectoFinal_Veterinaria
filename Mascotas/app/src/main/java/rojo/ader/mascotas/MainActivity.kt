package rojo.ader.mascotas

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    constructor(context: Context){
        this.context = context
    }

    var button:Button = findViewById(R.id.btnInicio)
    button.setOnClickListener {
        val intent = Intent(this@MainActivity, Login::class.java)
        startActivity(intent)
    }

}