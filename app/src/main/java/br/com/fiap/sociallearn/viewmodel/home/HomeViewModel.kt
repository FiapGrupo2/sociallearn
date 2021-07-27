package br.com.fiap.sociallearn.viewmodel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.example.sociallearn.viewmodel.search.content.SearchContentContract
import br.com.fiap.sociallearn.domain.useCases.logout.MakeLogoutContract
import br.com.fiap.sociallearn.helpers.RequestState
import com.google.firebase.auth.FirebaseAuth

class HomeViewModel(
    contract: HomeContract,
    searchContent: SearchContentContract,
    makeLogout: MakeLogoutContract
) : ViewModel() {
    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    val loggedState = MutableLiveData<RequestState<Boolean>>()

    fun onLogoutPressed() {

        loggedState.value = RequestState.Loading
        mAuth.signOut()
        loggedState.value = RequestState.Success(true)
    }

}