package com.leonargm.amobaprueba.Profile.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.leonargm.amobaprueba.Login.View.LoginActivity
import com.leonargm.amobaprueba.Profile.Impl.ProfileActivityPresenterImpl
import com.leonargm.amobaprueba.Profile.Interface.ProfileActivityView
import com.leonargm.amobaprueba.databinding.ActivityProfileBinding
import com.squareup.picasso.Picasso

class ProfileActivity : AppCompatActivity(), ProfileActivityView {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private var presenter : ProfileActivityPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val position = intent.getIntExtra("position", 0)
        firebaseAuth = FirebaseAuth.getInstance()

        var firestore: FirebaseFirestore
        firestore = FirebaseFirestore.getInstance()
        firestore.collection("Personas")
            .get()
            .addOnSuccessListener {
                val profile: ArrayList<String> = ArrayList()
                Picasso.get().load(it.documents.get(position).data?.get("imagen").toString()).into(binding.ivProfile)
                binding.tvName.setText(it.documents.get(position).data?.get("nombre").toString())
                binding.tvEmail.setText(it.documents.get(position).data?.get("correo").toString())
                binding.tvCI.setText("C.I.: " + it.documents.get(position).data?.get("CI").toString())
                binding.tvAge.setText("Edad: " + it.documents.get(position).data?.get("edad").toString() + " Años")
                binding.tvGender.setText("Sexo: " + it.documents.get(position).data?.get("genero").toString())
            }
            .addOnFailureListener{
                it.printStackTrace()
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
    }

    init {
        presenter = ProfileActivityPresenterImpl(this)
    }

    override fun onSuccess(result: String) {
        val intent= Intent(this, LoginActivity::class.java)
        Toast.makeText(this,result, Toast.LENGTH_SHORT).show()
        startActivity(intent)
        finish()
    }
}