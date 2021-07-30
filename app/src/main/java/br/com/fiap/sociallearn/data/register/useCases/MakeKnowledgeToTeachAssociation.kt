package br.com.fiap.sociallearn.data.register.useCases;

import androidx.lifecycle.MutableLiveData
import br.com.fiap.sociallearn.domain.exceptions.GenericException
import br.com.fiap.sociallearn.domain.useCases.register.MakeKnowledgeToTeachAssociationContract
import br.com.fiap.sociallearn.helpers.RequestState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

class MakeKnowledgeToTeachAssociation : MakeKnowledgeToTeachAssociationContract {
    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()
    private val signUpState = MutableLiveData<RequestState<FirebaseUser>>()

    override fun execute(
        knowledgeToTeachList: List<String>,
        onSuccessListener: () -> Unit,
        OnFailureListener: (GenericException) -> Unit
    ) {
        db.collection("users")
            .document(mAuth.currentUser?.email!!)
            .update("knowledgeToTeach", knowledgeToTeachList)
            .addOnSuccessListener {
                onSuccessListener()
            }
            .addOnFailureListener { e ->
                signUpState.value = RequestState.Error(
                    Throwable(e.message)
                )
            }
    }
}
