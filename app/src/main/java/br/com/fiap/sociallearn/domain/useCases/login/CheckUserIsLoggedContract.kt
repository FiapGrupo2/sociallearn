package br.com.fiap.sociallearn.domain.useCases.login

interface CheckUserIsLoggedContract {
    fun execute(): Boolean;
}