package br.com.fiap.sociallearn.viewmodel.base

interface BaseContract {
    fun goToLoginActivity()
    fun goToUserListResultActivity(contentQuery: String)
    fun showMessage(resId: Int)
}