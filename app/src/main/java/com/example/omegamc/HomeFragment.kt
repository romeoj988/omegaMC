package com.example.omegamc

import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val root = LinearLayout(requireContext())
        root.orientation = LinearLayout.VERTICAL
        root.gravity = Gravity.CENTER_HORIZONTAL
        root.setPadding(40, 160, 40, 40)

        // judul
        val title = TextView(requireContext())
        title.text = "Dashboard"
        title.textSize = 21f
        title.setPadding(0, 0, 0, 20)

        // nama user
        val userText = TextView(requireContext())
        userText.text = "👤 ${DataUser.username}"
        userText.textSize = 17f
        userText.setPadding(0, 0, 0, 20)

        // saldo
        val saldoBox = TextView(requireContext())
        saldoBox.text = "Saldo USD: ${DataUser.saldoUSD}"
        saldoBox.textSize = 19f
        saldoBox.setTextColor(Color.WHITE)
        saldoBox.setBackgroundColor(Color.parseColor("#43A047"))
        saldoBox.setPadding(40, 30, 40, 30)

        root.addView(title)
        root.addView(userText)
        root.addView(saldoBox)

        return root
    }
}