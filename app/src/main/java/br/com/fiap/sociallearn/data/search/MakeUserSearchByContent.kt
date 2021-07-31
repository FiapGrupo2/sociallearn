package br.com.fiap.sociallearn.data.search;

import br.com.fiap.sociallearn.domain.useCases.search.MakeUserSearchByContentContract
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class MakeUserSearchByContent : MakeUserSearchByContentContract {
    private val db = FirebaseFirestore.getInstance()

    override fun execute(content: String): Task<QuerySnapshot> {
        return db.collection("users")
            .whereArrayContains("knowledgeToTeach", content)
            .whereEqualTo("active", true)
            .get()
    }
}
