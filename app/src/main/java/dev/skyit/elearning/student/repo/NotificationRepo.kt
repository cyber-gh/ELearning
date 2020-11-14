package dev.skyit.elearning.student.repo

import com.soywiz.klock.DateTime

data class NotificationModel(val message: String,
                             val createdAt: DateTime)

interface NotificationRepo {
    suspend fun getNotifications() : List<NotificationModel>
}

class NotificationRepoImlp: NotificationRepo {
    override suspend fun getNotifications() : List<NotificationModel> {
        return listOf(
            NotificationModel("Ai primit notificare", DateTime.now()),
            NotificationModel("Ai primit notificare", DateTime.now()),
            NotificationModel("Ai primit notificare", DateTime.now()),
            NotificationModel("Ai primit notificare", DateTime.now()),
            NotificationModel("Ai primit notificare", DateTime.now()),
        )
    }
}