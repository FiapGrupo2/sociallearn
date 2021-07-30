package br.com.fiap.sociallearn.domain.useCases.signUp

import br.com.fiap.sociallearn.domain.entities.UserEntity
import br.com.fiap.sociallearn.domain.exceptions.GenericException

interface MakeSignUpContract {
    fun execute(
        userEntity: UserEntity,
        onSuccessListener: () -> Unit,
        OnFailureListener: (GenericException) -> Unit
    );
}