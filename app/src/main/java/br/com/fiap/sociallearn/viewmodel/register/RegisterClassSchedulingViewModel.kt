package br.com.fiap.sociallearn.viewmodel.register

import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.domain.useCases.register.MakeRegisterClassSchedulingContract

class RegisterClassSchedulingViewModel(
    contract: RegisterClassSchedulingContract,
    makeRegister: MakeRegisterClassSchedulingContract
): ViewModel() {
}