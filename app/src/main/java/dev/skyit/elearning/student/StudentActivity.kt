package dev.skyit.elearning.student

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dev.skyit.elearning.R
import dev.skyit.elearning.student.repo.TelemtryClient

class StudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        TelemtryClient().log()

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home,
            R.id.navigation_explore,
            R.id.navigation_notifications,
            R.id.navigation_profile
        ))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.search_courses_minimal) {
                supportActionBar?.hide()
                navView.isVisible = false
            } else {
                supportActionBar?.show()

                navView.isVisible = true
            }
        }
    }

    fun enterFullScreen() {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        supportActionBar?.hide()
        navView.isVisible = false

    }

    fun exitFullScreen() {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        supportActionBar?.show()
        navView.isVisible = true
    }


}