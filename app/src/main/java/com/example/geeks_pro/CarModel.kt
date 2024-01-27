package com.example.geeks_pro

import java.io.Serializable

data class CarModel(
    val image:String ?= null,
    val name:String ?= null,
    val year:String ?= null,
):Serializable
