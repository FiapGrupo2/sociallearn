package br.com.fiap.sociallearn.domain.entities

import lombok.Data
import java.io.Serializable

@Data
class UserEntity(
    var name: String,
    var email: String,
    var knowledgeToLearn: MutableList<String>,
    var knowledgeToTeach: MutableList<String>,
) : Serializable {

}