package org.d3if3038.asessment1.ui.screen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3038.asessment1.R
import org.d3if3038.asessment1.navigation.Screen
import org.d3if3038.asessment1.ui.theme.Asessment1Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                actions = {
                    IconButton(onClick = {
                        navController.navigate(Screen.About.route)
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = stringResource(id = R.string.tentang_aplikasi),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        }
    ) { padding ->
        ScreenContent(Modifier.padding(padding))
    }
}

@SuppressLint("StringFormatMatches", "StringFormatInvalid")
@Composable
fun ScreenContent(modifier: Modifier) {
    var jumlah by rememberSaveable { mutableStateOf("") }
    var jumlahError by rememberSaveable { mutableStateOf(false) }

    // ------------------------------- Radio Options Vehicle List
    val radioOptions1 = listOf(
        stringResource(id = R.string.scoopy)
    )
    val radioOptions2 = listOf(
        stringResource(id = R.string.vario)
    )
    val radioOptions3 = listOf(
        stringResource(id = R.string.n_max)
    )
    val radioOptions4 = listOf(
        stringResource(id = R.string.beat)
    )

    // -------------------------------- Radio Options Time List
    val radioOptions = listOf(
        stringResource(id = R.string.time1),
        stringResource(id = R.string.time2),
        stringResource(id = R.string.time3),
        stringResource(id = R.string.time4),
        stringResource(id = R.string.time5)
    )
    var vehicleList by rememberSaveable { mutableStateOf(radioOptions1[0]) }
    var timeList by rememberSaveable { mutableStateOf(radioOptions[0]) }
    var totalHarga by rememberSaveable { mutableFloatStateOf(0f) }

    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.intro_irianaGarage),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = stringResource(id = R.string.head),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth()
        )
        Column (
            modifier = Modifier
                .padding(top = 8.dp)
        ) {
            Row {
                // PILIHAN KE 1
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.scoopy),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(180.dp)
                            .padding(16.dp)
                    )
                    Row(
                        Modifier.height(60.dp)
                    ) {
                        radioOptions1.forEach { text ->
                            VehicleOption(
                                label = text,
                                isSelected = vehicleList == text,
                                modifier = Modifier
                                    .selectable(
                                        selected = vehicleList == text,
                                        onClick = { vehicleList = text },
                                        role = Role.RadioButton
                                    )
                                    .padding(16.dp)
                            )
                        }
                    }
                }

                // PILIHAN KE 2
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.vario),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(180.dp)
                            .padding(16.dp)
                    )

                    Row(
                        Modifier.height(60.dp)
                    ) {
                        radioOptions2.forEach { text ->
                            VehicleOption(
                                label = text,
                                isSelected = vehicleList == text,
                                modifier = Modifier
                                    .selectable(
                                        selected = vehicleList == text,
                                        onClick = { vehicleList = text },
                                        role = Role.RadioButton
                                    )
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            }

            Row {
                // PILIHAN KE 3
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.nmax),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(180.dp)
                            .padding(16.dp)
                    )
                    Row(
                        Modifier.height(60.dp)
                    ) {
                        radioOptions3.forEach { text ->
                            VehicleOption(
                                label = text,
                                isSelected = vehicleList == text,
                                modifier = Modifier
                                    .selectable(
                                        selected = vehicleList == text,
                                        onClick = { vehicleList = text },
                                        role = Role.RadioButton
                                    )
                                    .padding(16.dp)
                            )
                        }
                    }
                }

                // PILIHAN KE 4
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.beat),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(180.dp)
                            .padding(16.dp)
                    )
                    Row(
                        Modifier.height(60.dp)
                    ) {
                        radioOptions4.forEach { text ->
                            VehicleOption(
                                label = text,
                                isSelected = vehicleList == text,
                                modifier = Modifier
                                    .selectable(
                                        selected = vehicleList == text,
                                        onClick = { vehicleList = text },
                                        role = Role.RadioButton
                                    )
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            }
        }

        // ---------------------------------- Radio Options Time List
        Column (
            modifier = Modifier
                .padding(top = 8.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(10.dp))
        ) {
            // Options 1
            Row {
                Column(
                    Modifier.weight(1f)
                ) {
                    radioOptions.forEach { text ->
                        TimeOption(
                            label = text,
                            isSelected = timeList == text,
                            modifier = Modifier
                                .selectable(
                                    selected = timeList == text,
                                    onClick = { timeList = text },
                                    role = Role.RadioButton
                                )
                                .padding(16.dp)
                        )
                    }
                }
            }
        }

        // -------------------- New method to calculate total price based on time selection
        fun hitungTotalHarga(jumlah: Float): Float {
            val basePrice = 40000f
            var timePriceModifier = 1.0f

            timePriceModifier = when (timeList) {
                radioOptions[0] -> 1f // 12 Jam
                radioOptions[1] -> 2f // 24 Jam
                radioOptions[2] -> 3f // 1-2 Hari
                radioOptions[3] -> 4f // 2-4 Hari
                radioOptions[4] -> 5f // 1 Minggu
                else -> timePriceModifier
            }

            return jumlah * basePrice * timePriceModifier
        }

        OutlinedTextField(
            value = jumlah,
            onValueChange ={ jumlah = it },
            label = { Text(text = stringResource(R.string.jumlah))},
            isError = jumlahError,
            trailingIcon = { IconPicker(jumlahError, "Pcs") },
            supportingText = { ErrorHint(jumlahError) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Row {
            Button(
                onClick = {
                    jumlahError = (jumlah == "" || jumlah == "0")
                    if (jumlahError) return@Button

                    totalHarga = hitungTotalHarga(jumlah.toFloat())
                },
                modifier = Modifier.padding(top = 8.dp),
                contentPadding =
                PaddingValues(
                    horizontal = 32.dp,
                    vertical = 16.dp
                )
            ) {
                Text(text = stringResource(id = R.string.hitung))
            }

            Spacer(Modifier.width(8.dp))

            Button(
                onClick = {
                    timeList = radioOptions[0]
                    jumlah = ""
                    totalHarga = 0f
                    jumlahError = false
                },
                modifier = Modifier
                    .padding(top = 8.dp),
                contentPadding =
                PaddingValues(
                    horizontal = 32.dp,
                    vertical = 16.dp
                )
            ) {
                Text(text = stringResource(id = R.string.setel_ulang))
            }
        }
        if (totalHarga != 0f) {
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp
            )
            Text(
                text = stringResource(id = R.string.total_harga, totalHarga),
                style = MaterialTheme.typography.titleLarge
            )

            Button(
                onClick = {
                    shareData(
                        context = context,
                        message = context.getString(R.string.bagikan_template,
                            jumlah, vehicleList, timeList, totalHarga
                        )
                    )
                },
                modifier = Modifier.padding(top = 8.dp),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)

            ) {
                Text(text = stringResource(id = R.string.bagikan))
            }

        }
    }
}

@Composable
fun VehicleOption(label: String, isSelected: Boolean, modifier: Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = isSelected, onClick = null)
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
@Composable
fun TimeOption(label: String, isSelected: Boolean, modifier: Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = isSelected, onClick = null)
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun IconPicker(isError: Boolean, unit: String) {
    if (isError) {
        Icon(imageVector = Icons.Filled.Warning, contentDescription = null)
    }else {
        Text(text = unit)
    }
}
@Composable
fun ErrorHint(isError: Boolean) {
    if (isError) {
        Text(text = stringResource(R.string.masukan_tidak_valid))
    }
}

@SuppressLint("QueryPermissionsNeeded")
private fun shareData(context: Context, message: String) {
    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, message)
    }
    if (shareIntent.resolveActivity(context.packageManager) != null) {
        context.startActivity(shareIntent)
    }
}
@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ScreenPreview() {
    Asessment1Theme {
        MainScreen(rememberNavController())
    }
}