package com.sundaydavid989.aad440assignment.ui.submit

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.sundaydavid989.aad440assignment.MainActivity
import com.sundaydavid989.aad440assignment.R
import com.sundaydavid989.aad440assignment.data.network.SubmitApiService
import com.sundaydavid989.aad440assignment.databinding.ActivitySubmitBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubmitActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubmitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubmitBinding.inflate(layoutInflater)
        val view = binding.root

        sendSubmit()
        goBack()
        setContentView(view)
    }

    private fun goBack(){
        binding.goBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun sendSubmit(){
        binding.submit.setOnClickListener {
          val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.fragment_submit_dialog)
            val yesBtn = dialog.findViewById<MaterialButton>(R.id.confirmSubmit)
            val noBtn = dialog.findViewById<ImageView>(R.id.cancelSubmit)
            yesBtn.setOnClickListener {
                getData()
                Toast.makeText(applicationContext, "Submitting", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            noBtn.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
            val window = dialog.window
            window!!.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        }
    }

    private fun submit(firstName: String, lastName: String, email: String, linkToGithub: String){
        val retrofit = SubmitApiService
            .buildService(SubmitApiService::class.java)
        retrofit.submitAssignment(firstName, lastName, email, linkToGithub).enqueue(
            object : Callback<Void>{
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    failureDialog()
                }

                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful){
                        successDialog()
                    }else{
                        failureDialog()
                    }
                }
            }
        )
    }

    private fun getData(){
        val firstName = binding.firstName.text.toString()
        val lastName = binding.lastName.text.toString()
        val email = binding.email.text.toString()
        val github = binding.github.text.toString()

        if (!email.isEmailValid()){
            toastMessage("Email not valid")
        }
        if (firstName.isEmpty()
            || lastName.isEmpty()
            || github.isEmpty()){
            toastMessage("items can not be empty")
        }
        else {
            submit(firstName, lastName, email, github)
        }
    }

    private fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this)
                && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    private fun failureDialog(){
        val dialog = AlertDialog.Builder(this)
        dialog.setView(R.layout.unsuccessful_dialog)
        dialog.show()
    }

    private fun successDialog(){
        val dialog = AlertDialog.Builder(this)
        dialog.setView(R.layout.successful_dialog)
        dialog.show()
    }

    private fun toastMessage(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

}