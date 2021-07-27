package br.com.example.sociallearn.ui.signUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.example.sociallearn.R
import br.com.example.sociallearn.viewmodel.signUp.SignUpContract

class SignUpActivity : AppCompatActivity(), SignUpContract {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_register)
    }

    override fun goToMainActivity() {
        TODO("Not yet implemented")
    }

    override fun showGenericErrorMessage() {
        TODO("Not yet implemented")
    }
}