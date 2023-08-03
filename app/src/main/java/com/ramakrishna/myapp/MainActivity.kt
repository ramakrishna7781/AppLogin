package com.ramakrishna.myapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var titleName: String? = "Persons"
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences((getString(R.string.preference_file_name)),Context.MODE_PRIVATE)
        setContentView(R.layout.scrl_vw)

        titleName = sharedPreferences.getString("Title","Persons")
        title = titleName
    }
}