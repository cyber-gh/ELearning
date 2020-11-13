package dev.skyit.elearning.student.ui.dashboard

import android.os.Bundle
import android.view.View
import dev.skyit.elearning.R
import dev.skyit.elearning.student.ui.generic.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExploreFragment : BaseFragment(R.layout.fragment_explore) {

    private val vModel: DashboardViewModel by viewModel()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindUI()
    }

    private fun bindUI() {


    }
}