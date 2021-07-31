package br.com.fiap.sociallearn.data.model

data class UserModel(
    var name: String,
    var email: String,
    var password: String,
    var knowledgeToLearn: MutableList<String>,
    var knowledgeToTeach: MutableList<String>,
    var active: Boolean
)
