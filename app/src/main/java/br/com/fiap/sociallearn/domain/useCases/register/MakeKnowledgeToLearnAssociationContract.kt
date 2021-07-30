package br.com.fiap.sociallearn.domain.useCases.register

import br.com.fiap.sociallearn.domain.exceptions.GenericException

interface MakeKnowledgeToLearnAssociationContract {
    fun execute(
        knowledgeToLearnList: List<String>,
        onSuccessListener: () -> Unit,
        OnFailureListener: (GenericException) -> Unit
    )
}