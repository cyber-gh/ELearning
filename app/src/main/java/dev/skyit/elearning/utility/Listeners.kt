package dev.skyit.elearning.utility

import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.paging.PagedList

fun EditText.stickPrefix(prefix: String) {
    this.addTextChangedListener(afterTextChanged = {
        if (!it.toString().startsWith(prefix) && it?.isNotEmpty() == true) {
            this.setText(prefix + this.text)
            this.setSelection(this.length())

        }
    })
}

fun EditText.clearIfPresent(prefix: String = "", subString: String) {
    this.setOnFocusChangeListener { v, hasFocus ->
        if (hasFocus) {
            if (this.text.toString().replace(prefix, "").startsWith(subString)) {
                this.setText(this.text.toString().replace(subString, ""))
            }
        }
    }
}

fun <T>PagedList<T>.onChanged(action: () -> Unit) {
    this.addWeakCallback(null, object: PagedList.Callback() {
        override fun onChanged(position: Int, count: Int) {
            action()
        }

        override fun onInserted(position: Int, count: Int) {
            action()
        }

        override fun onRemoved(position: Int, count: Int) {
            action()
        }
    })
}