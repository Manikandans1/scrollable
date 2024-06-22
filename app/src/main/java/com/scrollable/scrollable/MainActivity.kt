package com.scrollable.scrollable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.scrollable.scrollable.Data.Dataresourse
import com.scrollable.scrollable.model.Scrolldata
import com.scrollable.scrollable.ui.theme.ScrollableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScrollableTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                        ScrollApp()
                }
            }
        }
    }
}
@Composable
fun ScrollApp() {
    ScrollableList(
        scrollableList = Dataresourse().loadscrolldata()
    )
}

@Composable
fun ScrollableList(scrollableList: List<Scrolldata>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(scrollableList) { scrolldata ->
            ScrollableCard(
                scrolldata = scrolldata,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}


@Composable
fun ScrollableCard(scrolldata: Scrolldata, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(scrolldata.imageResourceId),
                contentDescription = stringResource(scrolldata.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(scrolldata.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
private fun ScrollableCardPreview() {
    ScrollableCard(Scrolldata(R.string.scroll1, R.drawable.image1))
}
