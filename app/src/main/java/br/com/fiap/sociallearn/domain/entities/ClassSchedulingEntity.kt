package br.com.fiap.sociallearn.domain.entities

import br.com.fiap.sociallearn.data.signUp.model.UserModel
import java.util.*

class ClassSchedulingEntity(
    var id: Int,
    var courseMode: CourseModeEnum,
    var users: ArrayList<UserModel>,
    var learningContent: LearningContentEntity,
    var realizationDate: Date,
    var durationInHours: Double,
    var active: Boolean,
    var createdDate: Date,
    var lastModifiedDate: Date

)
