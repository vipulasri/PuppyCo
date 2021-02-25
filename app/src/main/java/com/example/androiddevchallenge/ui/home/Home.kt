package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign.Center
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R.drawable
import com.example.androiddevchallenge.ui.theme.secondaryColorDark

@Composable
fun HomeScreen() {
  Scaffold(
    topBar = { AppBar() }
  ) {
    Surface(color = MaterialTheme.colors.background) {
      Text(
        text = "Adopt a friend".toUpperCase(),
        textAlign = Center,
        color = MaterialTheme.colors.onSecondary,
        style = MaterialTheme.typography.caption,
        modifier = Modifier
          .fillMaxWidth()
          .background(color = MaterialTheme.colors.secondary)
      )
    }
  }
}

@Composable
private fun AppBar() {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      text = "PuppyCo",
      style = MaterialTheme.typography.h5,
    )
    Spacer(modifier = Modifier.width(5.dp))
    Image(
      painter = painterResource(id = drawable.ic_paw),
      contentDescription = "Paw",
      modifier = Modifier
        .size(20.dp)
        .rotate(45f),
      colorFilter = ColorFilter.tint(secondaryColorDark)
    )
  }
}