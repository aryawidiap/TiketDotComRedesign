package com.example.tiketdotcomredesign

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tiketdotcomredesign.data.Datasource
import com.example.tiketdotcomredesign.model.FlightTicket

@Composable
fun HomeScreen(
    onLogoutClick:() -> Unit
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar(Modifier)
        FlightTicketForm(modifier = Modifier)
//        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            Text(text = "Home Screen")
//        }
        Button(onClick = onLogoutClick) {
            Text(text = "Logout")
        }

    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
){
    val (search, setSearch) = rememberSaveable {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = search,
        onValueChange = setSearch,
        label = { Text(text = "Tiket kereta ke ...") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation()
    )
}

@Preview(showBackground=true)
@Composable
fun FlightTicketForm(
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(15.dp),
    ) {
        LazyColumn(modifier = modifier) {
            item {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "Cari Tiket Pesawat",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
            }
            item {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ){
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(end = 10.dp),

                        ) {
                            Row(
                                modifier = modifier
                                    .fillMaxWidth()
                            ){
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_flight_takeoff_24),
                                    contentDescription = "Localized description"
                                )
                                Text(
                                    text = "Taipei",
                                    modifier = Modifier,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Row(
                                modifier = modifier
                                    .fillMaxWidth()
                            ){
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_flight_land_24),
                                    contentDescription = "Localized description"
                                )
                                Text(
                                    text = "Denpasar-Bali",
                                    modifier = Modifier,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Filled.DateRange,
                            contentDescription = "Localized description"
                        )
                        Text(
                            text = "Kam, 27 Jun",
                            modifier = Modifier,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Localized description"
                        )
                        Text(
                            text = "1 penumpang, Ekonomi",
                            modifier = Modifier,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }
            }

//            Divider(color = Color.Blue, thickness = 1.dp)
//            Text(
//                text = "Tampilkan detail",
//                modifier = Modifier.padding(16.dp),
//                style = MaterialTheme.typography.labelLarge
//            )

        }
    }
//    Column {
//        Row {
//            Image(
//                painter = painterResource(
//                    id = R.drawable.google_logo
//                ),
//                contentDescription = "",
//                modifier = Modifier.size(200.dp)
//            )
//            Row {
//                Text(text = departureCity)
//                Text(text = "TPE")
//            }
//        }
//        Row {
//            Image(
//                painter = painterResource(
//                    id = R.drawable.google_logo
//                ),
//                contentDescription = "",
//                modifier = Modifier.size(200.dp)
//            )
//            Row {
//                Text(text = destinationCity)
//                Text(text = "TPE")
//            }
//        }
//    }
//
//    Column {
//        Row {
//            Image(
//                painter = painterResource(
//                    id = R.drawable.google_logo
//                ),
//                contentDescription = "",
//                modifier = Modifier.size(200.dp)
//            )
//            Row {
//                Text(text = departureCity)
//                Text(text = "TPE")
//            }
//        }
//        Row {
//            Image(
//                painter = painterResource(
//                    id = R.drawable.google_logo
//                ),
//                contentDescription = "",
//                modifier = Modifier.size(200.dp)
//            )
//            Row {
//                Text(text = destinationCity)
//                Text(text = "TPE")
//            }
//        }
//    }
}


