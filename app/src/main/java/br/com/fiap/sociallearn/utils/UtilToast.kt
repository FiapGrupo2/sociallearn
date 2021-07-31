package br.com.fiap.sociallearn.utils

import android.content.Context
import android.view.Gravity
import android.widget.Toast
import androidx.fragment.app.Fragment

object UtilToast {
    init {  }

    fun showMessage(context: Context, message: String) {
        val toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
        showToast(toast)
    }

    fun showMessage(fragment: Fragment, message: String) {
        val toast = Toast.makeText(fragment.context, message, Toast.LENGTH_LONG)
        showToast(toast)
    }

    fun showMessage(fragment: Fragment, resId: Int) {
        val toast = Toast.makeText(fragment.context, fragment.context?.getString(resId), Toast.LENGTH_LONG)
        showToast(toast)
    }

    fun showMessage(context: Context, resId: Int) {
        val toast = Toast.makeText(context, context?.getString(resId), Toast.LENGTH_LONG)
        showToast(toast)
    }

    private fun showToast(toast: Toast) {
        toast.setGravity(Gravity.TOP, 200, 200)
        toast.show()
    }

}