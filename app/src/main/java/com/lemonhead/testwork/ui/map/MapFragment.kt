package com.lemonhead.testwork.ui.map

import android.os.Bundle
import android.view.View
import com.lemonhead.testwork.R
import com.lemonhead.testwork.model.MarkViewModel
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.IconStyle
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MapFragment : MvpAppCompatFragment(R.layout.fragment_map),
    com.lemonhead.testwork.ui.map.MapView {

    private lateinit var mapView: MapView

    private val presenter by moxyPresenter { MapPresenter() }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MapKitFactory.initialize(requireContext())

        mapView = view.findViewById(R.id.mapView)
        mapView.map.move(
            CameraPosition(
                Point(0.toDouble(), 0.toDouble()), 0.0f, 0.0f, 0.0f
            ),
            Animation(Animation.Type.SMOOTH, 0.0f),
            null
        )
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onShowMarks(marks: List<MarkViewModel>) {
        mapView.map.mapObjects.addPlacemarks(
            marks.map { it.toPoint() },
            ImageProvider.fromResource(requireContext(), android.R.drawable.btn_star),
            IconStyle()
        )
    }

    companion object {
        const val TAG = "MapFragment"
    }
}