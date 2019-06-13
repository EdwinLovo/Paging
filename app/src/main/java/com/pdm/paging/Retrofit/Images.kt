package com.pdm.paging.Retrofit

import com.pdm.paging.Room.Entities.Image
import com.squareup.moshi.Json

data class Images(

        @field:Json(name = "image")
        val image:List<Image>
)