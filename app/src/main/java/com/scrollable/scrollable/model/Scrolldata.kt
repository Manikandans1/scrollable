package com.scrollable.scrollable.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Scrolldata(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
