package br.com.fiap.sociallearn.domain.entities

import lombok.Data
import java.io.Serializable

@Data
class UserEntity(
    var name: String,
    var email: String,
    var password: String,
    var active: Boolean,
) : Serializable {

}