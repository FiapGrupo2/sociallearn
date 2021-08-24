package br.com.fiap.sociallearn.ui.base

import android.content.Intent
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.ui.login.LoginActivity
import br.com.fiap.sociallearn.ui.search.UserSearchByContentActivity
import br.com.fiap.sociallearn.utils.UtilToast
import br.com.fiap.sociallearn.viewmodel.base.BaseContract
import br.com.fiap.sociallearn.viewmodel.base.BaseViewModel
import org.koin.core.parameter.parametersOf
import org.koin.androidx.viewmodel.ext.android.viewModel
open class BaseActivity : AppCompatActivity(), BaseContract {
    private val viewModel: BaseViewModel by viewModel { parametersOf(this) }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val searchBtn = menu?.findItem(R.id.search)
        val searchEditText = searchBtn?.actionView as SearchView

        searchEditText.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }


                override fun onQueryTextSubmit(query: String?): Boolean {
                    Log.i("status", "submit")
                    goToUserListResultActivity(query!!)
                    return false
                }
            }
        )

        return super.onCreateOptionsMenu(menu)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            finish()
        } else if (id == R.id.action_logout) {
            viewModel.makeLogout()
        }

        return super.onOptionsItemSelected(item)
    }


    override fun goToUserListResultActivity(contentQuery: String) {
        val intent = Intent(this, UserSearchByContentActivity::class.java)
        intent.action = Intent.ACTION_SEARCH
        intent.putExtra("query", contentQuery)
        startActivity(intent)
    }

    override fun goToLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun showMessage(resIdMsg: Int) {
        UtilToast.showMessage(this, resIdMsg)
    }
}