package com.project.farmingapp.view.changelanguage

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.project.farmingapp.R
import java.util.Locale

class changelanguage : AppCompatActivity() {
    lateinit var mBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLocate() // call LoadLocate
        setContentView(R.layout.activity_main)
    }

    private fun loadLocate() {
        TODO("Not yet implemented")
        mBtn = findViewById(R.id.mChangeLang)

        mBtn.setOnClickListener{
            showChangeLang()
        }
    }

    private fun showChangeLang() {
        val listItmes = arrayOf("हिंदी")
        val mBuilder = AlertDialog.Builder(this@changelanguage)
        mBuilder.setTitle("Choose Language")
        mBuilder.setSingleChoiceItems(listItmes, -1) { dialog, which ->
            if (which == 0) {
                setLocate("hi")
                recreate()
            }

            dialog.dismiss()
        }
        val mDialog = mBuilder.create()

//        mDialog.show()
    }

    private fun setLocate(lang : String) {
        val locale = Locale(lang)
        Locale.setDefault(locale)

        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
//        editor.putString("My_Lang", lang)
//        editor.apply()
    }

}

