package com.example.Latihan6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

private val <ActivityMainBinding> ActivityMainBinding.root: Any
    get() {}

class MainActivity<ActivityMainBinding> : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val users = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val json = resources.openRawResource(R.raw.users)
            .bufferedReader().use { it.readText() }

        val type = object : TypeToken<List<User>>() {}.type
        val userList: List<User> = Gson().fromJson(json, type)

        users.addAll(userList)

        val binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val binding.recyclerView.adapter = UserAdapter(users)
    }
}
