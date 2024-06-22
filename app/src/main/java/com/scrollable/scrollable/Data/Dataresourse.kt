package com.scrollable.scrollable.Data

import com.scrollable.scrollable.R
import com.scrollable.scrollable.model.Scrolldata

class Dataresourse() {
    fun loadscrolldata(): List<Scrolldata> {
        return listOf<Scrolldata>(
            Scrolldata(R.string.scroll1, R.drawable.image1),
            Scrolldata(R.string.scroll2, R.drawable.image2),
            Scrolldata(R.string.scroll3, R.drawable.image3),
            Scrolldata(R.string.scroll4, R.drawable.image4),)
    }
}