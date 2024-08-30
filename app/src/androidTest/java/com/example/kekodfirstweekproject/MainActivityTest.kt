package com.example.kekodfirstweekproject

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.navigation.NavController
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import com.example.kekodfirstweekproject.R // Adjust package name if needed

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>
    private lateinit var navController: TestNavHostController

    @Before
    fun setup() {
        // Create a TestNavHostController
        navController= TestNavHostController(ApplicationProvider.getApplicationContext())

        // Launch the activity
        scenario = ActivityScenario.launch(MainActivity::class.java)

        // Set the graph on the TestNavHostController
        scenario.onActivity { activity ->
            navController.setGraph(R.navigation.nav_graph) // Replace with your actual navigation graph
            // Set the NavController on the activity (if needed)
            activity.navController = navController
        }
    }

    @Test
    fun testNavControllerInitialization() {
        scenario.onActivity { activity ->
            // Verify that the NavController is initialized
            assertNotNull(activity.navController)
        }
    }



    // Add more tests to verify other aspects of MainActivity,
    // such as navigation actions, fragment transactions, etc.
}