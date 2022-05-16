package ph.edu.dlsu.mobdeve.sison.kirsten.s11application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import ph.edu.dlsu.mobdeve.sison.kirsten.s11application.adapter.AccountAdapter
import ph.edu.dlsu.mobdeve.sison.kirsten.s11application.callback.SwipeCallback
import ph.edu.dlsu.mobdeve.sison.kirsten.s11application.dao.AccountsDAO
import ph.edu.dlsu.mobdeve.sison.kirsten.s11application.dao.AccountsDAOArrayImpl
import ph.edu.dlsu.mobdeve.sison.kirsten.s11application.databinding.ActivityLoginBinding
import ph.edu.dlsu.mobdeve.sison.kirsten.s11application.model.Account

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var accountAdapter: AccountAdapter
    private lateinit var accountArrayList:ArrayList<Account>
    private lateinit var itemTouchHelper: ItemTouchHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

        binding.rvList.setLayoutManager(LinearLayoutManager(applicationContext))
//        binding.rvList.layoutManager(GridLayoutManager(getApplicationContext(),2))
        accountAdapter = AccountAdapter(applicationContext, accountArrayList)
        binding.rvList.setAdapter(accountAdapter)

        var swipeCallback = SwipeCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        swipeCallback.accountAdapter = accountAdapter
        itemTouchHelper = ItemTouchHelper(swipeCallback)
        itemTouchHelper.attachToRecyclerView(binding.rvList)
    }

    private fun init() {
        var dao:AccountsDAO = AccountsDAOArrayImpl()

        val account_0 = Account()
        account_0.email = "sushi@email.com"
        account_0.username = "sushimaster"
        account_0.password = "password"
        dao.addAccount(account_0)

        val account_1 = Account()
        account_1.email = "hello@world.com"
        account_1.username = "helloworld"
        account_1.password = "password"
        dao.addAccount(account_1)

        val account_2 = Account()
        account_2.email = "jajamba@yahoo.com"
        account_2.username = "majamba"
        account_2.password = "password"
        dao.addAccount(account_2)

        val account_3 = Account()
        account_3.email = "jollibee@bida.com"
        account_3.username = "jabee"
        account_3.password = "password"
        dao.addAccount(account_3)

        accountArrayList = dao.getAccounts();
    }
}