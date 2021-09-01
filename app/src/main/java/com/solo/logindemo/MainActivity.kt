package com.solo.logindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils.isEmpty
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.solo.logindemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
       binding.login.setOnClickListener { login()  }
       binding.username.addTextChangedListener(
        object : TextWatcher{
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (s!!.isEmpty() ){
                    binding.login.isEnabled = false
                }
                loginButtonCheck()
            }

            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
               loginButtonCheck()
            }
        }
       )

      binding.password.addTextChangedListener( object : TextWatcher{
          override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

              if (s!!.isEmpty() ){
                  binding.login.isEnabled = false
              }
              loginButtonCheck()
          }

          override fun afterTextChanged(s: Editable?) {

          }

          override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

              loginButtonCheck()
          }
      })

    }

    private fun login() {
        startActivity(Intent(applicationContext,SecondActivity::class.java))
    }
    
     fun loginButtonCheck(){
        if (binding.username.text!!.isEmpty()) {
            binding.login.isEnabled = false
        }else if (binding.password.text!!.isEmpty()){
            binding.login.isEnabled = false
        }else{
            binding.login.isEnabled = true
        }

    }


}