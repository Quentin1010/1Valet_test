package com.qbeuvelet.onevalet_test

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread
import com.qbeuvelet.onevalet_test.ui.device.DeviceRecyclerViewAdapter
import com.qbeuvelet.onevalet_test.ui.home.HomeFragment
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    @Test
    fun testNavigationToInGameScreen() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        runOnUiThread{
            navController.setGraph(R.navigation.mobile_navigation)
        }

        launchFragmentInContainer {
            HomeFragment().also { fragment ->
                fragment.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                    if (viewLifecycleOwner != null) {
                        Navigation.setViewNavController(fragment.requireView(), navController)
                    }
                }
            }
        }

        onView(ViewMatchers.withId(R.id.recyclerview_home)).perform(RecyclerViewActions.actionOnItemAtPosition<DeviceRecyclerViewAdapter.DeviceViewHolder>(0, click()))
        Assert.assertEquals(navController.currentDestination?.id, R.id.nav_detail_device)
    }

}