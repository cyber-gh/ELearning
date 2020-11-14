package dev.skyit.elearning.student.ui.courses.details

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import by.kirich1409.viewbindingdelegate.viewBinding
import dev.skyit.elearning.R
import dev.skyit.elearning.databinding.FragmentCourseInfoBinding
import dev.skyit.elearning.student.ui.generic.BaseFragment

class InfoCourseFragment: BaseFragment(R.layout.fragment_course_info) {

    private val binding: FragmentCourseInfoBinding by viewBinding()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView17.setOnClickListener({
            changeInitiator()
        })
        binding.textView18.setOnClickListener({
            changeInitiator()
        })
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private fun changeInitiator() {
        val dialog = TeacherInfoDialog()
        dialog.show(childFragmentManager, "dialogTeacher")
    }
}