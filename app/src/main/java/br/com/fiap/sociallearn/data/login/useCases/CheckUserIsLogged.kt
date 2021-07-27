package br.com.example.sociallearn.data.login.useCases

import androidx.lifecycle.MutableLiveData
import br.com.example.sociallearn.domain.useCases.login.CheckUserIsLoggedContract
import br.com.fiap.sociallearn.helpers.RequestState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class CheckUserIsLogged : CheckUserIsLoggedContract {
    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    val loggedState = MutableLiveData<RequestState<FirebaseUser>>()

    override fun execute(): Boolean {
        mAuth.currentUser?.reload()

        val user = mAuth.currentUser
        loggedState.value = RequestState.Loading

        if (user == null) {
            loggedState.value = RequestState.Error(Throwable("Usuário deslogado"))
            return false
        }

        loggedState.value = RequestState.Success(user)
        return true
    }
}