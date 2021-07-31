package br.com.fiap.sociallearn.data.signUp.useCases

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import br.com.fiap.sociallearn.data.model.UserModel
import br.com.fiap.sociallearn.domain.entities.UserEntity
import br.com.fiap.sociallearn.domain.exceptions.EmailInvalidException
import br.com.fiap.sociallearn.domain.exceptions.GenericException
import br.com.fiap.sociallearn.domain.exceptions.PasswordInvalidException
import br.com.fiap.sociallearn.domain.useCases.signUp.MakeSignUpContract
import br.com.fiap.sociallearn.extensions.isValidEmail
import br.com.fiap.sociallearn.helpers.RequestState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import java.util.regex.Pattern

class MakeSignUp : MakeSignUpContract {
    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()
    private val signUpState = MutableLiveData<RequestState<FirebaseUser>>()

    override fun execute(
        newUser: UserModel,
        onSuccessListener: () -> Unit,
        onFailureListener: (GenericException) -> Unit
    ) {
        signUpState.value = RequestState.Loading

        if (validateFields(newUser)) {
            mAuth.createUserWithEmailAndPassword(
                newUser.email,
                newUser.password
            )
                .addOnSuccessListener {
                    onSuccessListener()
                    saveInFirestore(newUser)
                }.addOnFailureListener { e ->
                    signUpState.value = RequestState.Error(
                        Throwable(
                            e.message ?: "Não foi possível realizar a requisição"
                        )
                    )
                }
        }
    }

    private fun validateFields(newUser: UserModel): Boolean {

        if (newUser.name.isEmpty()) {
            signUpState.value = RequestState.Error(Throwable("Informe o nome do usuário"))
            return false
        }

        if (!newUser.email.isValidEmail()) {
            signUpState.value = RequestState.Error(EmailInvalidException("E-mail inválido"))
            return false
        }

        if (newUser.password.isEmpty()) {
            signUpState.value = RequestState.Error(PasswordInvalidException("Informe uma senha"))
            return false
        }

        if (newUser.password.length < 6) {
            signUpState.value =
                RequestState.Error(PasswordInvalidException("Senha deve ter no mínimo 6 caracteres"))
            return false
        }

        return true
    }

    private fun saveInFirestore(newUser: UserModel) {
        db.collection("users")
            .document(mAuth.currentUser?.email!!)
            .set(newUser)
            .addOnSuccessListener {
                sendEmailVerification()
            }
            .addOnFailureListener { e ->
                signUpState.value = RequestState.Error(
                    Throwable(e.message)
                )
            }
    }

    private fun sendEmailVerification() {
        mAuth.currentUser?.sendEmailVerification()
            ?.addOnCompleteListener { _ ->
                signUpState.value = RequestState.Success(mAuth.currentUser!!)
            }
    }
}