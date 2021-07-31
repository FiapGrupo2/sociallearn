package br.com.fiap.sociallearn.domain.entities

import java.io.Serializable

data class UserEntityResponse(
    var name: String,
    var email: String,
    var knowledgeToLearn: MutableList<String>,
    var knowledgeToTeach: MutableList<String>,
) : Serializable {

}