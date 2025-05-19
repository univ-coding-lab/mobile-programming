package com.example.cweek11.example01

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class NewsData(
    var title: String,
    var newsUrl: String
)

@Composable
fun NewsItem(news: NewsData) {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Text(news.title, fontSize = 20.sp)
        Text(news.newsUrl, fontSize = 15.sp)
    }
}

@Composable
fun NewsList(list: List<NewsData>) {
    LazyColumn {
        items(list) { item ->
            NewsItem(item)
            HorizontalDivider(color = Color.Black, thickness = 1.dp)
        }
    }
}
