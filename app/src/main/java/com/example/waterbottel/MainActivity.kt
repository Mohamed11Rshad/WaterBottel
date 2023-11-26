package com.example.waterbottel

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.waterbottel.ui.theme.WaterBottle
import com.example.waterbottel.ui.theme.WaterBottelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaterBottelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    var usedAmount by remember { mutableStateOf(0) }

                    val totalAmount = remember { 2000 }

                    Column(modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        WaterBottle(totalWaterAmount = totalAmount, unit ="ml" , usedWaterAmount = usedAmount)
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "Total amount is : $$totalAmount")
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(
                            onClick = {
                                if (usedAmount < totalAmount) {
                                    usedAmount += 400
                                }
                                else
                                Toast.makeText(this@MainActivity, "You have reached your daily limit", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xff279eff)
                            )
                        ) {
                            Text(text = "Drink")

                        }
                    }

                }
            }
        }
    }
}

