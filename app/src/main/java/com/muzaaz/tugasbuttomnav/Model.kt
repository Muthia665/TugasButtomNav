package com.muzaaz.tugasbuttomnav

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Model (
    var photo: Int,
    var title: String,
    var desc: String
) : Parcelable