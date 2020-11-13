package dev.skyit.elearning.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dev.skyit.elearning.R
import dev.skyit.elearning.databinding.FragmentLoginBinding
import dev.skyit.elearning.student.ui.generic.BaseFragment
import dev.skyit.elearning.utility.LoadingResource
import dev.skyit.elearning.utility.errAlert
import dev.skyit.elearning.utility.snack
import dev.skyit.elearning.utility.txt
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : BaseFragment(R.layout.fragment_login) {


    private val vModel: LoginViewModel by viewModel()
    private val binding: FragmentLoginBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        vModel.state.observe(viewLifecycleOwner, Observer {
            if (it is LoadingResource.Success) {
                snack("Logged in success")
            }
            if (it is LoadingResource.Error) {
                errAlert(it.errorMessage)
            }
        })


        binding.button.setOnClickListener {

            val email = binding.loginLayout.editText!!.txt
            val pass = binding.passwordLayout.editText!!.txt

            vModel.login(email, pass)
        }
    }
}