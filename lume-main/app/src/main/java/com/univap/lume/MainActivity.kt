package com.univap.lume
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.univap.lume.activity.AvatarActivity
import com.univap.lume.R
import com.univap.lume.activity.ActivityTesteSensorial

class MainActivity : AppCompatActivity() {
    private lateinit var txt_bemvindo: TextView
    private lateinit var txt_mensagem1: TextView
    private lateinit var btn_testesensorial: Button
    private lateinit var btn_testetea:Button
    private lateinit var btn_avatar2: Button
    private lateinit var btn_lichoes2: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        txt_bemvindo=findViewById<TextView>(R.id.txt_bemvindo)
        txt_mensagem1=findViewById<TextView>(R.id.txt_mensagem1)
        btn_testesensorial=findViewById<Button>(R.id.btn_testesensorial)
        btn_testetea=findViewById<Button>(R.id.btn_testetea)
        btn_avatar2=findViewById<Button>(R.id.btn_avatar2)
        btn_lichoes2=findViewById<Button>(R.id.btn_lichoes2)

        /*
        * Chamada da entrada do botão que leva à tela "activity_avatar.xml"
        * */
        btn_avatar2.setOnClickListener {
            val tela_avatar=Intent(this, AvatarActivity::class.java)
            startActivity(tela_avatar)
        }
        btn_testesensorial.setOnClickListener {
            val tela_testesensorial= Intent(this, ActivityTesteSensorial::class.java)
            startActivity(tela_testesensorial)
        }


    }
}

