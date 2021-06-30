package com.example.texttospeech

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.EditText
import androidx.annotation.RequiresApi
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    var tts:TextToSpeech?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tts= TextToSpeech(this, this)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun speak(v: View?){
        var e = findViewById<View>(R.id.txt) as EditText
        var txt = e.text.toString()
        tts!!.speak(txt,TextToSpeech.QUEUE_FLUSH,null,"")
    }

    override fun onInit(status: Int) {
        tts!!.setLanguage(Locale.ENGLISH)
    }
} 