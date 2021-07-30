package br.com.fiap.sociallearn.viewmodel.home

import android.content.Intent
import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.domain.useCases.logout.MakeLogoutContract
import br.com.fiap.sociallearn.ui.cursos.JavaCourseActivity
import br.com.fiap.sociallearn.viewmodel.search.content.SearchContentContract

class HomeViewModel(
    private val contract: HomeContract,
    private val searchContent: SearchContentContract,
    private val makeLogout: MakeLogoutContract
) : ViewModel() {

    fun onCreate() {

    }
    fun onLogoutPressed() {
        makeLogout.execute {
            contract.goToLoginActivity()
        }
    }

    fun goToCourseInformation() {
        contract.goToCourseInformation()
    }

}