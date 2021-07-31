package br.com.fiap.sociallearn.domain.entities

import br.com.fiap.sociallearn.data.model.UserModel

data class UserEntityRequest(
    var name: String,
    var email: String,
    var password: String,
    var confirmPassword: String,
    var knowledgeToLearn: MutableList<String>,
    var knowledgeToTeach: MutableList<String>,
    var active: Boolean
) {
    fun toModel(): UserModel {
        return UserModel(
            name = this.name,
            email = this.email,
            password = this.password,
            knowledgeToLearn = this.knowledgeToLearn,
            knowledgeToTeach = this.knowledgeToTeach,
            active = this.active
        )
    }
}