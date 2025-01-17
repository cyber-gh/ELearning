package dev.skyit.elearning.student.ui.generic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class BaseBottomSheetDialogFragment(@LayoutRes private val layoutId: Int): BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container)
    }
}