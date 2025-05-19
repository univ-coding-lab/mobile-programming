package com.example.cweek11.example01

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class NewsViewModel : ViewModel() {

    private val _newsList = mutableStateListOf<NewsData>()
    val newsList = _newsList

    private val _isLoading = mutableStateOf(false)
    val isLoading = _isLoading

    fun fetchNews() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val fetchedNews = getNews()
                _newsList.clear()
                _newsList.addAll(fetchedNews)
            } catch (e: Exception) {
                Log.e("error", "fetch 관련 오류 발생", e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    private suspend fun getNews(): List<NewsData> = withContext(Dispatchers.IO) {
        val doc = Jsoup.connect("https://www.melon.com/chart/index.htm")
            .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/136.0.0.0 Safari/537.36")
            .referrer("https://www.google.com")
            .timeout(10000)
            .get()

//        Log.i("jsoup", doc.text())
//        Log.i("jsoup", doc.html())

        val rows = doc.select("div.service_list_song table tbody tr")
        rows.mapNotNull { tr ->
            val titleTag = tr.selectFirst("div.ellipsis.rank01 a")
            val artistTag = tr.selectFirst("div.ellipsis.rank02 a")

            val title = titleTag?.text()
            val artist = artistTag?.text()
            NewsData(title.toString(), artist.toString())
        }
    }
}
