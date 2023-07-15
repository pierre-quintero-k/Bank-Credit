package com.example.bankcredit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bankcredit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var saldo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnIngresar.setOnClickListener{
            var value = binding.ingresarEdit.text.toString()
            if(!value.isNullOrEmpty()){
                if(value.toInt() > 0){
                    saldo = value.toInt() + saldo
                }
            }
            binding.saldo.setText(saldo.toString())
        }

        binding.btnRetirar.setOnClickListener{
            var value = binding.retirarEdit.text.toString()
            if(!value.isNullOrEmpty()){
                if(value.toInt() < saldo){
                    saldo = saldo - value.toInt()
                } else {
                    Toast.makeText(this, "La Cantidad a retirar sobrepasa tu saldo", Toast.LENGTH_SHORT).show()
                }
            }
            binding.saldo.setText(saldo.toString())
        }

        binding.buttonSalir.setOnClickListener{
            finishAffinity()
        }
    }
}