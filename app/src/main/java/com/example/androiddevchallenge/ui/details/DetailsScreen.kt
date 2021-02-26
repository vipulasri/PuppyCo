package com.example.androiddevchallenge.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.data.model.Dog

@Composable
fun DetailsScreen(
  puppy: Dog,
  navigateBack: () -> Unit
) {
  Column {
    Text(text = "Hello")
  }
}