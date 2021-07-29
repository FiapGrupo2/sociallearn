package br.com.fiap.sociallearn.main.di

import br.com.fiap.sociallearn.data.login.useCases.CheckUserIsLogged
import br.com.fiap.sociallearn.data.login.useCases.MakeLogin
import br.com.fiap.sociallearn.data.login.useCases.MakeResetPassword
import br.com.fiap.sociallearn.data.signUp.useCases.MakeSignUp
import br.com.fiap.sociallearn.viewmodel.login.LoginContract
import br.com.fiap.sociallearn.viewmodel.login.LoginViewModel
import br.com.fiap.sociallearn.viewmodel.login.ResetPasswordContract
import br.com.fiap.sociallearn.viewmodel.login.ResetPasswordViewModel
import br.com.fiap.sociallearn.viewmodel.signUp.SignUpContract
import br.com.fiap.sociallearn.viewmodel.signUp.SignUpViewModel
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

        viewModel { (contract: ResetPasswordContract) ->
            ResetPasswordViewModel(contract, get<MakeResetPassword>())
        }
    }
}