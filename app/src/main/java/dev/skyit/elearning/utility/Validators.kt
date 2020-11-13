package dev.skyit.elearning.utility

import android.content.Context
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputLayout
import dev.skyit.elearning.R
import java.util.regex.Pattern


typealias Validator =  (String) -> Boolean

interface InputValidator {
    fun setError(msg: String?)
    val editableText: EditText

    val errorMsg: String
    val checker: (String) -> Boolean
}

class EditTextInputValidator (val editText: EditText, override val errorMsg: String, override val checker: (String) -> Boolean) :
    InputValidator {


    companion object {
        fun nonEmptyValidator(editText: EditText, context: Context): EditTextInputValidator {
            return EditTextInputValidator(editText, context.getString(R.string.not_empty_required)) {
                it.isNotBlank()
            }
        }

        fun atLeastNCharacters(editText: EditText, n: Int, context: Context): EditTextInputValidator {
            return EditTextInputValidator(
                    editText,
                    context.getString(R.string.min_length) + n.toString()
            ) {
                it.length >= n
            }
        }

        fun validEmail(editText: EditText, context: Context): EditTextInputValidator {
            return EditTextInputValidator(editText, context.getString(R.string.not_valid_email)) {
                isEmailValid(it)
            }
        }

        private fun isEmailValid(email: String): Boolean {
            return Pattern.compile(
                    "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                            + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                            + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                            + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
            ).matcher(email).matches()
        }
    }

    override fun setError(msg: String?) {
        editText.error = msg
    }

    override val editableText: EditText
        get() = editText
}

class TextInputLayoutValidator (val textInputLayout: TextInputLayout, override val errorMsg: String, override val checker: (String) -> Boolean) :
    InputValidator {


    companion object {
        fun nonEmptyValidator(editText: TextInputLayout, context: Context): TextInputLayoutValidator {
            return TextInputLayoutValidator(editText, context.getString(R.string.not_empty_required)) {
                it.isNotBlank()
            }
        }

        fun atLeastNCharacters(editText: TextInputLayout, n: Int, context: Context): TextInputLayoutValidator {
            return TextInputLayoutValidator(
                    editText,
                    context.getString(R.string.min_length) + n.toString()
            ) {
                it.length >= n
            }
        }

        fun validEmail(editText: TextInputLayout, context: Context): TextInputLayoutValidator {
            return TextInputLayoutValidator(editText, context.getString(R.string.not_valid_email)) {
                isEmailValid(it)
            }
        }

        fun shouldMatch(editText: TextInputLayout,target: TextInputLayout, context: Context): TextInputLayoutValidator {
            return TextInputLayoutValidator(editText, context.getString(R.string.dont_match_field)) {
                it == target.editText?.txt ?: ""
            }
        }

        private fun isEmailValid(email: String): Boolean {
            return Pattern.compile(
                    "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                            + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                            + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                            + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
            ).matcher(email).matches()
        }
    }

    override fun setError(msg: String?) {
        textInputLayout.error = msg
    }

    override val editableText: EditText
        get() = textInputLayout.editText!!
}



class InputValidatorManager {

    private val validators = mutableListOf<InputValidator>()

    private var wasTriggered = false

    fun addInputValidator(inValid: InputValidator) {
        validators.add(inValid)
        inValid.editableText?.addTextChangedListener {
            if (!wasTriggered || it == null) return@addTextChangedListener
            val str = it.toString().trim()
            val isGood = inValid.checker(str)
            if (!isGood) {
                inValid.setError(inValid.errorMsg)
            } else {
                inValid.setError(null)
            }
        }
    }

    fun runValidations(shouldAcitvate : Boolean = true) : Boolean {
        var isGood = true
        wasTriggered = shouldAcitvate
        validators.forEach {
            val str = it.editableText.text.toString().trim()
            val res = it.checker(str)
            if (!res) {
                isGood = false
                it.setError(it.errorMsg)
            } else {
                it.setError(null)
            }

        }
        return isGood
    }

    fun reset() {
        wasTriggered = false
        validators.forEach {
            it.editableText.requestFocus()
            it.editableText.error = null
            it.editableText.clearFocus()
        }

        //runValidations(false)
    }
}