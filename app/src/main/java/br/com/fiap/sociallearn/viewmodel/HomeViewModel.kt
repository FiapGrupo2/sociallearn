package br.com.fiap.sociallearn.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.model.RequestState
import com.google.firebase.auth.FirebaseAuth

class HomeViewModel : ViewModel() {
    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    val loggedState = MutableLiveData<RequestState<Boolean>>()

    fun logout() {
        loggedState.value = RequestState.Loading
        mAuth.signOut()
        loggedState.value = RequestState.Success(true)
    }

}