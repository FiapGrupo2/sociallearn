package br.com.example.sociallearn.main.di

import br.com.example.sociallearn.data.login.useCases.CheckUserIsLogged
import br.com.example.sociallearn.data.login.useCases.MakeLogin
import br.com.example.sociallearn.data.signUp.MakeSignUp
import br.com.example.sociallearn.viewmodel.login.LoginContract
import br.com.example.sociallearn.viewmodel.login.LoginViewModel
import br.com.example.sociallearn.viewmodel.signUp.SignUpContract
import br.com.example.sociallearn.viewmodel.signUp.SignUpViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModules {
    val modules = module {
        viewModel { (contract: LoginContract) ->
            LoginViewModel(contract, get<CheckUserIsLogged>(), get<MakeLogin>())
        }

        viewModel { (contract: SignUpContract) ->
            SignUpViewModel(contract, get<MakeSignUp>())
        }
    }
}
