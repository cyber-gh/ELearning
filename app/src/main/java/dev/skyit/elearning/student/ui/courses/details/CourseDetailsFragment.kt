package dev.skyit.elearning.student.ui.courses.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import dev.skyit.elearning.R
import dev.skyit.elearning.databinding.FragmentCourseDetailsBinding
import dev.skyit.elearning.student.ui.generic.BaseFragment
import java.lang.IllegalArgumentException

class CourseDetailsFragment: BaseFragment(R.layout.fragment_course_details) {

    private val binding: FragmentCourseDetailsBinding by viewBinding()

    private lateinit var adapter: CourseDetailsPagerAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = CourseDetailsPagerAdapter(childFragmentManager)
        binding.viewpager.adapter = adapter

        binding.tabLayout.setupWithViewPager(binding.viewpager)
    }
}


class CourseDetailsPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragments: List<Fragment> = listOf(
        InfoCourseFragment(),
        CourseReviewsFragment()
    )

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.count()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Info"
            1 -> "Reviews"
            else -> throw IllegalArgumentException("esti pula proasta")
        }
    }
}