package com.example.qrparkingpro.model

enum class VehicleType {
    CAR,
    MOTORCYCLE
}

data class Vehicle(
    val plateNumber: String,
    val type: VehicleType
)
