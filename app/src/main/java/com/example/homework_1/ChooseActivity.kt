package com.example.homework_1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class ChooseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)

        //v (跳轉到YT專輯清單)
        val imageAlbum = findViewById<ImageView>(R.id.imageAlbum)
        imageAlbum.setOnClickListener(){
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.youtube.com/playlist?list=PLhN7ssqfKxgpH4GXXZAldSXDMAYwhMWvt")
            startActivity(intent)
        }

        //v  (單選1)
        val lettresToHeaven = resources.getStringArray(R.array.lettresToHeaven)
        var position_1 = 0
        val buttonLettersToHeanen = findViewById<Button>(R.id.buttonLettersToHeanen)
        val textChoose1 = findViewById<TextView>(R.id.textChoose1)
        textChoose1.text = "你選的是：${lettresToHeaven[position_1]}(預設)"
        buttonLettersToHeanen.setOnClickListener(){
            AlertDialog.Builder(this)
                .setTitle("致天堂的信")
                .setSingleChoiceItems(lettresToHeaven, 0){
                        dialogInterface, i -> position_1 = i
                }
                .setPositiveButton("確定"){dialog, which ->
                    Toast.makeText(this, "你選的是 ${lettresToHeaven[position_1]}", Toast.LENGTH_LONG).show()
                    textChoose1.text = "你選的是：${lettresToHeaven[position_1]}"
                }.show()
        }

        //v  (單選2)
        val lettresFromHeaven = resources.getStringArray(R.array.lettresFromHeaven)
        var position_2 = 0
        val buttonlettresFromHeaven = findViewById<Button>(R.id.buttonlettresFromHeaven)
        val textChoose2 = findViewById<TextView>(R.id.textChoose2)
        textChoose2.text = "你選的是：${lettresFromHeaven[position_2]}(預設)"
        buttonlettresFromHeaven.setOnClickListener(){
            AlertDialog.Builder(this)
                .setTitle("天堂的回信")
                .setSingleChoiceItems(lettresFromHeaven, 0){
                        dialogInterface, i -> position_2 = i
                }
                .setPositiveButton("確定"){dialog, which ->
                    Toast.makeText(this, "你選的是 ${lettresFromHeaven[position_2]}", Toast.LENGTH_LONG).show()
                    textChoose2.text = "你選的是：${lettresFromHeaven[position_2]}"
                }.show()
        }

        //v  (回傳給1頁)
        val buttonOK = findViewById<Button>(R.id.buttonOK)
        buttonOK.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("key1", lettresToHeaven[position_1])
            intent.putExtra("key2", lettresFromHeaven[position_2])
            startActivity(intent)
        }

    }
}