package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)

//        binding.buttonCalculate.setOnClickListener{
//              calculate()
//        }

    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_calculate){
            calculate()
        }

    }

    private fun isValid(str: String): Boolean = (str != "" && str.toFloat() != 0f)

    private fun calculate(){
        if (isValid(binding.editDistance.text.toString()) && isValid(binding.editPrice.text.toString()) && isValid(binding.editAutonomy.text.toString())) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy

//        val totalValueStr = "R$ ${"%.2f".format(totalValue)}"
//        Toast.makeText(this,totalValueStr,Toast.LENGTH_SHORT).show()

            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
        }else{
            Toast.makeText(this, R.string.validation_numbers,Toast.LENGTH_SHORT).show()
        }
    }


}