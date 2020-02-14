package md.cadourionline.app.models

import com.google.gson.annotations.SerializedName

data class Catalog(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("image") val image: String,
    @SerializedName("sort") val sort: String
)