package com.example.bundle_savedinstancestate.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import com.example.bundle_savedinstancestate.databinding.ActivityMainBinding
import com.example.bundle_savedinstancestate.model.MyLiveData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myLiveData: MyLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myLiveData = MyLiveData()
        initView()
    }

    private fun initView() {
        myLiveData.get().observe(this, Observer {
            binding.tv.text = it
        })

        binding.et.addTextChangedListener {
            myLiveData.set(it.toString())
        }

//        binding.btn.setOnClickListener {
//            val text = binding.et.text.toString().trim()
//            myLiveData.set(text)
//        }
    }
}