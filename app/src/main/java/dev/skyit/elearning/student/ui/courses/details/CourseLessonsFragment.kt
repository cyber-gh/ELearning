package dev.skyit.elearning.student.ui.courses.details

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dev.skyit.elearning.R
import dev.skyit.elearning.databinding.FragmentCourseLessonListBinding
import dev.skyit.elearning.databinding.LessonListItemViewBinding
import dev.skyit.elearning.student.repo.LessonModel
import dev.skyit.elearning.student.ui.generic.BaseFragment
import dev.skyit.elearning.utility.SimpleRecyclerAdapter
import dev.skyit.elearning.utility.setItemSpacing
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CourseLessonsFragment(
        private val courseId: String = ""
): BaseFragment(R.layout.fragment_course_lesson_list) {
    private val binding: FragmentCourseLessonListBinding by viewBinding()
    private val vModel: CourseLessonsViewModel by viewModel {
        parametersOf(courseId)
    }

    private lateinit var adapter: SimpleRecyclerAdapter<LessonModel, LessonListItemViewBinding>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SimpleRecyclerAdapter(
            binderCreator = {
                LessonListItemViewBinding.inflate(it)
            }, injectData = {data ->
                this.lessonName.text = data.name
            }
        )

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.recyclerView.setItemSpacing()

        vModel.lessons.observe(viewLifecycleOwner, Observer {
            adapter.updateData(ArrayList(it))
        })


    }

    override fun onResume() {
        super.onResume()

        vModel.loadData()
    }
}