package com.example.omegamc

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import java.text.NumberFormat
import java.util.*

class ConvertFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val root = LinearLayout(requireContext())
        root.orientation = LinearLayout.VERTICAL
        root.gravity = Gravity.CENTER_HORIZONTAL
        root.setPadding(40, 160, 40, 40)

        val inputUsd = EditText(requireContext())
        inputUsd.hint = "Masukkan nominal USD"
        inputUsd.setPadding(20, 20, 20, 20)

        val convertButton = Button(requireContext())
        convertButton.text = "Convert"
        convertButton.setPadding(0, 20, 0, 20)

        val resultText = TextView(requireContext())
        resultText.textSize = 16f
        resultText.setPadding(0, 20, 0, 0)

        convertButton.setOnClickListener {

            val usdValue = inputUsd.text.toString().toDoubleOrNull()

            if (usdValue == null) {
                resultText.text = "Masukkan angka yang valid"
                return@setOnClickListener
            }

            if (usdValue > DataUser.saldoUSD) {
                resultText.text = "Saldo tidak cukup"
                return@setOnClickListener
            }

            val rupiah = usdValue * 17200
            DataUser.saldoUSD -= usdValue

            val formatter = NumberFormat.getInstance(Locale("in", "ID"))
            val hasil = formatter.format(rupiah)

            resultText.text = "Rp $hasil\nSisa saldo: ${DataUser.saldoUSD} USD"
        }

        root.addView(inputUsd)
        root.addView(convertButton)
        root.addView(resultText)

        return root
    }
}