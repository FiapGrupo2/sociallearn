package br.com.fiap.sociallearn.domain.useCases.search

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot

interface MakeUserSearchByContentContract {
    fun execute(content: String): Task<QuerySnapshot>
}