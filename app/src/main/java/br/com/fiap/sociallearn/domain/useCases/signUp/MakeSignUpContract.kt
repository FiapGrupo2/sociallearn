package br.com.fiap.sociallearn.domain.useCases.signUp

import br.com.fiap.sociallearn.domain.exceptions.GenericException

interface MakeSignUpContract {
    fun execute(
        email: String,
        password: String,
        //tudo de login
        onSuccessListener: () -> Unit,
        OnFailureListener: (GenericException) -> Unit
    );
}