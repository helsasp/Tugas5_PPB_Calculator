package com.example.mycalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.background

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var num1 by remember { mutableStateOf(value = "0") }
            var num2 by remember { mutableStateOf(value = "0") }
            var result by remember { mutableStateOf("0") }

            val babyPurple = Color(0xFFE3D5FF)
            val lightBabyPurple = Color(0xFFF3ECFF)

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "My Calculator",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        value = num1,
                        onValueChange = { num1 = it },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = lightBabyPurple,
                            unfocusedContainerColor = lightBabyPurple
                        )
                    )
                    TextField(
                        value = num2,
                        onValueChange = { num2 = it },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = lightBabyPurple,
                            unfocusedContainerColor = lightBabyPurple
                        )
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Row {
                        Button(
                            onClick = { result = (num1.toInt() + num2.toInt()).toString() },
                            colors = ButtonDefaults.buttonColors(containerColor = babyPurple)
                        ) {
                            Text(text = "Add", color = Color.Black)
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            onClick = { result = (num1.toInt() - num2.toInt()).toString() },
                            colors = ButtonDefaults.buttonColors(containerColor = babyPurple)
                        ) {
                            Text(text = "Sub", color = Color.Black)
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            onClick = { result = (num1.toInt() * num2.toInt()).toString() },
                            colors = ButtonDefaults.buttonColors(containerColor = babyPurple)
                        ) {
                            Text(text = "Mul", color = Color.Black)
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            onClick = {
                                val denominator = num2.toIntOrNull()
                                val numerator = num1.toIntOrNull()
                                result = if (numerator != null && denominator != null) {
                                    if (denominator == 0) {
                                        "Cannot divided by 0"
                                    } else {
                                        (numerator / denominator).toString()
                                    }
                                } else {
                                    "Invalid input"
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = babyPurple)
                        ) {
                            Text(text = "Div", color = Color.Black)
                        }

                    }
                    Spacer(modifier = Modifier.height(32.dp))

                    Box(
                        modifier = Modifier
                            .width(100.dp)
                            .height(100.dp)
                            .background(babyPurple, shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = result,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Helsa Sriprameswari Putri (5025221154)",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
        }
    }
}
