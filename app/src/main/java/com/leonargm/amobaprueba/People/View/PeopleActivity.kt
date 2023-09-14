package com.leonargm.amobaprueba.People.View

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.leonargm.amobaprueba.People.Adapter.PeopleAdapter
import com.leonargm.amobaprueba.People.Impl.PeopleActivityPresenterImpl
import com.leonargm.amobaprueba.People.Interface.PeopleActivityView
import com.leonargm.amobaprueba.Profile.View.ProfileActivity
import com.leonargm.amobaprueba.databinding.ActivityPeopleBinding

class PeopleActivity : AppCompatActivity(), PeopleActivityView {

    private lateinit var binding: ActivityPeopleBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private var presenter : PeopleActivityPresenterImpl
    private var PeopleAdapter: PeopleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPeopleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        var firestore: FirebaseFirestore
        firestore = FirebaseFirestore.getInstance()
        firestore.collection("Personas")
            .get()
            .addOnSuccessListener {
                val people: ArrayList<String> = ArrayList()
                PeopleAdapter.PeopleAdapter(binding,it.documents)
                binding.lvPeople.setOnItemClickListener { parent, view, position, id ->
                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.putExtra("position", position)
                    startActivity(intent)
                }
            }
            .addOnFailureListener{
                it.printStackTrace()
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
    }

    init {
        presenter = PeopleActivityPresenterImpl(this)
        PeopleAdapter = PeopleAdapter(this)
    }

    override fun onSuccess(data: Map<String, Any>?) {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
        finish()
    }
}