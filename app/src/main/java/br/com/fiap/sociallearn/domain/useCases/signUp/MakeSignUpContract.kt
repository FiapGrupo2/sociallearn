package br.com.fiap.sociallearn.domain.useCases.signUp

import br.com.fiap.sociallearn.data.model.UserModel
import br.com.fiap.sociallearn.domain.entities.UserEntityRequest
import br.com.fiap.sociallearn.domain.exceptions.GenericException

interface MakeSignUpContract {
    fun execute(
        userEntity: UserEntityRequest,
        onSuccessListener: () -> Unit,
        OnFailureListener: (GenericException) -> Unit
    );
}