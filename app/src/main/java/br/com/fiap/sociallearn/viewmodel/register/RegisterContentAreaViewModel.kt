package br.com.fiap.sociallearn.viewmodel.register

import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.domain.useCases.register.MakeRegisterContentAreaContract

class RegisterContentAreaViewModel(
    private val contract: RegisterContentAreaContract,
    makeRegister: MakeRegisterContentAreaContract
) : ViewModel() {


    fun onFinishAction(){
        //ToDO: Add logic to show error
        contract.showMessage(R.string.ERROR_GENERIC)
    }
}