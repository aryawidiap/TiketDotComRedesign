package com.example.tiketdotcomredesign.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class FlightTicket(
    @StringRes val stringResourceId: Int,
    @StringRes val placeDepartureId: Int,
    @StringRes val placeDestinationId: Int,
    @StringRes val dateDepartureId: Int,
    @StringRes val dateDestinationId: Int,
    @StringRes val airlineId: Int,
    @StringRes val priceId: Int,
    @DrawableRes val imageResourceId: Int
)
