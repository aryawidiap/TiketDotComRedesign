package com.example.tiketdotcomredesign.data

import com.example.tiketdotcomredesign.R
import com.example.tiketdotcomredesign.model.FlightTicket

class Datasource {
    fun loadFlightTickets(): List<FlightTicket> {
        return listOf<FlightTicket>(
            FlightTicket(
                R.string.app_name,
                R.string.place_depart_name_1,
                R.string.place_dest_name_1,
                R.string.date_depart_name_1,
                R.string.date_dest_name_1,
                R.string.airline_1,
                R.string.price_1,
                R.drawable.scoot_logo
            ),
            FlightTicket(
                R.string.app_name,
                R.string.place_depart_name_1,
                R.string.place_dest_name_1,
                R.string.date_depart_name_1,
                R.string.date_dest_name_1,
                R.string.airline_1,
                R.string.price_1,
                R.drawable.scoot_logo
            ),
            FlightTicket(
                R.string.app_name,
                R.string.place_depart_name_1,
                R.string.place_dest_name_1,
                R.string.date_depart_name_1,
                R.string.date_dest_name_1,
                R.string.airline_1,
                R.string.price_1,
                R.drawable.scoot_logo
            ),

        )
    }
}