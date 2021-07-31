package br.com.fiap.sociallearn.main.di

import br.com.fiap.sociallearn.data.login.useCases.CheckUserIsLogged
import br.com.fiap.sociallearn.data.login.useCases.MakeLogin
import br.com.fiap.sociallearn.data.login.useCases.MakeResetPassword
import br.com.fiap.sociallearn.data.logout.useCases.MakeLogout
import br.com.fiap.sociallearn.data.register.useCases.MakeKnowledgeToLearnAssociation
import br.com.fiap.sociallearn.data.register.useCases.MakeKnowledgeToTeachAssociation
import br.com.fiap.sociallearn.data.signUp.useCases.MakeSignUp
import br.com.fiap.sociallearn.viewmodel.home.HomeContract
import br.com.fiap.sociallearn.viewmodel.home.HomeViewModel
import br.com.fiap.sociallearn.viewmodel.login.LoginContract
import br.com.fiap.sociallearn.viewmodel.login.LoginViewModel
import br.com.fiap.sociallearn.viewmodel.login.ResetPasswordContract
import br.com.fiap.sociallearn.viewmodel.login.ResetPasswordViewModel
import br.com.fiap.sociallearn.viewmodel.register.KnowledgeToLearnContract
import br.com.fiap.sociallearn.viewmodel.register.KnowledgeToLearnViewModel
import br.com.fiap.sociallearn.viewmodel.register.KnowledgeToTeachContract
import br.com.fiap.sociallearn.viewmodel.register.KnowledgeToTeachViewModel
import br.com.fiap.sociallearn.viewmodel.signUp.SignUpContract
import br.com.fiap.sociallearn.viewmodel.signUp.SignUpViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import br.com.fiap.sociallearn.viewmodel.logout.LogoutContract
import br.com.fiap.sociallearn.viewmodel.logout.LogoutViewModel

object ViewModelModules {
    val modules = module {
        viewModel { (contract: LogoutContract) ->
            LogoutViewModel(contract, get<MakeLogout>())
        }

        viewModel { (contract: LoginContract) ->
            LoginViewModel(contract, get<CheckUserIsLogged>(), get<MakeLogin>())
        }

        viewModel { (contract: SignUpContract) ->
            SignUpViewModel(contract, get<MakeSignUp>())
        }

        viewModel { (contract: ResetPasswordContract) ->
            ResetPasswordViewModel(contract, get<MakeResetPassword>())
        }

        viewModel { (contract: KnowledgeToLearnContract) ->
            KnowledgeToLearnViewModel(contract, get<MakeKnowledgeToLearnAssociation>())
        }

        viewModel { (contract: KnowledgeToTeachContract) ->
            KnowledgeToTeachViewModel(contract, get<MakeKnowledgeToTeachAssociation>())
        }

        viewModel { (contract: HomeContract) ->
            HomeViewModel(contract, get<MakeLogout>())
        }
    }
}
