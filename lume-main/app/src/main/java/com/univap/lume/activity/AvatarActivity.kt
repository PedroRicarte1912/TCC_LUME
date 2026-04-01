package com.univap.lume.activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.univap.lume.R

class AvatarActivity: AppCompatActivity() {
    private lateinit var txt_mensagem2: TextView
    private lateinit var avatar1: Button
    private lateinit var avatar2: Button
    private lateinit var avatar3: Button
    private lateinit var avatar4: Button
    private lateinit var avatar5: Button
    private lateinit var avatar6: Button
    private lateinit var btn_confirmar_avatar: Button

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avatar)
        txt_mensagem2=findViewById<TextView>(R.id.txt_mensagem2)
        avatar1=findViewById<Button>(R.id.avatar1)
        avatar2=findViewById<Button>(R.id.avatar2)
        avatar3=findViewById<Button>(R.id.avatar3)
        avatar4=findViewById<Button>(R.id.avatar4)
        avatar5=findViewById<Button>(R.id.avatar5)
        avatar6=findViewById<Button>(R.id.avatar6)
        btn_confirmar_avatar=findViewById<Button>(R.id.btn_confirmar_avatar)
    }
}