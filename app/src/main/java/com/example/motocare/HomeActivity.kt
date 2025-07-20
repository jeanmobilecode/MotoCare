package com.example.motocare

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.motocare.databinding.ActivityHomeBinding
import com.example.motocare.fragments.FragmentGestures
import com.example.motocare.fragments.FragmentHome
import com.example.motocare.fragments.FragmentInfo
import com.example.motocare.fragments.FragmentTips
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupViews()
        toolBarBehavior()
        setDefaultFragment(savedInstanceState)
        setupNavigaion()

    }

    private fun setupNavigaion(){
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> replaceFragment(FragmentHome())
                R.id.nav_tips -> replaceFragment(FragmentTips())
                R.id.nav_gestures -> replaceFragment(FragmentGestures())
                R.id.nav_info -> replaceFragment(FragmentInfo())
            }

            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun setDefaultFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentHome())
                .commit()
            navView.setCheckedItem(R.id.nav_home)
        }
    }

    private fun toolBarBehavior(){
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Home"

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        toggle.drawerArrowDrawable.color = ContextCompat.getColor(this, R.color.bluenavy)

    }

    private fun setupViews(){
        drawerLayout = binding.drawerLayout
        navView = binding.navView
        toolbar = binding.toolbar

    }

    fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            )

            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null) // optional: so user can press "Back"
            .commit()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}