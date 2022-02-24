package com.example.androidlocalization

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.androidlocalization.manager.LocaleManager
import java.util.*

class LanguageActivity : AppCompatActivity() {

    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)

        initViews()
    }

    private fun initViews() {

        context = this

        val b_english = findViewById<Button>(R.id.b_english)
        b_english.setOnClickListener {
            MyApplication.localeManager!!.setNewLocale(context, LocaleManager.LANGUAGE_ENGLISH)
            finish()
        }

        val b_russian = findViewById<Button>(R.id.b_russian)
        b_russian.setOnClickListener {
            MyApplication.localeManager!!.setNewLocale(context, LocaleManager.LANGUAGE_RUSSIAN)
            finish()
        }

        val b_uzbek = findViewById<Button>(R.id.b_uzbek)
        b_uzbek.setOnClickListener {
            MyApplication.localeManager!!.setNewLocale(context, LocaleManager.LANGUAGE_UZBEK)
            finish()
        }
    }

    private fun checkPlural() {
        val one = resources.getQuantityString(R.plurals.my_cats, 1, 1)
        val few = resources.getQuantityString(R.plurals.my_cats, 2, 3)
        val many = resources.getQuantityString(R.plurals.my_cats, 5, 10)

        Log.d("TAG", "checkPlural: \n$one \n $few \n $many")
    }
}