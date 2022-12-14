package com.dzak.belajardribble.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("result")
    val movies : List<Movies>
):Parcelable {
    constructor() : this(mutableListOf())
}
