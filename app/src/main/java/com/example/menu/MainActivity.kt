package com.example.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.isVisible
import com.example.menu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var IsLogin = true
    lateinit var LinkXML: ActivityMainBinding // to initializes LinkXML in future time

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LinkXML = ActivityMainBinding.inflate(layoutInflater)  // initializes the binding object
        setContentView(LinkXML.root) // get root of XML
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.login -> {
                return true
            }
            R.id.logout -> {
                return true
            }
            R.id.ContactUs -> {
                //change avt
                return true
            }

            R.id.Setting -> {
                 /**
                  * open next page
                  */
                val intent = Intent(this, SettingPage::class.java )
                intent.putExtra("HH", item.title )
                this.startActivity(intent)
                return true

            }
            else -> return super.onOptionsItemSelected(item)


        } // end when

    } // end function


    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        var login = menu?.findItem(R.id.login)
        var logout = menu?.findItem(R.id.logout)
        
        if(IsLogin){
            IsLogin=!IsLogin
            login?.setVisible(true)
            logout?.setVisible(false)
        } else {
            IsLogin=!IsLogin
            login?.setVisible(false)
            logout?.setVisible(true)
        }

        return super.onPrepareOptionsMenu(menu)
    }
}