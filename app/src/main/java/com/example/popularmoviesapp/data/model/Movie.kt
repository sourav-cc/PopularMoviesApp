package com.example.popularmoviesapp.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    @SerializedName("id") var id: Int,
    @SerializedName("overview") var overview: String?,
    @SerializedName("poster_path") var posterPath: String?,
    @SerializedName("release_date") var releaseDate: String?,
    @SerializedName("title") var title: String?,
    @SerializedName("overview") var overView: String?,
    @SerializedName("vote_average") var vote: Int?,
) : Parcelable