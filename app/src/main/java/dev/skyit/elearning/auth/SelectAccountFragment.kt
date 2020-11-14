package dev.skyit.elearning.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dev.skyit.elearning.R
import dev.skyit.elearning.databinding.FragmentSelectAccountBinding
import dev.skyit.elearning.student.ui.generic.BaseFragment

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SelectAccountFragment : BaseFragment(R.layout.fragment_select_account) {

    private val binding: FragmentSelectAccountBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.studentBtn.setOnClickListener {
            findNavController().navigate(R.id.action_select_account_fragment_to_fragment_login)
        }

        binding.teacherBtn.setOnClickListener {
            findNavController().navigate(R.id.action_select_account_fragment_to_fragment_login)
        }
    }


}