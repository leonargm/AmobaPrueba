package com.leonargm.amobaprueba.Profile.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.leonargm.amobaprueba.Profile.Impl.ProfileActivityPresenterImpl
import com.leonargm.amobaprueba.Profile.Interface.ProfileActivityView
import com.leonargm.amobaprueba.databinding.ActivityProfileBinding
import com.squareup.picasso.Picasso

class ProfileActivity : AppCompatActivity(), ProfileActivityView {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private var presenter : ProfileActivityPresenterImpl
    var position : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        position = intent.getIntExtra("position", 0)
        firebaseAuth = FirebaseAuth.getInstance()

        var firestore: FirebaseFirestore
        firestore = FirebaseFirestore.getInstance()

        presenter.showInfoPeople(firestore)

    }

    init {
        presenter = ProfileActivityPresenterImpl(this)
    }

    override fun onSuccess(documents: MutableList<DocumentSnapshot>) {

        Picasso.get().load(documents.get(position).data?.get("imagen").toString()).into(binding.ivProfile)
        binding.tvName.setText(documents.get(position).data?.get("nombre").toString())
        binding.tvEmail.setText(documents.get(position).data?.get("correo").toString())
        binding.tvCI.setText("C.I.: " + documents.get(position).data?.get("CI").toString())
        binding.tvAge.setText("Edad: " + documents.get(position).data?.get("edad").toString() + " Años")
        binding.tvGender.setText("Sexo: " + documents.get(position).data?.get("genero").toString())
        binding.tvMap.setOnClickListener{
            Toast.makeText(this, "Ver Mapa", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onFail(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }
}