package br.com.fiap.sociallearn.viewmodel.register

import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.domain.useCases.register.MakeRegisterClassSchedulingContract

class RegisterClassSchedulingViewModel(
    private val contract: RegisterClassSchedulingContract,
    makeRegister: MakeRegisterClassSchedulingContract
) : ViewModel() {

    fun onFinishAction(){
        //ToDO: Add logic to show error
        contract.showMessage(R.string.ERROR_GENERIC)
    }
}