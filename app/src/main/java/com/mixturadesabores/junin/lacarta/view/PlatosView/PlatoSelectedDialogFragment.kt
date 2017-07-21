package com.mixturadesabores.junin.lacarta.view.PlatosView

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mixturadesabores.junin.lacarta.R

/**
 * Created by enzo on 18/07/17.
 */
class PlatoSelectedDialogFragment : DialogFragment() {

    var platoName = ""

    companion object {

        fun newInstance(title: String): PlatoSelectedDialogFragment {
            val f = PlatoSelectedDialogFragment()
            val args = Bundle()
            args.putString("title", title)
            f.arguments = args
            return f
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title = arguments.getString("title")

        val builder = AlertDialog.Builder(activity)
        val mInflater = activity.layoutInflater

        builder.setView(mInflater.inflate(R.layout.fragment_plato_selected_dialog, null))
                .setTitle(title)
                .setPositiveButton(R.string.alert_dialog_ok,
                        DialogInterface.OnClickListener { dialog, which -> Log.v("positive", "click on positive button") })
                .setNegativeButton(R.string.alert_dialog_cancel,
                        DialogInterface.OnClickListener { dialog, which -> Log.v("negative", "click on negative button") })

        return builder.create()
    }
}