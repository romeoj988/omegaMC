package com.example.omegamc

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        
        val root = LinearLayout(requireContext())
        root.orientation = LinearLayout.VERTICAL
        root.gravity = Gravity.CENTER_HORIZONTAL
        root.setPadding(40, 160, 40, 40)

        val userText = TextView(requireContext())
        userText.text = "👤 ${DataUser.username}"
        userText.textSize = 18f
        userText.setPadding(0, 0, 0, 30)

        val logoutButton = Button(requireContext())
        logoutButton.text = "Logout"

        logoutButton.setOnClickListener {
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            activity?.finish()
        }

        root.addView(userText)
        root.addView(logoutButton)

        return root
    }
}
