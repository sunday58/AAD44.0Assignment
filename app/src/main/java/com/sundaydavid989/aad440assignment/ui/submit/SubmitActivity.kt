package com.sundaydavid989.aad440assignment.ui.submit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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

        goBack()
        setContentView(view)
    }

    private fun goBack(){
        binding.goBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun submit(firstName: String, lastName: String, email: String, linkToGithub: String){
        val retrofit = SubmitApiService.ServiceBuilder
            .buildService(SubmitApiService::class.java)
        retrofit.submitAssignment(firstName, lastName, email, linkToGithub).enqueue(
            object : Callback<Void>{
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                     val submitForm = response.body()

                }
            }
        )
    }

}