package com.amqo.databindingapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.amqo.databindingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel = ViewModelProviders.of(this)
            .get(MainViewModel::class.java)

        DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main).apply {
            this.setLifecycleOwner(this@MainActivity)
            this.viewModel = mainViewModel
        }

        mainViewModel.editTextContent.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}
