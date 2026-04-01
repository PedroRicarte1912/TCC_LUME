package com.univap.lume.activity
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.univap.lume.R


class ActivityTesteSensorial:AppCompatActivity()  {
    private lateinit var txt_mensagem3: TextView
    private lateinit var txt_mensagem5: TextView
    private lateinit var btn_audio1: Button
    private lateinit var btn_audio2: Button
    private lateinit var btn_audio3: Button
    private lateinit var btn_selecao: Button

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testesensorial)
        txt_mensagem5=findViewById<TextView>(R.id.txt_mensagem5)
        txt_mensagem3=findViewById<TextView>(R.id.txt_mensagem3)
        btn_selecao=findViewById<Button>(R.id.btn_selecao)
        btn_audio1=findViewById<Button>(R.id.btn_audio1)
        btn_audio2=findViewById<Button>(R.id.btn_audio2)
        btn_audio3=findViewById<Button>(R.id.btn_audio3)
        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.audio1)
        val mp2: MediaPlayer= MediaPlayer.create(this,R.raw.audio2)
        val mp3: MediaPlayer= MediaPlayer.create(this,R.raw.audio3)
        var i=0
        var audio_selecionado=mp
        btn_audio1.setOnClickListener {
            if(mp.isPlaying){
                mp.stop()
                mp.prepare()
            }
            mp.start()
            i=1
        }
        btn_audio2.setOnClickListener {
            if(mp2.isPlaying){
                mp2.stop()
                mp2.prepare()
            }
            mp2.start()
            i=2
        }
        btn_audio3.setOnClickListener {
            if(mp3.isPlaying){
                mp3.stop()
                mp3.prepare()
            }
            mp3.start()
            i=3
        }
        btn_selecao.setOnClickListener {
            if(i==1){
                 audio_selecionado=mp
            }
            if(i==2){
                audio_selecionado=mp2

            }
            if(i==3){
                audio_selecionado=mp3
            }
        }
    }
}
