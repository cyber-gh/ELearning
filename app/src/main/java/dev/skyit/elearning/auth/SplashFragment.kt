package dev.skyit.elearning.auth

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dev.skyit.elearning.R
import dev.skyit.elearning.student.cache.CacheManager
import dev.skyit.elearning.student.ui.generic.BaseFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import thinkit.redesign.ui.generic.ActivityDestination
import thinkit.redesign.ui.generic.navigate

class SplashFragment: BaseFragment(R.layout.fragment_splash){

    private val cache: CacheManager by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        lifecycleScope.launch {
            delay(1000)

            if (cache.loginToken.isNotEmpty()) {
                activity?.navigate(ActivityDestination.Student)
            } else {
                findNavController().navigate(R.id.action_fragment_splash_to_select_account_fragment)
            }
        }
    }
}