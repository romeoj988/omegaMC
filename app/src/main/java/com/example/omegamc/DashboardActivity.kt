package com.example.omegamc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        
        loadFragment(HomeFragment())

        bottomNav.setOnItemSelectedListener {

            val selectedFragment: Fragment = when (it.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_convert -> ConvertFragment()
                R.id.nav_profile -> ProfileFragment()
                else -> HomeFragment()
            }

            loadFragment(selectedFragment)
            true
        }
    }

    
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }
}
