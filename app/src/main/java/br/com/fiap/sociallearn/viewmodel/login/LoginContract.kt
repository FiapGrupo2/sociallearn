package br.com.example.sociallearn.viewmodel.login

interface LoginContract {
    fun goToMainActivity();
    fun showGenericErrorMessage();
    fun goToSignUpActivity();
}