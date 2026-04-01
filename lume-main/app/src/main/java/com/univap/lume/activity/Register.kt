package com.univap.lume.activity

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.univap.lume.R
import com.univap.lume.model.UserModel

class Register : AppCompatActivity() {

    private lateinit var edt_nome_register: EditText
    private lateinit var edt_email_register: EditText
    private lateinit var edt_senha_register: EditText
    private lateinit var edt_confirmar_senha_register: EditText
    private lateinit var btn_register: Button
    private lateinit var txt_ir_login: TextView

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()

        edt_nome_register = findViewById(R.id.edt_nome_register)
        edt_email_register = findViewById(R.id.edt_email_register)
        edt_senha_register = findViewById(R.id.edt_senha_register)
        edt_confirmar_senha_register = findViewById(R.id.edt_confirmar_senha_register)
        btn_register = findViewById(R.id.btn_register)
        txt_ir_login = findViewById(R.id.txt_ir_login)

        btn_register.setOnClickListener {
            registrarUsuario()
        }
    }

    private fun registrarUsuario() {

        val nome = edt_nome_register.text.toString().trim()
        val email = edt_email_register.text.toString().trim()
        val senha = edt_senha_register.text.toString()
        val confirmar = edt_confirmar_senha_register.text.toString()

        // 🔥 Validações
        if (nome.isBlank()) {
            edt_nome_register.error = "Digite seu nome"
            edt_nome_register.requestFocus()
            return
        }

        if (email.isBlank() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edt_email_register.error = "Email inválido"
            edt_email_register.requestFocus()
            return
        }

        if (senha.length < 6) {
            edt_senha_register.error = "Senha deve ter no mínimo 6 caracteres"
            edt_senha_register.requestFocus()
            return
        }

        if (senha != confirmar) {
            edt_confirmar_senha_register.error = "As senhas não coincidem"
            edt_confirmar_senha_register.requestFocus()
            return
        }

        btn_register.isEnabled = false

        mAuth.createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener { task ->

                if (task.isSuccessful) {

                    val userFirebase = mAuth.currentUser

                    if (userFirebase != null) {

                        val user = UserModel(
                            id = userFirebase.uid,
                            nome = nome,
                            email = email
                        )

                        // 🔥 SALVANDO COM LOG (IMPORTANTE)
                        val ref = FirebaseDatabase.getInstance().reference

                        ref.child("usuarios")
                            .child(user.id)
                            .setValue(user)
                            .addOnSuccessListener {
                                Log.d("FIREBASE_DB", "Usuário salvo com sucesso")

                                Toast.makeText(
                                    this,
                                    "Cadastro realizado com sucesso!",
                                    Toast.LENGTH_SHORT
                                ).show()

                                finish()
                            }
                            .addOnFailureListener {
                                Log.e("FIREBASE_DB", "Erro ao salvar", it)

                                Toast.makeText(
                                    this,
                                    "Erro ao salvar no banco",
                                    Toast.LENGTH_LONG
                                ).show()
                            }

                    }

                } else {
                    btn_register.isEnabled = true
                    val erro = task.exception?.message ?: "Erro ao cadastrar"
                    Toast.makeText(this, erro, Toast.LENGTH_LONG).show()
                }
            }
    }
}