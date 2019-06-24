package com.example.fitnesstrackerfinal.views.fragments.clients

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitnesstrackerfinal.R
import com.example.fitnesstrackerfinal.data.models.Client
import com.example.fitnesstrackerfinal.utils.MyConstants
import com.example.fitnesstrackerfinal.views.activities.client.AddClientActivity
import com.example.fitnesstrackerfinal.views.adapters.AddClientAdapter
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_clients.*
import javax.inject.Inject

class ClientsFragment: Fragment() {

    @Inject
    lateinit var factory: ClientsVMFactory

    var clientsViewModel: ClientsViewModel? = null
    var clients: List<Client>? = arrayListOf()

    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: LinearLayoutManager
    private lateinit var adapter: AddClientAdapter

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_clients,container,false)
        val fabAddClient: FloatingActionButton = view.findViewById(R.id.fab_addClient)

        setRecyclerView(view)

        clientsViewModel = ViewModelProviders.of(this,factory).get(ClientsViewModel::class.java)

        clientsViewModel!!.getAllClientsFromOfflineDb()

        clientsViewModel!!.liveClientList.observe(this, Observer {
            clients = it

            if(clients!!.isNotEmpty()){
                tv_emptyList.visibility = View.GONE
            }

            adapter.loadClients(clients as ArrayList<Client>)
            adapter.notifyDataSetChanged()
        })


        fabAddClient.setOnClickListener {
            val intent = Intent(view.context, AddClientActivity::class.java)
            startActivityForResult(intent, MyConstants.REQUEST_CODE_ADD_CLIENT)
        }

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //TODO Fetch last client
        clientsViewModel!!.getAllClientsFromOfflineDb()
    }

    private fun setRecyclerView(view: View){
        recyclerView = view.findViewById(R.id.rec_client_list)

        recyclerView.setHasFixedSize(true)

        manager = LinearLayoutManager(activity!!.applicationContext)
        adapter = AddClientAdapter()

        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }
}