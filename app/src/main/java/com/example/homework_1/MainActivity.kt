package com.example.homework_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //v (跳轉到第2頁)
        val button = findViewById<Button>(R.id.buttonGO)
        button.setOnClickListener{
            startActivity(Intent(this,ChooseActivity::class.java))
        }

        //v  (接收第2頁的東西)
        val textReturn0 = findViewById<TextView>(R.id.textReturn0)
        intent?.extras?.let {
            val value_1 = it.getString("key1")
            val textReturn1 = findViewById<TextView>(R.id.textReturn1)
            textReturn1.text = "致天堂的信：${value_1.toString()}"
            val value_2 = it.getString("key2")
            val textReturn2 = findViewById<TextView>(R.id.textReturn2)
            textReturn2.text = "天堂的回信：${value_2.toString()}"

            textReturn0.text = "你選擇的是"
        }

    }
}