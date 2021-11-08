package com.example.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private var logIn_logOut = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }




    /**
     * Initializes the [Menu] to be used with the current [Activity]
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu?.findItem(R.id.login)
        // Calls code to set the icon based on the LinearLayoutManager of the RecyclerView
        setIcon(layoutButton)
        return true
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.title = if (logIn_logOut) "login" else "logout"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.login -> {
                item.title = "logout"
            }

            R.id.logout -> {
                item.title = "login"
            }

            R.id.ContactUs -> {
                //change avt
                }

            R.id.Setting -> {
                //change avt
            }

            else -> super.onOptionsItemSelected(item)
        } // end when
        return true
        setIcon(item)
    } // end function
}