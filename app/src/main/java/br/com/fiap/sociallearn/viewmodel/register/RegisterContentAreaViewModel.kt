package br.com.fiap.sociallearn.viewmodel.register

import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.domain.useCases.register.MakeRegisterContentAreaContract

class RegisterContentAreaViewModel(
    contract: RegisterContentAreaContract,
    makeRegister: MakeRegisterContentAreaContract
) : ViewModel() {
}