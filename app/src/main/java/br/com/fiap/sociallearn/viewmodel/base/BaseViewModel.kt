package br.com.fiap.sociallearn.viewmodel.base

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class BaseViewModel(
    private val contract: BaseContract,
) : ViewModel() {
    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun makeLogout() {
        mAuth.signOut()
        contract.goToLoginActivity()
    }
}