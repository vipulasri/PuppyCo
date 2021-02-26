package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.model.Dog
import com.example.androiddevchallenge.ui.components.StaggeredVerticalGrid
import com.example.androiddevchallenge.ui.theme.secondaryColorLight
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PuppyList(
  puppies: List<Dog>,
  navigateToPuppyDetails: (Dog) -> Unit
) {
  Column(
    modifier = Modifier
      .verticalScroll(rememberScrollState())
  ) {
    StaggeredVerticalGrid(
      maxColumnWidth = 250.dp,
      modifier = Modifier.padding(4.dp)
    ) {
      puppies.forEach { puppy ->
        PuppyGridItem(puppy = puppy, navigateToPuppyDetails)
      }
    }
  }
}

@Composable
private fun PuppyGridItem(
  puppy: Dog,
  navigateToPuppyDetails: (Dog) -> Unit
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 5.dp, horizontal = 10.dp)
      .clip(RoundedCornerShape(10.dp))
      .clickable {
        navigateToPuppyDetails.invoke(puppy)
      }
  ) {
    CoilImage(
      data = puppy.image.url,
      contentDescription = puppy.name,
      contentScale = ContentScale.Crop,
      fadeIn = true,
      modifier = Modifier
        .background(Color.LightGray)
        .aspectRatio(puppy.image.aspectRatio)
    )
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .background(secondaryColorLight)
        .padding(vertical = 10.dp, horizontal = 10.dp),
      verticalArrangement = Arrangement.SpaceEvenly
    ) {
      Text(
        text = puppy.name,
        style = MaterialTheme.typography.subtitle2
      )
      Text(
        text = puppy.breed,
        style = MaterialTheme.typography.body2
      )
      CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Text(
          text = "${puppy.sex.value}, ${puppy.ageString}",
          style = MaterialTheme.typography.caption
        )
      }
    }
  }
}