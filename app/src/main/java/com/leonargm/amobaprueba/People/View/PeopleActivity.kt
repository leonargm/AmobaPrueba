package com.leonargm.amobaprueba.People.View

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.leonargm.amobaprueba.Login.View.LoginActivity
import com.leonargm.amobaprueba.People.Adapter.PeopleAdapter
import com.leonargm.amobaprueba.People.Impl.PeopleActivityPresenterImpl
import com.leonargm.amobaprueba.People.Interface.PeopleActivityView
import com.leonargm.amobaprueba.Profile.View.ProfileActivity
import com.leonargm.amobaprueba.R
import com.leonargm.amobaprueba.Utils.Constants
import com.leonargm.amobaprueba.databinding.ActivityPeopleBinding

class PeopleActivity : AppCompatActivity(), PeopleActivityView {

    private var _binding : ActivityPeopleBinding? = null
    private val binding get() = _binding!!

    private lateinit var firebaseAuth: FirebaseAuth
    private var presenter : PeopleActivityPresenterImpl
    private lateinit var mAdapter: PeopleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPeopleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.rvPeople.setLayoutManager(layoutManager)

        firebaseAuth = FirebaseAuth.getInstance()

        var firestore: FirebaseFirestore
        firestore = FirebaseFirestore.getInstance()
        firestore.collection("Personas")
            .get()
            .addOnSuccessListener {
                mAdapter = PeopleAdapter(it.documents)
                binding.rvPeople.adapter = mAdapter

                mAdapter.setOnClickListener(object :
                    PeopleAdapter.OnClickListener {
                    override fun onClick(position: Int, documents: DocumentSnapshot) {

                        val intent = Intent(applicationContext, ProfileActivity::class.java)
                        intent.putExtra("position", position)
                        startActivity(intent)
                    }
                })
            }
            .addOnFailureListener{
                it.printStackTrace()
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
    }

    init {
        presenter = PeopleActivityPresenterImpl(this)
        Constants.context = this
    }

    override fun onSuccess(data: Map<String, Any>?) {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onSuccessLogout(result: String) {
        val intent= Intent(this, LoginActivity::class.java)
        Toast.makeText(this,result, Toast.LENGTH_SHORT).show()
        startActivity(intent)
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                presenter.doLogout(this, firebaseAuth)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}