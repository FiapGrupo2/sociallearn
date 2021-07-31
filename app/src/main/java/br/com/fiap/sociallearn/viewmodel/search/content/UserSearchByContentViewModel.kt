package br.com.fiap.sociallearn.viewmodel.search.content

import androidx.lifecycle.ViewModel
import br.com.fiap.sociallearn.domain.entities.UserEntity
import br.com.fiap.sociallearn.domain.useCases.search.MakeUserSearchByContentContract
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot

class UserSearchByContentViewModel(
    private val contract: UserSearchByContentContract,
    private val makeContentSearchContract: MakeUserSearchByContentContract
) : ViewModel() {

    fun makeSearch(content: String): Task<QuerySnapshot> {
        return makeContentSearchContract.execute(content);
    }
}