package com.example.tiketdotcomredesign

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tiketdotcomredesign.data.Datasource
import com.example.tiketdotcomredesign.model.FlightTicket
import kotlinx.coroutines.channels.ticker

@Composable
fun SearchFlightResultScreen (
    onLogoutClick:() -> Unit
){
    SearchFlightResultApp()
}

@Preview
@Composable
fun FlightTicketsListPreview() {
    FlightTicketList(flightTicketList = Datasource().loadFlightTickets(),)
}
@Composable
fun FlightTicketCard(
    flightTicket: FlightTicket,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
    ) {
        Column {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        top = 16.dp,
                        bottom = 2.dp,
                        start = 16.dp,
                        end = 16.dp
                    )
            ){
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(end = 10.dp)
                    ) {
                        Text(
                            text = LocalContext.current.getString(flightTicket.dateDepartureId),
                            modifier = Modifier,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = LocalContext.current.getString(flightTicket.placeDepartureId),
                            modifier = Modifier,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(end = 10.dp)
                    ) {
                        Text(
                            text = "12j 5m",
                            modifier = Modifier,
                            style = MaterialTheme.typography.titleSmall
                        )

                        Text(
                            text = "1 transit",
                            modifier = Modifier,
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(end = 10.dp)
                    ) {
                        Text(
                            text = LocalContext.current.getString(flightTicket.dateDestinationId),
                            modifier = Modifier,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = LocalContext.current.getString(flightTicket.placeDestinationId),
                            modifier = Modifier,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(start = 16.dp)
                    ) {
                        Text(
                            text = "Rp" + LocalContext.current.getString(flightTicket.priceId) + "/pax",
                            modifier = Modifier,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
                Row(modifier = modifier
                    .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = flightTicket.imageResourceId),
                        contentDescription = stringResource(id = flightTicket.stringResourceId),
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        text = LocalContext.current.getString(flightTicket.airlineId),
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
            Divider(color = Color.Blue, thickness = 1.dp)
            Text(
                text = "Tampilkan detail",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.labelLarge
            )

        }
    }
}
@Preview
@Composable
private fun FlightTicketCardPreview() {
    FlightTicketCard(flightTicket = FlightTicket(
        R.string.app_name,
        R.string.place_depart_name_1,
        R.string.place_dest_name_1,
        R.string.date_depart_name_1,
        R.string.date_dest_name_1,
        R.string.airline_1,
        R.string.price_1,
        R.drawable.login_img))
}


@Composable
fun FlightTicketList(
    flightTicketList: List<FlightTicket>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(flightTicketList) {flightTicket ->
            FlightTicketCard(
                flightTicket = flightTicket,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SearchFlightResultApp (
) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            painterResource(id = R.drawable.baseline_filter_alt_24),
                            contentDescription = "Localized description")
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            painterResource(id = R.drawable.baseline_sort_24),
                            contentDescription = "Localized description",
                        )
                    }

                },
            )
        },
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Column {
                        Text(
                            text = "Taipei ke Denpasar",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "1 penumpang - Ekonomi",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        FlightTicketList(
            modifier = Modifier.padding(innerPadding),
            flightTicketList = Datasource().loadFlightTickets()
        )
    }
}