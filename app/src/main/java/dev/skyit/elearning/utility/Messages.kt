package dev.skyit.elearning.utility

import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import dev.skyit.elearning.student.ui.generic.BaseFragment


fun View.snack(msg: String, length: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, msg, length)
            .show()
}

fun Context.errAlert(msg: String) {
    AlertDialog.Builder(this)
            .setTitle("Error")
            .setMessage(msg)
            .setPositiveButton("OK") { _: DialogInterface, i: Int -> }
            .show()
}

fun Context.infoAlert(msg: String) {
    AlertDialog.Builder(this)
            .setTitle("Message")
            .setMessage(msg)
            .setPositiveButton("OK") { _: DialogInterface, i: Int -> }
            .show()
}

fun Fragment.snack(msg: String, length: Int = Snackbar.LENGTH_SHORT) {
    requireView().snack(msg, length)
}

fun Fragment.errAlert(msg: String?) {
    requireContext().errAlert(msg ?: "Unknown error")
}

fun Fragment.infoAlert(msg: String) {
    requireContext().infoAlert(msg)
}

fun Context.toastl(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun Fragment.toastl(msg: String) {
    requireContext().toastl(msg)
}

fun <T> BaseFragment.handleState(loadingResource: LoadingResource<T>) {
    if (loadingResource is LoadingResource.Loading) {
        showLoading()
    } else {
        hideLoading()
    }
    when (loadingResource) {
        is LoadingResource.Error -> errAlert(loadingResource.errorMessage)
        is LoadingResource.Success -> snack(loadingResource.data.toString())
    }
}