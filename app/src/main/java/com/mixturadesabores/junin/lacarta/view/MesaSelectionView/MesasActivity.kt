package com.mixturadesabores.junin.lacarta.view.MesaSelectionView


import android.app.Activity
import android.app.ActionBar
import android.app.FragmentTransaction

import android.support.v4.view.ViewPager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import com.mixturadesabores.junin.lacarta.R
import com.mixturadesabores.junin.lacarta.view.MesaSelectionView.NivelesPagerAdapter

class MesasActivity : Activity(), ActionBar.TabListener {

    private var mNivelesPagerAdapter: NivelesPagerAdapter? = null
    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mesas)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mNivelesPagerAdapter = NivelesPagerAdapter(this, fragmentManager)

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container) as ViewPager
        mViewPager!!.adapter = mNivelesPagerAdapter

        // Set up the action bar.
        val actionBar = actionBar
        actionBar!!.navigationMode = ActionBar.NAVIGATION_MODE_TABS

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager!!.setOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                actionBar.setSelectedNavigationItem(position)
            }
        })

        // For each of the sections in the app, add a tab to the action bar.
        for (i in 0..mNivelesPagerAdapter!!.count - 1) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mNivelesPagerAdapter!!.getPageTitle(i))
                            .setTabListener(this))
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_mesas, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onTabSelected(tab: ActionBar.Tab, fragmentTransaction: FragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager!!.currentItem = tab.position
    }

    override fun onTabUnselected(tab: ActionBar.Tab, fragmentTransaction: FragmentTransaction) {}

    override fun onTabReselected(tab: ActionBar.Tab, fragmentTransaction: FragmentTransaction) {}
}
