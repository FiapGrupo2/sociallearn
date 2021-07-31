package br.com.fiap.sociallearn.ui.search.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.sociallearn.R
import br.com.fiap.sociallearn.domain.entities.UserEntity
import kotlinx.android.synthetic.main.user_search_list.view.*


class SearchUserAdapter(
    private val userList: List<UserEntity>,
    private val context: Context
) :
    RecyclerView.Adapter<SearchUserAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(user: UserEntity) {
            val userName = itemView.userName
            val email = itemView.email

            userName.text = user.name
            email.text = user.email
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(context)
            .inflate(R.layout.user_search_list, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.bindView(userList[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = userList.size

}
