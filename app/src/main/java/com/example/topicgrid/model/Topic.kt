package com.example.topicgrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResouurceId: Int,
    val coursesId: Int,
    @DrawableRes val imageResourceId: Int,

    )
