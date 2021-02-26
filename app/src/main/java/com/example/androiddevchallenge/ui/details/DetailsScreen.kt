package com.example.androiddevchallenge.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.model.Dog
import com.example.androiddevchallenge.ui.theme.infoItemBg
import dev.chrisbanes.accompanist.coil.CoilImage
import java.util.Locale

@Composable
fun DetailsScreen(
  puppy: Dog,
  navigateBack: () -> Unit
) {
  Surface(color = MaterialTheme.colors.background) {
    Column(
      modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
      Header(puppy = puppy)
      Info(puppy = puppy)
    }

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
private fun Header(
  puppy: Dog
) {
  CoilImage(
    data = puppy.image.url,
    contentDescription = puppy.name,
    contentScale = ContentScale.Crop,
    fadeIn = true,
    modifier = Modifier
      .fillMaxWidth()
      .aspectRatio(1f)
      .background(
        Color.LightGray
      )
  )
}

@Composable
private fun Info(puppy: Dog) {
  Column(
    modifier = Modifier.padding(10.dp)
  ) {
    Text(
      text = "Puppy",
      style = MaterialTheme.typography.caption
    )

    Text(
      text = puppy.name,
      style = MaterialTheme.typography.h4
    )

    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
      Text(
        text = puppy.breed,
        style = MaterialTheme.typography.subtitle1
      )
    }

    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 30.dp)
        .horizontalScroll(rememberScrollState()),
      horizontalArrangement = Arrangement.SpaceEvenly
    ) {
      InfoItem(title = "Sex", value = puppy.sex.value)
      InfoItem(title = "Age", value = puppy.ageString)
      InfoItem(title = "Color", value = puppy.color)
      InfoItem(title = "Weight", value = "${puppy.weight} kg")
    }

    Text(
      text = "About",
      style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Medium)
    )
    Spacer(modifier = Modifier.height(5.dp))
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
      Text(
        text = puppy.description,
        style = MaterialTheme.typography.subtitle1
      )
    }

    Button(
      onClick = { },
      shape = RoundedCornerShape(20.dp),
      elevation = null,
      modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
        .defaultMinSize(minHeight = 50.dp)
    ) {
      Image(
        painter = painterResource(id = R.drawable.ic_paw),
        contentDescription = "Paw",
        modifier = Modifier.size(18.dp)
      )
      Spacer(modifier = Modifier.width(10.dp))
      Text(
        text = "Adopt Me".toUpperCase(Locale.getDefault())
      )
    }

  }
}

@Composable
private fun InfoItem(title: String, value: String) {
  Column(
    modifier = Modifier
      .defaultMinSize(
        minWidth = 80.dp
      )
      .background(
        color = infoItemBg,
        shape = RoundedCornerShape(10.dp)
      )
      .padding(10.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      text = title,
      color = MaterialTheme.colors.onPrimary,
      style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Medium)
    )
    Spacer(modifier = Modifier.height(5.dp))
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
      Text(
        text = value,
        color = MaterialTheme.colors.onPrimary,
        style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Normal)
      )
    }
  }
}