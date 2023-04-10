package com.example.model.network


import com.example.model.BreedItemUiModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BreedNetworkModel(
    @SerializedName("breed_group")
    @Expose
    val breedGroup: String?,
    @Expose
    val id: Int?,
    @SerializedName("image")
    @Expose
    val image: Image?,
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("origin")
    @Expose
    val origin: String?,
    @SerializedName("temperament")
    @Expose
    val temperament: String?
)

data class Image(
    @SerializedName("url")
    @Expose
    val url: String?
)

fun BreedNetworkModel.asUiModel() = BreedItemUiModel(
    id = id,
    breedGroup = breedGroup,
    imageUrl = image?.url ?: "",
    name = name,
    origin = origin,
    temperament = temperament,
    category = null
)
