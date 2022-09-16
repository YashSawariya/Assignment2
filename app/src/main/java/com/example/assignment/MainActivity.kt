package com.example.assignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.assignment.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var nav:BottomNavigationView
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportActionBar!!.hide()

        val navController = findNavController(R.id.nav_host)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.home, R.id.showcase, R.id.features,R.id.features,R.id.faq,R.id.pricing
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomnav.setupWithNavController(navController)

    }



}