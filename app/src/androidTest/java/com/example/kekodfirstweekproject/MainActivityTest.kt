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
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.isNotChecked
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import com.example.kekodfirstweekproject.R // Adjust package name if needed
import org.hamcrest.CoreMatchers.not

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

    @Test
    fun testBottomNavigationViewIsNotDisplayed() {
        // Verify that the BottomNavigationView is not displayed
        onView(withId(R.id.bottom_nav_view)).check(matches(not(isDisplayed())))
    }

    @Test
    fun testBottomNavigationViewIsDisplayed() {
        onView(withId(R.id.switchEgo)).perform(click())

        onView(withId(R.id.bottom_nav_view)).check(matches(isDisplayed()))

    }

    @Test
    fun testDefaultSwitchStates() {
        onView(withId(R.id.switchGiving)).check(matches(isNotChecked()))
        onView(withId(R.id.switchKindness)).check(matches(isNotChecked()))
        onView(withId(R.id.switchOptimism)).check(matches(isNotChecked()))
        onView(withId(R.id.switchRespect)).check(matches(isNotChecked()))
        onView(withId(R.id.switchHappiness)).check(matches(isNotChecked()))
        onView(withId(R.id.switchEgo)).check(matches(isChecked()))
    }



    // Add more tests to verify other aspects of MainActivity,
    // such as navigation actions, fragment transactions, etc.
}