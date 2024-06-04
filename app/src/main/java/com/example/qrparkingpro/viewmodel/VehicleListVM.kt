package com.example.qrparkingpro.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.qrparkingpro.model.Vehicle
import com.example.qrparkingpro.model.VehicleType

class VehicleListVM : ViewModel() {
    var vehicles by mutableStateOf(
        listOf(
            Vehicle("1", VehicleType.CAR),
            Vehicle("2", VehicleType.MOTORCYCLE),
        )
    )

    fun addVehicle(vehicle: Vehicle) {
        vehicles = vehicles + vehicle
    }

    fun removeVehicle(vehicle: Vehicle) {
        vehicles = vehicles - vehicle
    }
}