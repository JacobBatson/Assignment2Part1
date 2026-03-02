package com.example.assignment2part1

import android.R.drawable
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment2part1.ui.theme.Assignment2Part1Theme
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment2Part1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageCard(
                        painterResource(id= R.drawable.endgame)
                    )
                }
            }
        }
    }
}



@Composable
fun ImageCard(headerImage: Painter,modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEDEDED)),
        contentAlignment = Alignment.TopCenter
    ){
        Image(
            painter = headerImage,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun MovieDetails(length: String, language: String, rating: Double, review: String, modifier: Modifier = Modifier){
    Row(
        modifier = Modifier
    ){
        Column(modifier = Modifier) {
            Text("Length", fontSize = 54.sp)
            Spacer(modifier = Modifier.padding(10.dp))
            Text(length, fontWeight = FontWeight.Bold, fontSize = 54.sp)
        }
        Column(modifier = Modifier) {
            Text("Lang", fontSize = 54.sp)
            Spacer(modifier = Modifier.padding(10.dp))
            Text(length, fontWeight = FontWeight.Bold, fontSize = 54.sp)
        }

        Column(modifier = Modifier) {
            Text("Rating", fontSize = 54.sp)
            Spacer(modifier = Modifier.padding(10.dp))
            Text(length, fontWeight = FontWeight.Bold, fontSize = 54.sp)
        }

        Column(modifier = Modifier) {
            Text("Review", fontSize = 54.sp)
            Spacer(modifier = Modifier.padding(10.dp))
            Text(length, fontWeight = FontWeight.Bold, fontSize = 54.sp)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DemoScreen(){
    ImageCardPreview()
    MovieDetailsPreview()
}

@Preview(showBackground = false)
@Composable
fun ImageCardPreview() {
    ImageCard(
        headerImage = painterResource(id = R.drawable.endgame)
    )
}

@Preview(showBackground = true)
@Composable
fun MovieDetailsPreview(){
    MovieDetails(length = "7.2", language = "foo", rating = 7.23, review = "34")
}