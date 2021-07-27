package br.com.fiap.sociallearn.viewmodel.register

import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.domain.useCases.register.MakeRegisterLearningContentContract

class RegisterLearningContentViewModel(
    contract: RegisterLearningContentContract,
    makeRegister: MakeRegisterLearningContentContract
): ViewModel() {
}