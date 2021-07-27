package br.com.fiap.sociallearn.model

import java.util.*
import kotlin.collections.ArrayList

data class ClassScheduling(var id: Int,
                           var courseMode: CourseMode,
                           var users: ArrayList<User>,
                           var learningContent: LearningContent,
                           var realizationDate: Date,
                           var durationInHours: Double,
                           var active: Boolean,
                           var createdDate: Date,
                           var lastModifiedDate: Date

)
