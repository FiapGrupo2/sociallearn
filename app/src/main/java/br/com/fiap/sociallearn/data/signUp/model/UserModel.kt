package br.com.fiap.sociallearn.data.signUp.model

import br.com.fiap.sociallearn.domain.entities.GenderEnum

class UserModel(
    var id: Int,
    var name: String,
    var email: String,
    var password: String,
    var active: Boolean,
    var gender: GenderEnum?,
    var profiles: ArrayList<ProfileModel>
)
