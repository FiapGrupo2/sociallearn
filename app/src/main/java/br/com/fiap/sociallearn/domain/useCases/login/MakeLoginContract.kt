package br.com.fiap.sociallearn.domain.useCases.login

import br.com.fiap.sociallearn.domain.exceptions.GenericException

interface MakeLoginContract {
    fun execute(
        email: String,
        password: String,
        onSuccessListener: () -> Unit,
        onFailureListener: (GenericException) -> Unit
    );
}