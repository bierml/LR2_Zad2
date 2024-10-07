package com.example.lr2_zad2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.DialogFragment
import kotlin.random.Random

class MyDialogFragment : DialogFragment() {}


class MainActivity2 : AppCompatActivity() {
    var counter: Int = 0;
    var common_counter: Int = 0;
    var x: Int = Random.nextInt(2,10);
    var y: Int = Random.nextInt(2,10);
    var flag: Boolean = false;
    var value: Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        val extras = intent.extras
        if (extras != null) {
            value = extras.getInt("key");
            x = value;
            //The key argument here must match that used in the other activity
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val leftnum: TextView = findViewById(R.id.textView2)
            val rightnum: TextView = findViewById(R.id.textView3)
            leftnum.text = x.toString();
            rightnum.text = y.toString();
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editTextName = findViewById<EditText>(R.id.editTextText2)
        val bottom_msg: TextView = findViewById(R.id.textView7)
        findViewById<Button>(R.id.button3)
            .setOnClickListener {
                if(common_counter++<20) {
                    val ans: Int? = (editTextName.text).toString().toIntOrNull();
                    if(ans==null)
                    {
                        bottom_msg.setTextColor(Color.parseColor("#ff0000"));
                        bottom_msg.text = "Wrong/blank input field!";
                    }
                    else
                    {
                        if(ans==x*y)
                        {
                            Toast.makeText(this, "Correct answer!", Toast.LENGTH_SHORT).show();
                            counter++;
                        }
                        else {
                            Toast.makeText(this, "Incorrect answer!", Toast.LENGTH_SHORT).show();
                        }
                        bottom_msg.text="";
                        if(value==0)
                            x = Random.nextInt(2,10);
                        else
                            x = value;
                        y = Random.nextInt(2,10);
                        val leftnum: TextView = findViewById(R.id.textView2)
                        val rightnum: TextView = findViewById(R.id.textView3)
                        leftnum.text = x.toString();
                        rightnum.text = y.toString();
                    }
                }
                else {
                    bottom_msg.setTextColor(Color.parseColor("#000000"));
                    bottom_msg.text = "Correct answers count:"+counter.toString();
                }
            }
        findViewById<Button>(R.id.button5)
            .setOnClickListener {
                //val intent = Intent(this,MainActivity::class.java)
                //startActivity(intent)
                finish();
            }
    }
}