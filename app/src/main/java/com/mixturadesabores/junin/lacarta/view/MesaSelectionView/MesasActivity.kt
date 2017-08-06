package com.mixturadesabores.junin.lacarta.view.MesaSelectionView

import android.support.v7.app.AppCompatActivity
import android.content.Context
import android.databinding.DataBindingUtil

import android.support.v4.view.ViewPager
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.Menu
import android.view.MenuItem
import com.mixturadesabores.junin.domain.entities.Nivel

import com.mixturadesabores.junin.lacarta.R
import com.mixturadesabores.junin.lacarta.databinding.ActivityMesasBinding
import com.mixturadesabores.junin.lacarta.viewmodel.LevelViewModel
import io.reactivex.observers.DisposableObserver
import kotlinx.android.synthetic.main.activity_mesas.*

class MesasActivity : AppCompatActivity() {

    private lateinit var activityMesasBinding: ActivityMesasBinding
    private lateinit var levelViewModel: LevelViewModel
    private lateinit var viewPager: ViewPager
    private lateinit var slidingTab: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMesasBinding = DataBindingUtil.setContentView(this, R.layout.activity_mesas)
        levelViewModel = LevelViewModel(this)
        activityMesasBinding.mainViewModel = levelViewModel

        levelViewModel.fetchLevelList(fetchLevelsConsumer(this))
        viewPager = activityMesasBinding.container
        slidingTab = activityMesasBinding.tabs
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

    private inner class fetchLevelsConsumer(val context: Context): DisposableObserver<List<Nivel>>() {
        override fun onNext(t: List<Nivel>) {
            val adapter = NivelesPagerAdapter(fragmentManager, t, context)
            viewPager.adapter = adapter
            slidingTab.setupWithViewPager(viewPager)
        }

        override fun onComplete() {

        }

        override fun onError(e: Throwable) {
            // TODO: implement show a message for the user
        }
    }

    override fun onDestroy() {
        levelViewModel.dispose()
        super.onDestroy()
    }
}
