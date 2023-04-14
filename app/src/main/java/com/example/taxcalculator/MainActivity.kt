package com.example.taxcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calculateButton = findViewById<Button>(R.id.buttonCalculate)
        calculateButton.setOnClickListener { calculateTax() }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.tax_menu, menu)
       // return super.onCreateOptionsMenu(menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.info -> showAboutDialog()
            R.id.calc -> super.onOptionsItemSelected(item)
            R.id.extra -> Toast.makeText(this, "You found the secret", Toast.LENGTH_SHORT).show()
        }
        return true;
    }
    private fun calculateTax() {
        val billAmountEditText = findViewById<EditText>(R.id.editTextBillAmount)
        val taxPercentageRadioGroup = findViewById<RadioGroup>(R.id.radioGroupTaxPercentage)
        val taxAmountTextView = findViewById<TextView>(R.id.textViewTaxAmount)

        if (billAmountEditText != null && taxPercentageRadioGroup != null && taxAmountTextView != null) {
            val billAmount = billAmountEditText.text.toString().toDoubleOrNull() ?: 0.0
            val taxPercentage = when (taxPercentageRadioGroup.checkedRadioButtonId) {
                R.id.radioButtonTenPercent -> 0.1
                R.id.radioButtonFifteenPercent -> 0.15
                else -> 0.2
            }
            val taxAmount = billAmount * taxPercentage
            taxAmountTextView.text = taxAmount.toString()
        }
    }
    private fun showAboutDialog() {
        InfoDialogFragment().show(supportFragmentManager, "InfoDialogFragment")

    }
}

