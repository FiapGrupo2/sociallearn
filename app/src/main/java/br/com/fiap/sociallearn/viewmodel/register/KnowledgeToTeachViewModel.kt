package br.com.fiap.sociallearn.viewmodel.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.domain.exceptions.GenericException
import br.com.fiap.sociallearn.domain.useCases.register.MakeKnowledgeToTeachAssociationContract

class KnowledgeToTeachViewModel(
    private val contract: KnowledgeToTeachContract,
    private val makeAssociation: MakeKnowledgeToTeachAssociationContract
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

    var knowledgeToTeachList: MutableList<String> = ArrayList()

    fun onFinishPressed() {
        populateCourseList()
        makeAssociation.execute(knowledgeToTeachList, {
            contract.goToHomeActivity()
        }, { error ->
            when (error) {
                GenericException.GENERIC_ERROR -> contract.showMessage(R.string.ERROR_GENERIC)
            }
        })
    }

    private fun populateCourseList() {
        if (kotlinIsChecked.value == true) {
            knowledgeToTeachList.add("KOTLIN")
        }

        if (javaIsChecked.value == true) {
            knowledgeToTeachList.add("JAVA")
        }

        if (pythonIsChecked.value == true) {
            knowledgeToTeachList.add("PYTHON")
        }

        if (angularIsChecked.value == true) {
            knowledgeToTeachList.add("ANGULAR")
        }

        if (nodeJsIsChecked.value == true) {
            knowledgeToTeachList.add("NODE JS")
        }

        if (bootstrapIsChecked.value == true) {
            knowledgeToTeachList.add("BOOTSTRAP")
        }

        if (javaScriptIsChecked.value == true) {
            knowledgeToTeachList.add("JAVASCRIPT")
        }

        if (rubyIsChecked.value == true) {
            knowledgeToTeachList.add("RUBY")
        }

        if (salesforceIsChecked.value == true) {
            knowledgeToTeachList.add("SALESFORCE")
        }

        if (securityIsChecked.value == true) {
            knowledgeToTeachList.add("SEGURANÇA DA INFORMAÇÃO")
        }

        if (sqlServerIsChecked.value == true) {
            knowledgeToTeachList.add("SQL SERVER")
        }

        if (postgreeIsChecked.value == true) {
            knowledgeToTeachList.add("POSTGREE")
        }

        if (cSharpIsChecked.value == true) {
            knowledgeToTeachList.add("C#")
        }
    }
}