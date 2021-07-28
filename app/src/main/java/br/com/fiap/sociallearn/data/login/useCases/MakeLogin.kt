package br.com.fiap.sociallearn.data.login.useCases

import androidx.lifecycle.MutableLiveData
import br.com.fiap.sociallearn.domain.exceptions.GenericException
import br.com.fiap.sociallearn.domain.useCases.login.MakeLoginContract
import br.com.fiap.sociallearn.helpers.RequestState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MakeLogin : MakeLoginContract {
    private val loginState = MutableLiveData<RequestState<FirebaseUser>>()
    private var mAuth = FirebaseAuth.getInstance()

    override fun execute(
        email: String,
        password: String,
        onSuccessListener: () -> Unit,
        onFailureListener: (GenericException) -> Unit
    ) {
        loginState.value = RequestState.Loading

        if (validateFields(email, password)) {
            mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        loginState.value = RequestState.Success(mAuth.currentUser!!)
                    } else {
                        loginState.value = RequestState.Error(
                            Throwable(
                                it.exception?.message ?: "Não foi possível realizar a requisição"
                            )
                        )
                    }
                }.addOnSuccessListener {
                    onSuccessListener()
                }
                .addOnFailureListener() {
                    onFailureListener(GenericException.GENERIC_ERROR)
                }
        }
    }

    private fun validateFields(email: String, password: String): Boolean {

        if (email.isEmpty()) {
            loginState.value = RequestState.Error(Throwable("E-mail não pode ser vazio"))
            return false
        }

        if (password.isEmpty()) {
            loginState.value = RequestState.Error(Throwable("Senha não pode ser vazia"))
            return false
        }

        if (password.length < 6) {
            loginState.value =
                RequestState.Error(Throwable("Senha tem que ter pelo menos 6 caracteres"))
            return false
        }

        return true
    }
}