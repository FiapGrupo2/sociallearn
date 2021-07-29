package br.com.fiap.sociallearn.data.login.useCases;

import androidx.lifecycle.MutableLiveData
import br.com.fiap.sociallearn.domain.exceptions.GenericException
import br.com.fiap.sociallearn.domain.useCases.login.MakeResetPasswordContract
import br.com.fiap.sociallearn.helpers.RequestState
import com.google.firebase.auth.FirebaseAuth

class MakeResetPassword : MakeResetPasswordContract {
    private val resetPasswordState = MutableLiveData<RequestState<String>>()

    override fun execute(
        email: String,
        onSuccessListener: () -> Unit,
        onFailureListener: (GenericException) -> Unit
    ) {
        resetPasswordState.value = RequestState.Loading
        if (email.isNotEmpty()) {
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        resetPasswordState.value =
                            RequestState.Success("Verifique sua caixa de e-mail")
                    } else {
                        resetPasswordState.value = RequestState.Error(
                            Throwable(
                                task.exception?.message ?: "Não foi possível realizar a requisição"
                            )
                        )
                    }
                }.addOnSuccessListener {
                    onSuccessListener()
                }.addOnFailureListener {
                    onFailureListener(GenericException.GENERIC_ERROR)
                }
        } else {
            resetPasswordState.value =
                RequestState.Error(Throwable("Não foi possível resetar a senha"))
        }
    }
}
