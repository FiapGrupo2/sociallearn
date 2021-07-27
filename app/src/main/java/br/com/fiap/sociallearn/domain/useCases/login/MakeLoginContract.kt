package br.com.example.sociallearn.domain.useCases.login

import br.com.example.sociallearn.domain.exceptions.GenericException

interface MakeLoginContract {
    fun execute(
        email: String,
        password: String,
        onSuccessListener: () -> Unit,
        OnFailureListener: (GenericException) -> Unit
    );
}