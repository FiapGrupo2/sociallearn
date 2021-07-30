package br.com.fiap.sociallearn.viewmodel.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.domain.useCases.register.MakeKnowledgeToTeachAssociationContract

class KnowledgeToTeachViewModel(
    private val contract: KnowledgeToTeachContract,
    private val makeAssociation: MakeKnowledgeToTeachAssociationContract
) : ViewModel() {

    var kotlinIsChecked = MutableLiveData<Boolean>()
    var javaIsChecked = MutableLiveData<Boolean>()
    var pythonIsChecked = MutableLiveData<Boolean>()

    var knowledgeToTeachList: MutableList<String> = ArrayList()

    fun onFinishPressed() {
        if (kotlinIsChecked.value == true) {
            knowledgeToTeachList.add("KOTLIN")
        }

        if (javaIsChecked.value == true) {
            knowledgeToTeachList.add("JAVA")
        }

        if (pythonIsChecked.value == true) {
            knowledgeToTeachList.add("PYTHON")
        }


        makeAssociation.execute(knowledgeToTeachList, {
            contract.goToHomeActivity()
        }, { error ->
            when (error) {

            }
        })
    }
}