package dev.skyit.elearning.student.ui.notifications

import androidx.lifecycle.MutableLiveData
import dev.skyit.elearning.student.repo.NotificationModel
import dev.skyit.elearning.student.repo.NotificationRepo
import dev.skyit.elearning.student.ui.generic.BaseViewModel

class NotificationsViewModel(
    private val notificationRepo: NotificationRepo
) : BaseViewModel() {

    val notificationsLive = MutableLiveData<List<NotificationModel>>()

    fun loadData() {
        notificationsLive.makeCall {
            notificationRepo.getNotifications()
        }
    }
}