package br.com.fiap.sociallearn.domain.entities

import br.com.fiap.sociallearn.data.signUp.model.UserModel

data class UserLearningContentEntity(
    var id: Int,
    var user: UserModel,
    var learningContent: LearningContentEntity
)
