package br.com.fiap.sociallearn.domain.useCases.register

interface MakeRegisterUserProfileContract {
    fun execute(
        profile: String,
        onSuccessListener: () -> Unit
    )
}