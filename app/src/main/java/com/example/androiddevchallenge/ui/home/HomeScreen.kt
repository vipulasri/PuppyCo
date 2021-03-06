/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R.drawable
import com.example.androiddevchallenge.data.model.Dog
import com.example.androiddevchallenge.ui.theme.secondaryColor

@Composable
fun HomeScreen(
    puppies: List<Dog>,
    navigateToPuppyDetails: (Dog) -> Unit
) {
    Scaffold(
        topBar = { AppBar() }
    ) {
        Surface(color = MaterialTheme.colors.background) {
            PuppyList(puppies, navigateToPuppyDetails)
        }
    }
}

@Composable
private fun AppBar() {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.surface,
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
                    colorFilter = ColorFilter.tint(secondaryColor),
                    modifier = Modifier
                        .size(18.dp)
                        .rotate(45f),
                )
            }
        }
    )
}
