package com.example.projectbaruapi

import com.google.gson.annotations.SerializedName

class ResultStaff (
    @field:SerializedName("pesan")
    var pesan : String?=null,

    @field:SerializedName("staff")
    val staff: List<DataItem>? = null,

    @field:SerializedName("status")
    val status: Int? = null
)