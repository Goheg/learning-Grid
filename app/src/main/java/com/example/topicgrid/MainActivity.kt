package com.example.topicgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.DefaultMarqueeSpacing
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.topicgrid.data.datasource
import com.example.topicgrid.model.Topic
import com.example.topicgrid.ui.theme.TopicGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TopicGridTheme {
               Surface(
                    modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colorScheme.background
               ){
                   TopicGridApp()
               }
            }
        }
    }
}

@Composable
fun TopicGridApp(){
    Surface(
        modifier = Modifier
            .statusBarsPadding()
    ) {
        TopicList(topicList = datasource().loadTopics())
    }

}


@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .height(68.dp)
    ) {
        Row(modifier = modifier) {
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription =  stringResource(topic.stringResouurceId),
                modifier = Modifier
                    .fillMaxHeight()
                    .width(68.dp)
            )

            Column(
                modifier = Modifier
            ) {
                Text(
                    text = stringResource(topic.stringResouurceId),
                    modifier = Modifier
                        .padding(16.dp,16.dp,16.dp,0.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text= topic.coursesId.toString(),
                    modifier = Modifier
                        .padding(16.dp,0.dp,0.dp,0.dp),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

@Composable
fun TopicList(topicList: List<Topic>, modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
        items(topicList){ topic ->
                TopicCard(
                    topic = topic
                )
        }
    }
}

@Preview
@Composable

fun TopicCardPreview(){
    TopicGridApp()
}

