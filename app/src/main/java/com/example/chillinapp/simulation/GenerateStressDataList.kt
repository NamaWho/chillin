package com.example.chillinapp.simulation

import android.util.Log
import com.example.chillinapp.data.ServiceResult
import com.example.chillinapp.data.map.MapErrorType
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.heatmaps.WeightedLatLng
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.Date
import java.util.Random


fun simulateStressDataService(center: LatLng, radius: Double, date: Date): ServiceResult<List<WeightedLatLng>, MapErrorType> {
    Log.d("StressDataService (simulation)", "Generating stress data for $date")
    val response: ServiceResult<List<WeightedLatLng>, MapErrorType> =
        ServiceResult(
            success = true,
            data = generateStressDataList(center, radius),
            error = null
        )
    return response
}

private fun generateStressDataList(center: LatLng, radius: Double, numPoints: Int = 80): List<WeightedLatLng> {

    val stressDataList = mutableListOf<WeightedLatLng>()
    val random = Random()

    // Generate random stress data
    for (i in 0..numPoints) {
        val lat = BigDecimal(center.latitude + (random.nextGaussian() * radius)).setScale(3, RoundingMode.HALF_EVEN).toDouble()
        val lng = BigDecimal(center.longitude + (random.nextGaussian() * radius)).setScale(3, RoundingMode.HALF_EVEN).toDouble()
        val intensity = 1 + Math.random() * 20
        stressDataList.add(WeightedLatLng(LatLng(lat, lng), intensity))
    }

    Log.d("StressDataService (simulation)", "Generated stress data: $stressDataList")
    return stressDataList
}