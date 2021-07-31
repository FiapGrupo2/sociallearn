package br.com.fiap.sociallearn.ui.search

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.provider.SearchRecentSuggestions
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.SearchableProvider
import br.com.fiap.sociallearn.databinding.ActivityUserSearchByContentBinding
import br.com.fiap.sociallearn.domain.entities.UserEntity
import br.com.fiap.sociallearn.ui.base.BaseActivity
import br.com.fiap.sociallearn.ui.search.adapter.SearchUserAdapter
import br.com.fiap.sociallearn.viewmodel.search.content.UserSearchByContentContract
import br.com.fiap.sociallearn.viewmodel.search.content.UserSearchByContentViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.activity_user_search_by_content.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class UserSearchByContentActivity : BaseActivity(), UserSearchByContentContract {
    private lateinit var binding: ActivityUserSearchByContentBinding
    private val viewModel: UserSearchByContentViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_search_by_content)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        showResults()

    }

    private fun showResults() {
        handleSearch(intent)!!.addOnCompleteListener { task ->
            val userList = ArrayList<UserEntity>()

            if (task.isSuccessful) {
                for (document in task.result.documents) {
                    Log.i("e-mail", document.get("email").toString())

                    val user = UserEntity(
                        name = document.get("name").toString(),
                        email = document.get("email").toString(),
                        knowledgeToLearn = document.get("knowledgeToLearn") as MutableList<String>,
                        knowledgeToTeach = document.get("knowledgeToTeach") as MutableList<String>
                    )

                    userList.add(user)
                }

                val recyclerView = user_list_recyclerview
                recyclerView.adapter = SearchUserAdapter(userList, this)
                val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
                recyclerView.layoutManager = layoutManager
            }
        }
    }

    private fun handleSearch(intent: Intent?): Task<QuerySnapshot>? {
        intent?.let {
            if (Intent.ACTION_SEARCH.equals(it.action, ignoreCase = true)) {
                it.getStringExtra(SearchManager.QUERY)?.also { query ->
                    saveQuery(query)
                    return viewModel.makeSearch(query)
                }
            }
        }

        return null
    }

    private fun saveQuery(query: String) {
        val searchRecentSuggestions = SearchRecentSuggestions(
            this,
            SearchableProvider.authority,
            SearchableProvider.mode
        )
        searchRecentSuggestions.saveRecentQuery(query, null)
    }

    override fun showMessage(restId: Int) {
        TODO("Not yet implemented")
    }
}