package br.com.fiap.sociallearn.data.logout.useCases

import androidx.lifecycle.MutableLiveData
import br.com.fiap.sociallearn.domain.useCases.logout.MakeLogoutContract
import br.com.fiap.sociallearn.helpers.RequestState
import com.google.firebase.auth.FirebaseAuth

class MakeLogout : MakeLogoutContract {
    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val loggedState = MutableLiveData<RequestState<Boolean>>()

    override fun execute(
        onSuccessListener: () -> Unit
    ) {
        loggedState.value = RequestState.Loading
        mAuth.signOut()
        loggedState.value = RequestState.Success(true)
        onSuccessListener()
    }
}