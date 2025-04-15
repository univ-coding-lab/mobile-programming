package com.example.cweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cweek05a.model.ButtonType
import com.example.cweek05a.uiexamples2.ScrollToTopButton
import com.example.cweek05a.viewmodel.ImageViewModel
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    imageViewModel: ImageViewModel = viewModel()
) {
    val state = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val showButton by remember {
        derivedStateOf {
            state.firstVisibleItemIndex > 0
        }
    }
    val imageList = imageViewModel.imageList
    val orientation = LocalConfiguration.current.orientation
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        LazyColumn(
            state = state,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            itemsIndexed(imageList) { index, item ->
                when (item.buttonType) {
                    ButtonType.EMOJI -> {
                        ImageWithButton(image = item.image) {
                            ButtonWithEmoji(
                                likes = item.likes,
                                dislikes = item.dislikes,
                                onClickLikes = {
                                    imageList[index] = item.copy(likes = item.likes + 1)
                                },
                                onClickDisLikes = {
                                    imageList[index] = item.copy(dislikes = item.dislikes + 1)
                                }
                            )
                        }
                    }

                    ButtonType.ICON -> {
                        ImageWithButton(image = item.image) {
                            ButtonWithIcon(likes = item.likes) {
                                imageList[index] = item.copy(likes = item.likes + 1)
                            }
                        }
                    }

                    ButtonType.BADGE -> {
                        ImageWithButton(image = item.image) {
                            ButtonWithBadge(likes = item.likes) {
                                imageList[index] = item.copy(likes = item.likes + 1)
                            }
                        }
                    }
                }
            }
        }
        AnimatedVisibility(visible = showButton) {
            ScrollToTopButton {
                scope.launch {
                    state.scrollToItem(0)
                }
            }
        }
    } else {
        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImageList(imageList = imageList)
        }
    }

//    var img2State by rememberSaveable(stateSaver = ImagaData.imageSaver) {
//        mutableStateOf(
//            ImageData(
//                image =
//            )
//        )
//    }
//
//    Column(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        ImageWithButton(image = img2State.image) {
//            ButtonWithEmoji(likes = img2State.likes) {
//                img2State = img2State.copy(likes = img2State.likes + 1)
//            }
//        }
//    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}
