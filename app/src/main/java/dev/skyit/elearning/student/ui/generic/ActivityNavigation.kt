package thinkit.redesign.ui.generic

import android.app.Activity
import android.content.Intent
import dev.skyit.elearning.auth.AuthActivity
import dev.skyit.elearning.student.StudentActivity

enum class ActivityDestination {
    AUTH, Student
}

fun ActivityDestination.toClass() : Class<*> {
    return when(this) {
        ActivityDestination.AUTH -> AuthActivity::class.java
        ActivityDestination.Student -> StudentActivity::class.java
    }
}

fun Activity.navigate(destination: ActivityDestination) {
    val intent = Intent(this, destination.toClass())

    startActivity(intent)
    this.finish()
    this.finishAffinity()
}