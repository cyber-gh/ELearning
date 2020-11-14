package dev.skyit.elearning.student.ui.notifications

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.api.load
import com.google.android.material.chip.Chip
import com.soywiz.klock.DateTime
import dev.skyit.elearning.R
import dev.skyit.elearning.databinding.CourseListItemViewBinding
import dev.skyit.elearning.databinding.FragmentNotificationsBinding
import dev.skyit.elearning.databinding.NotificationsListItemViewBinding
import dev.skyit.elearning.student.repo.CategoryModel
import dev.skyit.elearning.student.repo.NotificationModel
import dev.skyit.elearning.student.ui.generic.BaseFragment
import dev.skyit.elearning.utility.SimpleRecyclerAdapter
import dev.skyit.elearning.utility.setItemSpacing
import org.koin.androidx.viewmodel.ext.android.viewModel

class NotificationsFragment : BaseFragment(R.layout.fragment_notifications) {

    private val vModel: NotificationsViewModel by viewModel()
    private val binding: FragmentNotificationsBinding by viewBinding()

    private lateinit var notificationAdapter: SimpleRecyclerAdapter<NotificationModel, NotificationsListItemViewBinding>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindUI()
    }

    private fun bindUI() {
        bindNotificationList()
        vModel.loadData()
    }

    private fun bindNotificationList() {
        notificationAdapter = SimpleRecyclerAdapter(
            binderCreator = {
                NotificationsListItemViewBinding.inflate(it)
            }, injectData = { data ->

                this.notifMessage.text = data.message

                val date = data.createdAt
                this.notifDate.text = date.date.toString()
                this.notifTime.text = date.time.toString()
            }
        )
        binding.recyclerView.adapter = notificationAdapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.recyclerView.setItemSpacing()

        vModel.notificationsLive.observe(viewLifecycleOwner, Observer {
            notificationAdapter.updateData(ArrayList(it))
        })


    }





//
//    override fun onCreateView(
//            inflater: LayoutInflater,
//            container: ViewGroup?,
//            savedInstanceState: Bundle?
//    ): View? {
//        notificationsViewModel =
//                ViewModelProvider(this).get(NotificationsViewModel::class.java)
//        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
//        val textView: TextView = root.findViewById(R.id.text_notifications)
//        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
//        return root
//    }
}