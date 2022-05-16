package ph.edu.dlsu.mobdeve.sison.kirsten.s11application.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ph.edu.dlsu.mobdeve.sison.kirsten.s11application.HomeActivity
import ph.edu.dlsu.mobdeve.sison.kirsten.s11application.databinding.ItemAccountBinding
import ph.edu.dlsu.mobdeve.sison.kirsten.s11application.model.Account

// What is an Adapter? Does it bind data to the recycler view?
// Is the DAO necessary if I don't plan to dynamically store data>?
class AccountAdapter:RecyclerView.Adapter<AccountAdapter.AccountViewHolder> {
    private var accountArrayList = ArrayList<Account>()
    private lateinit var context: Context

    public constructor(context: Context, accountArrayList:ArrayList<Account>) {
        this.context = context
        this.accountArrayList = accountArrayList
    }

    fun removeAccount(position: Int) {
        accountArrayList.removeAt(position)
        notifyItemRemoved(position)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return accountArrayList.size
    }

    // What does this function do? What do the parameters mean?
    // Where is it used?? Is it an override of a method in RecyclerView.Adapter?
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AccountAdapter.AccountViewHolder {
        val itemBinding = ItemAccountBinding.inflate(
            LayoutInflater.from(parent.context), // Loads layout during runtime
            parent, false       // What are these values for?
        )
        return AccountViewHolder(itemBinding)
    }

    // What does this function do? What do the parameters mean?
    override fun onBindViewHolder(holder: AccountAdapter.AccountViewHolder, position: Int) {
       holder.bindAccount(accountArrayList[position])   // Individually binds each item to a holder?
    }

    // Binds a model instance to the UI component
    inner class AccountViewHolder(private val itemBinding: ItemAccountBinding)
        : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

        var account = Account()

        init {
            itemView.setOnClickListener(this)
        }

        fun bindAccount(account:Account){
            this.account = account
            itemBinding.textUsername.text = account.username
            itemBinding.textEmail.text = account.email
        }

        override fun onClick(p0: View?) {
            Toast.makeText(context, "${account.username}", Toast.LENGTH_SHORT).show()
            val goToHome = Intent(context, HomeActivity::class.java)
            val bundle = Bundle()
            bundle.putString("username", account.username)
            bundle.putString("password", account.password)
            bundle.putString("email", account.email)
            goToHome.putExtras(bundle)
            goToHome.putExtra("source", "CAME FROM ADAPTER")
            goToHome.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(goToHome)
        }
    }
}