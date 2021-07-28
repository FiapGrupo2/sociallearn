package br.com.fiap.sociallearn.domain.entities

import br.com.fiap.sociallearn.data.signUp.model.ProfileModel
import br.com.fiap.sociallearn.domain.entities.GenderEnum

class UserEntity(
    var id: Int,
    var name: String,
    var email: String,
    var password: String,
    var active: Boolean,
    var gender: GenderEnum?,
    var profiles: ArrayList<ProfileModel>
) {

}