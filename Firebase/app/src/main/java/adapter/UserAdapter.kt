package adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import model.User

class UserAdapter(val context:Context,val userList:ArrayList<User>):RecyclerView.Adapter<UserAdapter.Myclass>() {

    class Myclass(itemView:View):RecyclerView.ViewHolder(itemView)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myclass {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: Myclass, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
