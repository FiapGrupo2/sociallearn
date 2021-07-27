package br.com.fiap.sociallearn.model

data class User(var id:Int,
                var name: String,
                var email: String,
                var password: String,
                var active: Boolean,
                var gender: Gender?,
                var profiles: ArrayList<Profile>)
