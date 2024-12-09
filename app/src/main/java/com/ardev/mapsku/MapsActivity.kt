package com.ardev.mapsku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ardev.mapsku.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)

        val text = "Halo $name"
        binding.tvName.text = text

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val panlos = LatLng(-5.14376728128904, 119.40066250107434)
        val fikom = LatLng(-5.136101027682696, 119.44888204653081)
        mMap.addMarker(MarkerOptions().position(fikom).title("Ini adalah FIKOM"))
        mMap.addMarker(MarkerOptions().position(panlos).title("Pantai Losari"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fikom, 15f))
    }

    companion object{
        const val EXTRA_NAME = "extra_name"
    }
}