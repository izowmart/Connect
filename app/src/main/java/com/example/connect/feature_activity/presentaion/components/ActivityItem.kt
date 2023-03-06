package com.example.connect.feature_activity.presentaion.components

@Composable
fun ActivityItem(
    activity: Activity,
    onNavigate: (String) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.onSurface,
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceSmall),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val fillerText = when (activity.activityType) {
                is ActivityType.LikedPost ->
                    stringResource(id = R.string.liked)
                is ActivityType.CommentedOnPost ->
                    stringResource(id = R.string.commented_on)
                is ActivityType.FollowedUser ->
                    stringResource(id = R.string.followed_you)
                is ActivityType.LikedComment -> {
                    stringResource(id = R.string.liked)
                }
            }
            val actionText = when (activity.activityType) {
                is ActivityType.LikedPost ->
                    stringResource(id = R.string.your_post)
                is ActivityType.CommentedOnPost ->
                    stringResource(id = R.string.your_post)
                is ActivityType.FollowedUser -> ""
                is ActivityType.LikedComment -> {
                    stringResource(id = R.string.your_comment)
                }
            }
            val annotatedText = buildAnnotatedString {
                val boldStyle = SpanStyle(fontWeight = FontWeight.Bold)
                pushStringAnnotation(
                    tag = "username",
                    annotation = "username"
                )
                withStyle(boldStyle) {
                    append(activity.username)
                }
                pop()
                append(" $fillerText ")

                pushStringAnnotation(
                    tag = "parent",
                    annotation = "parent"
                )
                withStyle(boldStyle) {
                    append(actionText)
                }
            }
            ClickableText(
                text = annotatedText,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = MaterialTheme.colors.onBackground
                ),
                onClick = { offset ->
                    annotatedText.getStringAnnotations(
                        tag = "username",// tag which you used in the buildAnnotatedString
                        start = offset,
                        end = offset
                    ).firstOrNull()?.let { annotation ->
                        // Clicked on user
                        onNavigate(
                            Screen.ProfileScreen.route + "?userId=${activity.userId}"
                        )
                    }
                    annotatedText.getStringAnnotations(
                        tag = "parent",// tag which you used in the buildAnnotatedString
                        start = offset,
                        end = offset
                    ).firstOrNull()?.let { annotation ->
                        // Clicked on parent
                        onNavigate(
                            Screen.PostDetailScreen.route + "/${activity.parentId}"
                        )
                    }
                }
            )
            Text(
                text = activity.formattedTime,
                textAlign = TextAlign.Right,
                fontSize = 12.sp,
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}