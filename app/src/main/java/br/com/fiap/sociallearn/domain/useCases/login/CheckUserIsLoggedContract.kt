package br.com.example.sociallearn.domain.useCases.login

interface CheckUserIsLoggedContract {
    fun execute(): Boolean;
}