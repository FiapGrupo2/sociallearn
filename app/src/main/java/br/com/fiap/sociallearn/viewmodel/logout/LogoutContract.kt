package br.com.fiap.sociallearn.viewmodel.logout

interface LogoutContract {
    fun goToLogout()
    fun goToLogin()
    fun showMessage(restId: Int)
}