package com.example.os_practical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class TextToSpeech_example : AppCompatActivity(), TextToSpeech.OnInitListener {
    var tts:TextToSpeech?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_to_speech)

        var ed =findViewById<EditText>(R.id.ed_tts)
        var btn = findViewById<Button>(R.id.btn_tts)
        tts=TextToSpeech(TextToSpeech_example@this,this)
        btn.setOnClickListener {
            val text_ed=ed.text.toString()
            tts!!.speak(text_ed,TextToSpeech.QUEUE_FLUSH,null,"")
            tts!!.setSpeechRate(0.4f)
        }
    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS)
        {
            val result=tts!!.setLanguage(Locale.US)
            if(result ==TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
            {
                Toast.makeText(this, "Lang not supported", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(tts!=null)
        {
            tts!!.stop()
            tts!!.shutdown()
        }
    }
}