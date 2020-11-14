package dev.skyit.elearning.student.ui.generic

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import thinkit.redesign.ui.generic.loading.Loadable

open class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId), Loadable {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.fade)
    }

    override fun showLoading() {
        val parent = activity as? Loadable ?: return
        parent.showLoading()
    }

    override fun hideLoading() {

        val parent = activity as? Loadable ?: return
        parent.hideLoading()
    }
}

//data class MenuOption(@LayoutRes val layoutId: Int, val onClick: (Int) -> Unit)