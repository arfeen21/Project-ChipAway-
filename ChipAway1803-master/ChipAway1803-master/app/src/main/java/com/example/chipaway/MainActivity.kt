package com.example.chipaway

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.chipaway.ui.home.introduction_home
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.introduction_home.*
import kotlinx.android.synthetic.main.product_info_page.*
import java.io.File
import java.io.PrintWriter


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val fileName = "FirstTimeOpened.txt"
        checkFirstTimeOpen(fileName)

        var result = readFileDirectlyAsText(fileName)

        if(result == "true"){
            // first time boot up
            super.onCreate(savedInstanceState)
            //Remove title bar
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);

            setContentView(R.layout.introduction_home)
            supportActionBar?.hide()

            val windowlp = window.attributes
            windowlp.gravity = Gravity.BOTTOM

            // go to next view
            btn_start.setOnClickListener{
                val intent = Intent(this, introduction_home::class.java)
                startActivity(intent)
            }
        } else {
            val intent = Intent(this, introduction_home::class.java)
            startActivity(intent)
        }

    }

    fun checkFirstTimeOpen(fileName: String) {
        var dir = filesDir
        var file = File(dir, fileName)


        var fileExists = file.exists()

        // if file already exist it means this isnt the first time it has booted up
        if(fileExists){
            val pw = PrintWriter(file)
            pw.write("false")
            pw.close()
        } else {
            file.createNewFile()

            val pw = PrintWriter(file)
            pw.write("true")
            pw.close()
        }

    }

    private fun readFileDirectlyAsText(fileName: String): String =
        File(filesDir, fileName).readText(Charsets.UTF_8)

}
