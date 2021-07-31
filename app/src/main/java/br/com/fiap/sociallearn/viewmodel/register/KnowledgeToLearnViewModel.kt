package br.com.fiap.sociallearn.viewmodel.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.domain.exceptions.GenericException
import br.com.fiap.sociallearn.domain.useCases.register.MakeKnowledgeToLearnAssociationContract

class KnowledgeToLearnViewModel(
    private val contract: KnowledgeToLearnContract,
    private val makeAssociation: MakeKnowledgeToLearnAssociationContract
) : ViewModel() {

    var kotlinIsChecked = MutableLiveData<Boolean>()
    var javaIsChecked = MutableLiveData<Boolean>()
    var pythonIsChecked = MutableLiveData<Boolean>()

    var knowledgeToLearnList: MutableList<String> = ArrayList()

    fun onNextPressed() {
        if (kotlinIsChecked.value == true) {
            knowledgeToLearnList.add("KOTLIN")
        }

        if (javaIsChecked.value == true) {
            knowledgeToLearnList.add("JAVA")
        }

        if (pythonIsChecked.value == true) {
            knowledgeToLearnList.add("PYTHON")
        }

        makeAssociation.execute(knowledgeToLearnList, {
            contract.goToKnowledgeToTeachActivity()
        }, { error ->
            when (error) {
                GenericException.GENERIC_ERROR -> contract.showMessage(R.string.ERROR_GENERIC)
            }
        })
    }
}