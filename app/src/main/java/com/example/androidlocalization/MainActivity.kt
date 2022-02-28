package com.example.androidlocalization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidlocalization.manager.LocaleManager
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//version handled
//version handled
        LocaleManager(this).setLocale(this)

        findViewById<MaterialButton>(R.id.btn_open_language).setOnClickListener {
            startActivity(Intent(this, LanguageActivity::class.java))
        }
    }
}