package md.cadourionline.app.models

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("image") val image: String,
    @SerializedName("price") val price: String,
    @SerializedName("time") val time: Long? = null,
    @SerializedName("sale") val sale: String? = null,
    @SerializedName("oldprice") val oldPrice: String? = null
)