package br.com.fiap.sociallearn.model

data class LearningContent(var id: Int,
                           var name: String,
                           var contentAreas: ArrayList<ContentArea>)
