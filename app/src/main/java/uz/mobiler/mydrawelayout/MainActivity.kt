package uz.mobiler.mydrawelayout


import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mindinventory.midrawer.MIDrawerView
import uz.mobiler.mydrawelayout.databinding.ActivityMainBinding
import uz.mobiler.mydrawelayout.databinding.CustomBottomSheetBinding


class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"
    private var slideType = 2
    lateinit var bottomSheetBehavior: BottomSheetBehavior<*>

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        drawerCustom()

        binding.toolbar.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        binding.drawerLayout.setMIDrawerListener(object : MIDrawerView.MIDrawerEvents {
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                Log.d(TAG, "onDrawerOpened: ")
            }

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
                Log.d(TAG, "onDrawerClosed: ")
            }
        })

        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.my_triple->{
                    val intent=Intent(this,MyTripsActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                R.id.pay->{
                    Toast.makeText(this, "PAY", Toast.LENGTH_SHORT).show()
                }
                R.id.other->{
                    Toast.makeText(this, "Other", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

        binding.slideMenu.setOnClickListener {
            //val bottomSheet = BottomSheetDialogFragment()

            BottomFragment().show(supportFragmentManager, "tag")
            //val inflate = CustomBottomSheetBinding.inflate(LayoutInflater.from(this), null, false)
            //bottomSheet.setContentView(inflate.root)
            //bottomSheet.show()
        }
    }

    private fun setupFullHeight(bottomSheet: View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT
        bottomSheet.layoutParams = layoutParams
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun drawerCustom() {
        binding.drawerLayout.setDrawerView(slideType)
        binding.navView.itemTextColor = getColorStateList(R.color.white)
        binding.navView.itemIconTintList = getColorStateList(R.color.white)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val polylineOptions = PolylineOptions()
        polylineOptions.add(LatLng(41.36677416391817, 69.29103089816346))
        polylineOptions.add(LatLng(41.366798863951, 69.29088659307361))
        polylineOptions.add(LatLng(41.36684256398611, 69.29058026121623))
        polylineOptions.add(LatLng(41.36688816399145, 69.29029165103657))
        polylineOptions.add(LatLng(41.36708766364477, 69.28907645029373))
        polylineOptions.add(LatLng(41.367156063383995, 69.28868404171885))
        polylineOptions.add(LatLng(41.36716176335994, 69.28842581156363))
        polylineOptions.add(LatLng(41.367251062904394, 69.28672199884589))
        polylineOptions.add(LatLng(41.367277662744385, 69.28620300685613))
        polylineOptions.add(LatLng(41.36719026322927, 69.28598275171899))
        polylineOptions.color(Color.RED)
        googleMap.addPolyline(polylineOptions)
        val mark1 = MarkerOptions().position(LatLng(41.36677416391817, 69.29103089816346))
        val mark2 = MarkerOptions().position(LatLng(41.36719026322927, 69.28598275171899))
        val mark3 = MarkerOptions().position(LatLng(41.367156063383995, 69.28868404171885))
        googleMap.addMarker(mark1)
        googleMap.addMarker(mark2)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mark3.position, 16f))
    }

}

