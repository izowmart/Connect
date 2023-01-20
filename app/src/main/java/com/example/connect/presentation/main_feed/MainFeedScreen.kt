package com.example.connect.presentation.main_feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.connect.R
import com.example.connect.presentation.components.Post
import com.example.connect.presentation.components.StandardToolbar
import com.example.connect.presentation.util.Screen

@Composable
fun MainFeedScreen(
    navController: NavController
) {

    Column(modifier = Modifier) {
        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(id = R.string.your_feed),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = true,
            navActions = {
                IconButton(onClick = {
                    navController.navigate(Screen.SearchScreen.route)
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = MaterialTheme.colors.onBackground
                    )
                }
            }
        )
        Post(
            post = com.example.connect.domain.models.Post(
                username = "Philipp Lackner",
                imageUrl = "",
                profilePictureUrl = "",
                description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed\n" +
                        "diam nonumy eirmod tempor invidunt ut labore et dolore \n" +
                        "magna aliquyam erat, sed diam voluptua...",
                likeCount = 17,
                commentCount = 7
            ),
            onPostClick = {
                navController.navigate(Screen.PostDetailScreen.route)
            }
        )
    }
}