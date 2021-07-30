package br.com.fiap.sociallearn.domain.useCases.register

import br.com.fiap.sociallearn.domain.exceptions.GenericException

interface MakeKnowledgeToTeachAssociationContract {
    fun execute(
        knowledgeToTeachList: List<String>,
        onSuccessListener: () -> Unit,
        OnFailureListener: (GenericException) -> Unit
    )
}