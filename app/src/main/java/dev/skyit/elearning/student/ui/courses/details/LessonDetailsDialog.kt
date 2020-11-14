package dev.skyit.elearning.student.ui.courses.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import dev.skyit.elearning.R
import dev.skyit.elearning.databinding.DialogLoadingBinding
import dev.skyit.elearning.databinding.LessonMaterialsFragmentBinding
import dev.skyit.elearning.student.ui.generic.BaseBottomSheetDialogFragment
import dev.skyit.elearning.utility.snack
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import thinkit.redesign.ui.generic.loading.Loadable

class LessonDetailsDialog: BaseBottomSheetDialogFragment(R.layout.lesson_materials_fragment) {
    private val binding: LessonMaterialsFragmentBinding by viewBinding()

    private lateinit var links: List<String>

    private lateinit var manager: LoadingDialogManager

    private lateinit var onDone: () -> Unit

    companion object {
        fun show(fragmentManager: FragmentManager, links: List<String>, onDone: () -> Unit) {
            val dialog = LessonDetailsDialog()
            dialog.links = links
            dialog.onDone = onDone
            dialog.show(fragmentManager, "None")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        manager = LoadingDialogManager(childFragmentManager)

        binding.textView.setOnClickListener {
            followLink(links.first())
        }

        binding.textView25.setOnClickListener {
            followLink(links.last())
        }

        binding.uploadBtn.setOnClickListener {
            MaterialDialog(requireContext())
                    .title(R.string.link_video)
                    .input { materialDialog, charSequence ->

                    }.negativeButton(text = "Cancel")
                    .positiveButton {
                        it.dismiss()

                        manager.showLoading()

                        lifecycleScope.launch {
                            delay(15000)
                            manager.hideLoading()
                            dismiss()

                            snack("Video uploaded")
                        }
                    }.show()
        }
    }

    fun followLink(url: String){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        activity?.startActivity(intent)
    }
}

class LoadingDialogManager(
        private val fragmentManager: FragmentManager
): Loadable {

    private var dialog: DialogLoading? = null

    override fun showLoading() {
        if (dialog == null) {
            dialog = DialogLoading()

            dialog?.show(fragmentManager, "Loading")
        }

    }

    override fun hideLoading() {
        dialog?.dismiss()
        dialog = null
    }
}


class DialogLoading: DialogFragment(){

    private val binding: DialogLoadingBinding by viewBinding()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_loading, container)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialog?.window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
        binding.loadingAnimation.playAnimation()
    }

}