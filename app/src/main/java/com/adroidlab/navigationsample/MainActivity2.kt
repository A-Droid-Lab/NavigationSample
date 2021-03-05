package com.adroidlab.navigationsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.adroidlab.navigationsample.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity2 : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        if(savedInstanceState == null){
            setUpBottomNavigationBar()
        }
        Log.d("onCreate","onCreate")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setUpBottomNavigationBar()
    }

    fun setUpBottomNavigationBar(){
        bottomNavigationView = findViewById(R.id.bottom_nav)

        val navGraphIds = listOf(R.navigation.navigation_home, R.navigation.navigation_dashboard, R.navigation.navigation_notifications)

        val controller = bottomNavigationView.setupWithNavController(navGraphIds, supportFragmentManager, R.id.nav_host_container, intent)

        controller.observe(this, Observer { navController->
            setupActionBarWithNavController(navController)
        })
        currentNavController = controller
    }

}