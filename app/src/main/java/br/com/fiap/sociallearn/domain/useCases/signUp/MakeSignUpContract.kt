package br.com.example.sociallearn.domain.useCases.signUp

import br.com.example.sociallearn.domain.exceptions.GenericException

interface MakeSignUpContract {
    fun execute(
        email: String,
        password: String,
        //tudo de login
        onSuccessListener: () -> Unit,
        OnFailureListener: (GenericException) -> Unit
    );
}