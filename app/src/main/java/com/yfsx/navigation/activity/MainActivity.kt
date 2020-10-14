package com.yfsx.navigation.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.yfsx.base.activity.BaseActivity
import com.yfsx.navigation.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: BaseActivity()  {

    lateinit var fragmentHost: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        fragmentHost = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        NavigationUI.setupWithNavController(botNavLayout, fragmentHost.findNavController())

        //to remove back button when setup bottom nav graph with toobar
        var appBarConfiguration = AppBarConfiguration(setOf(
                R.id.mainFragment1,
                R.id.mainFragment2,
                R.id.mainFragment3
            ), null
        )

        //setup toolbar with fragment name (need to be defined in graph)
        setupActionBarWithNavController(fragmentHost.findNavController(), appBarConfiguration)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return true
    }
}