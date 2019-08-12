package jawoheer.example.myapplication

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.view.View
import android.widget.LinearLayout

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.bottomsheet_layout.*
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.activity_maps.*
import com.google.android.gms.maps.model.LatLngBounds
import kotlinx.android.synthetic.main.first_row.*


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var bottomSheetBehavior:BottomSheetBehavior<LinearLayout>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        bnt_back.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                onBackPressed()
            }
        })
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

       initializeBottomSheet()
    }

    private fun initializeBottomSheet() {
         bottomSheetBehavior= BottomSheetBehavior.from(bottom_sheet)

        bottomSheetBehavior.setBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback(){
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                transitionBottomSheetBackgroundColor(slideOffset)
            }

            override fun onStateChanged(p0: View, p1: Int) {

            }
        })
    }
    private fun transitionBottomSheetBackgroundColor(slideOffset: Float) {
        val colorFrom = ContextCompat.getColor(this, R.color.colorGrey)
        val colorTo = ContextCompat.getColor(this,R.color.colorGreyAlpha80)
        view_backcolor.setBackgroundColor(
            interpolateColor(slideOffset, colorFrom, colorTo
            ))
    }
    private fun interpolateColor(fraction: Float, startValue: Int, endValue: Int): Int {
        val startA = (startValue shr 24) and 0xff
        val startR = (startValue shr 16) and 0xff
        val startG = (startValue shr 8) and 0xff
        val startB = startValue and 0xff
        val endA = (endValue shr 24) and 0xff
        val endR = (endValue shr 16) and 0xff
        val endG = (endValue shr 8) and 0xff
        val endB = endValue and 0xff
        return startA + (fraction * (endA - startA)).toInt() shl 24 or
                (startR + (fraction * (endR - startR)).toInt() shl 16) or
                (startG + (fraction * (endG - startG)).toInt() shl 8) or
                startB + (fraction * (endB - startB)).toInt()
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val place1 = LatLng(41.275711, 69.222318)
        val place2=LatLng(41.326812, 69.233337)
        val marker=MarkerOptions().position(place1).draggable(true).title("Marker in Tashkent")
        mMap.addMarker(marker).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_pin_eta_main))
        mMap.addMarker(MarkerOptions().position(place2).title("Marker in Dest")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_pin_end))

        mMap.moveCamera(CameraUpdateFactory.newLatLng(place1))
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14.2f), 400, null);



    }

}
