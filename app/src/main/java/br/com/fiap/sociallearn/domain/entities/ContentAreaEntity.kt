package br.com.fiap.sociallearn.domain.entities

import java.util.*

data class ContentAreaEntity(
    var id: Int,
    var name: String,
    var active: Boolean,
    var createdDate: Date,
    var lastModifiedDate: Date
)
