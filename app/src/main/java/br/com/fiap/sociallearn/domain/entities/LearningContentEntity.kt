package br.com.fiap.sociallearn.domain.entities

data class LearningContentEntity(
    var id: Int,
    var name: String,
    var contentAreas: ArrayList<ContentAreaEntity>
)
