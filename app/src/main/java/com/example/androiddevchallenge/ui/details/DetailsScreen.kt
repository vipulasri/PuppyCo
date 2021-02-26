package com.example.androiddevchallenge.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.model.Dog
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DetailsScreen(
  puppy: Dog,
  navigateBack: () -> Unit
) {
  Column(
    modifier = Modifier.verticalScroll(rememberScrollState())
  ) {
    Header(puppy = puppy, navigateBack)
    Info(puppy = puppy)
  }
}

@Composable
private fun Header(
  puppy: Dog,
  navigateBack: () -> Unit
) {
  Box {
    CoilImage(
      data = puppy.image.url,
      contentDescription = puppy.name,
      contentScale = ContentScale.Crop,
      fadeIn = true,
      modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(1f)
        .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)),
      loading = {
        Box(
          modifier = Modifier.background(
            Color.LightGray,
            shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
          )
        )
      }
    )

    IconButton(onClick = navigateBack) {
      Icon(
        imageVector = Icons.Filled.ArrowBack,
        contentDescription = "Back",
        tint = Color.White
      )
    }
  }
}

@Composable
private fun Info(puppy: Dog) {
  Column(
    modifier = Modifier.padding(10.dp)
  ) {
    Text(
      text = puppy.name,
      color = MaterialTheme.colors.onSurface,
      style = MaterialTheme.typography.h4
    )
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
      Text(
        text = puppy.breed,
        color = MaterialTheme.colors.onSurface,
        style = MaterialTheme.typography.subtitle1
      )
    }
  }
}