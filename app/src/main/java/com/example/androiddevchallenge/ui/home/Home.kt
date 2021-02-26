package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R.drawable

@Composable
fun HomeScreen() {
  Scaffold(
    topBar = { AppBar() }
  ) {
    Surface(color = MaterialTheme.colors.background) {
      PuppyList()
    }
  }
}

@Composable
private fun AppBar() {
  TopAppBar(
    backgroundColor = MaterialTheme.colors.primary,
    title = {
      Row(
        modifier = Modifier
          .fillMaxWidth(),
      ) {

        ProvideTextStyle(value = MaterialTheme.typography.h6) {
          CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.high,
            content = {
              Text(
                text = "PuppyCo"
              )
            }
          )
        }

        Spacer(modifier = Modifier.width(5.dp))
        Image(
          painter = painterResource(id = drawable.ic_paw),
          contentDescription = "Paw",
          modifier = Modifier
            .size(16.dp)
            .rotate(45f),
        )
      }
    }
  )
}