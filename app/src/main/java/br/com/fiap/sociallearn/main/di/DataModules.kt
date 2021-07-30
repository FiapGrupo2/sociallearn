package br.com.fiap.sociallearn.main.di

import br.com.fiap.sociallearn.data.login.useCases.CheckUserIsLogged
import br.com.fiap.sociallearn.data.login.useCases.MakeLogin
import br.com.fiap.sociallearn.data.login.useCases.MakeResetPassword
import br.com.fiap.sociallearn.data.register.useCases.MakeKnowledgeToLearnAssociation
import br.com.fiap.sociallearn.data.register.useCases.MakeKnowledgeToTeachAssociation
import br.com.fiap.sociallearn.data.signUp.useCases.MakeSignUp
import org.koin.dsl.module

object DataModules {
    val modules = module {
        factory { CheckUserIsLogged() }
        factory { MakeLogin() }
        factory { MakeResetPassword() }
        factory { MakeSignUp() }
        factory { MakeKnowledgeToLearnAssociation() }
        factory { MakeKnowledgeToTeachAssociation() }
    }
}