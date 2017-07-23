package com.mixturadesabores.junin.lacarta.view.MesaSelectionView


import android.app.Activity
import android.app.ActionBar
import android.app.FragmentTransaction

import android.support.v4.view.ViewPager
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.mixturadesabores.junin.domain.entities.Nivel
import com.mixturadesabores.junin.domain.interactors.ObtenerNivelesUseCase

import com.mixturadesabores.junin.lacarta.R
import com.mixturadesabores.junin.lacarta.data.ApiNivelRepository
import com.mixturadesabores.junin.lacarta.view.MesaSelectionView.NivelesPagerAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MesasActivity : Activity(), ActionBar.TabListener {

    private var levelsPagerAdapter: NivelesPagerAdapter? = null
    private var viewPager: ViewPager? = null
    private var levels: List<Nivel>? = null
    private val apiNivelRepository by lazy { ApiNivelRepository() }
    private val obtenerNivelesUseCase by lazy { ObtenerNivelesUseCase(apiNivelRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mesas)

        val actionBar = actionBar
        actionBar!!.navigationMode = ActionBar.NAVIGATION_MODE_TABS

        val suscription = obtenerNivelesUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            levelsPagerAdapter = NivelesPagerAdapter(fragmentManager, it)
                            viewPager = findViewById(R.id.container) as ViewPager
                            viewPager!!.adapter = levelsPagerAdapter

                            viewPager!!.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
                                override fun onPageSelected(position: Int) {
                                    actionBar.setSelectedNavigationItem(position)
                                }
                            })

                            for (i in 0..levelsPagerAdapter!!.count - 1) {
                                actionBar.addTab(
                                        actionBar.newTab()
                                                .setText(levelsPagerAdapter!!.getPageTitle(i))
                                                .setTabListener(this)
                                )
                            }
                        },
                        {
                            Log.e("error con retrofit", it.message)
                        }
                )
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
        viewPager!!.currentItem = tab.position
    }

    override fun onTabUnselected(tab: ActionBar.Tab, fragmentTransaction: FragmentTransaction) {}

    override fun onTabReselected(tab: ActionBar.Tab, fragmentTransaction: FragmentTransaction) {}
}
