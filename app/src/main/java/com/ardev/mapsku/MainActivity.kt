package com.ardev.mapsku

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ardev.mapsku.databinding.ActivityMainBinding
import com.ardev.mapsku.databinding.ActivityMapsBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnEnter.setOnClickListener {
            val pindahKeMapsActName = Intent(this@MainActivity, MapsActivity::class.java)
            pindahKeMapsActName.putExtra(MapsActivity.EXTRA_NAME, binding.etName.text.toString())
            startActivity(pindahKeMapsActName)
        }
    }
}