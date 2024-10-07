package com.example.lr2_zad2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<Button>(R.id.button)
            .setOnClickListener {
                val intent = Intent(this,MainActivity2::class.java)
                startActivity(intent)
            }
        findViewById<Button>(R.id.button2)
            .setOnClickListener {
                val editTextName = findViewById<EditText>(R.id.editTextText)
                val chosen_num: Int? = (editTextName.text).toString().toIntOrNull();
                if(chosen_num != null && chosen_num in 2..9) {
                    val intent = Intent(this,MainActivity2::class.java)
                    intent.putExtra("key",chosen_num);
                    startActivity(intent)
                }
                else
                    Toast.makeText(this, "Wrong number value!", Toast.LENGTH_SHORT).show();
            }
    }
}