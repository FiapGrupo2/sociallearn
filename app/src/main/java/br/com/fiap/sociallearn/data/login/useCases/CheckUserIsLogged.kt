package br.com.example.sociallearn.data.login.useCases

import br.com.example.sociallearn.domain.useCases.login.CheckUserIsLoggedContract

class CheckUserIsLogged: CheckUserIsLoggedContract {
    override fun execute(): Boolean {
        return false
    }
}