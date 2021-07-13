package com.cletus.personapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.isaac.personapp.data.Contact
import com.isaac.personapp.data.ContactAdapter
import com.isaac.personapp.data.ContactDatabase
import com.isaac.personapp.databinding.ActivityMainBinding
import com.isaac.personapp.viewmodel.ContactViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var contactAdapter: ContactAdapter
    private lateinit var database: ContactDatabase
    private lateinit var contactViewModel: ContactViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        database = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java,
            "contact_database"
        ).allowMainThreadQueries().build()


        contactViewModel = ViewModelProvider(this)[ContactViewModel::class.java]
        contactViewModel.getContacts(database)


        contactAdapter = ContactAdapter(listOf<Contact>()) {
            binding.run {
                val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                    .putExtra("name", it.name)
                    .putExtra("surname", it.surname)
                    .putExtra("phonenumber", it.phonenumber)
                startActivity(intent)
            }

        }
        binding.contactRecycler.adapter = contactAdapter
        binding.contactRecycler.layoutManager = LinearLayoutManager(this@MainActivity)

        binding.newContactBtn.setOnClickListener {
            val intent = Intent(this, AddContact::class.java)
            startActivity(intent)
        }


        contactViewModel.contactLiveData.observe(this, { contact ->
            contactAdapter.personList = contact
            contactAdapter.notifyDataSetChanged()
        })


}}