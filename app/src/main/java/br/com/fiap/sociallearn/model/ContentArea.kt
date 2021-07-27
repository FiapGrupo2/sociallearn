package br.com.fiap.sociallearn.model

import java.util.*

data class ContentArea(var id: Int,
                       var name: String,
                       var active: Boolean,
                       var createdDate: Date,
                       var lastModifiedDate: Date)
