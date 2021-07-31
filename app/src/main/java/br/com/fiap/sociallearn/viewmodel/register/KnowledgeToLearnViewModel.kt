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
    var angularIsChecked = MutableLiveData<Boolean>()
    var nodeJsIsChecked = MutableLiveData<Boolean>()
    var bootstrapIsChecked = MutableLiveData<Boolean>()
    var javaScriptIsChecked = MutableLiveData<Boolean>()
    var rubyIsChecked = MutableLiveData<Boolean>()
    var salesforceIsChecked = MutableLiveData<Boolean>()
    var securityIsChecked = MutableLiveData<Boolean>()
    var sqlServerIsChecked = MutableLiveData<Boolean>()
    var postgreeIsChecked = MutableLiveData<Boolean>()
    var cSharpIsChecked = MutableLiveData<Boolean>()

    var knowledgeToLearnList: MutableList<String> = ArrayList()

    fun onNextPressed() {
        populateCourseList()
        makeAssociation.execute(knowledgeToLearnList, {
            contract.goToKnowledgeToTeachActivity()
        }, { error ->
            when (error) {
                GenericException.GENERIC_ERROR -> contract.showMessage(R.string.ERROR_GENERIC)
            }
        })
    }

    private fun populateCourseList() {
        if (kotlinIsChecked.value == true) {
            knowledgeToLearnList.add("KOTLIN")
        }

        if (javaIsChecked.value == true) {
            knowledgeToLearnList.add("JAVA")
        }

        if (pythonIsChecked.value == true) {
            knowledgeToLearnList.add("PYTHON")
        }

        if (angularIsChecked.value == true) {
            knowledgeToLearnList.add("ANGULAR")
        }

        if (nodeJsIsChecked.value == true) {
            knowledgeToLearnList.add("NODE JS")
        }

        if (bootstrapIsChecked.value == true) {
            knowledgeToLearnList.add("BOOTSTRAP")
        }

        if (javaScriptIsChecked.value == true) {
            knowledgeToLearnList.add("JAVASCRIPT")
        }

        if (rubyIsChecked.value == true) {
            knowledgeToLearnList.add("RUBY")
        }

        if (salesforceIsChecked.value == true) {
            knowledgeToLearnList.add("SALESFORCE")
        }

        if (securityIsChecked.value == true) {
            knowledgeToLearnList.add("SEGURANÇA DA INFORMAÇÃO")
        }

        if (sqlServerIsChecked.value == true) {
            knowledgeToLearnList.add("SQL SERVER")
        }

        if (postgreeIsChecked.value == true) {
            knowledgeToLearnList.add("POSTGREE")
        }

        if (cSharpIsChecked.value == true) {
            knowledgeToLearnList.add("C#")
        }
    }
}