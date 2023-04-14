package com.example.taxcalculator

import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.DialogFragment

//class InfoDialogFragment : DialogFragment(R.layout.fragment_dialog) {
    // TODO: add code to handle the UI controls
//}
class InfoDialogFragment : DialogFragment(R.layout.fragment_dialog) {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val okButton: Button = requireView().findViewById(R.id.buttonOk) ;
        okButton.setOnClickListener { dismiss() }
    }
}