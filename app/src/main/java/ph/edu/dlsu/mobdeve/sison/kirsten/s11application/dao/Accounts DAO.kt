package ph.edu.dlsu.mobdeve.sison.kirsten.s11application.dao

import ph.edu.dlsu.mobdeve.sison.kirsten.s11application.model.Account

// Controller in MVC ?

interface AccountsDAO {
    fun addAccount(account:Account)
    fun getAccounts():ArrayList<Account>
}

class AccountsDAOArrayImpl: AccountsDAO{
    // Class for CRUD operation; This is where you make API calls I assume?
    private var arrayListAccounts = ArrayList<Account>()

    override fun addAccount(account: Account) {
        arrayListAccounts.add(0,account)
    }

    override fun getAccounts(): ArrayList<Account> {
        return arrayListAccounts
    }

}