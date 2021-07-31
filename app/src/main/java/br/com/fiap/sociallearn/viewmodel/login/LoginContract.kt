package br.com.fiap.sociallearn.viewmodel.login

interface LoginContract {
    fun goToMainActivity()
    fun goToSignUpActivity()
    fun goToResetPasswordActivity()
    fun showMessage(restId: Int)
}