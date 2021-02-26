package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.androiddevchallenge.data.repository.PuppyRepository
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PuppyList() {
  LazyColumn {
    itemsIndexed(PuppyRepository.puppies) { index, puppy ->

      // extra top spacing
      if (index == 0) {
        Spacer(modifier = Modifier.padding(top = 10.dp))
      }

      PuppyListItem(puppy = puppy)

      // extra bottom spacing
      if (index == PuppyRepository.puppies.size.minus(1)) {
        Spacer(modifier = Modifier.padding(top = 10.dp))
      }
    }
  }
}

@Composable
private fun PuppyListItem(puppy: Dog) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 5.dp, horizontal = 10.dp)
      .background(
        color = Color.LightGray.copy(alpha = 0.2f),
        shape = RoundedCornerShape(10.dp)
      )
      .padding(10.dp)
  ) {
    CoilImage(
      data = puppy.image,
      contentDescription = puppy.name,
      contentScale = ContentScale.Crop,
      fadeIn = true,
      modifier = Modifier
        .size(80.dp)
        .clip(RoundedCornerShape(10.dp))
    )
    Spacer(modifier = Modifier.width(10.dp))
    Column(
      verticalArrangement = Arrangement.SpaceEvenly
    ) {
      Text(
        text = puppy.name,
        style = MaterialTheme.typography.h6
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