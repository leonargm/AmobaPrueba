package com.leonargm.amobaprueba.Login.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.leonargm.amobaprueba.databinding.ActivityLoginBinding
import android.widget.Toast
import android.content.Intent
import com.leonargm.amobaprueba.Login.Impl.LoginActivityPresenterImpl
import com.leonargm.amobaprueba.Login.Interface.LoginActivityView
import com.leonargm.amobaprueba.People.View.PeopleActivity
import com.leonargm.amobaprueba.Utils.Constants

class LoginActivity : AppCompatActivity(), LoginActivityView {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private var presenter: LoginActivityPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Constants.context = this
        firebaseAuth = FirebaseAuth.getInstance()
        binding.tvRecPass.setOnClickListener {

        }
        binding.btnLogin.setOnClickListener {
            presenter.doLogin(binding.emailEt.text.toString(), binding.passET.text.toString(), firebaseAuth)
        }
    }

    init {
        presenter = LoginActivityPresenterImpl(this)
    }
    override fun onSuccess(result: String) {
        val intent = Intent(this, PeopleActivity::class.java)
        startActivity(intent)
    }
    override fun onFail(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }
    override fun onStart() {
        super.onStart()
        if(firebaseAuth.currentUser != null){
            val intent = Intent(this, PeopleActivity::class.java)
            startActivity(intent)
        }
    }
}