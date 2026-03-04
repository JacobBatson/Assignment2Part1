//Jacob Batson
//Moe Alokla

package com.example.assignment2part1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment2part1.ui.theme.Assignment2Part1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment2Part1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MovieCard(
                        headerImage = painterResource(id = R.drawable.endgame),
                        smallerImage = painterResource(id = R.drawable.endgame),
                        title = "Avengers Endgame",
                        length = "3:01",
                        language = "Eng",
                        rating = 10.0,
                        review = "99+"
                    )
                }
            }
        }
    }
}

@Composable
fun MovieCard(
    headerImage: Painter,
    smallerImage: Painter,
    title: String,
    length: String,
    language: String,
    rating: Double,
    review: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFEDEDED)),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                Image(
                    painter = headerImage,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Image(
                    painter = smallerImage,
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 90.dp, height = 120.dp)
                        .align(Alignment.BottomStart)
                        .offset(x = 16.dp, y = 83.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp, start = 12.dp, end = 12.dp, bottom = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(106.dp))

                Column {
                    Text(
                        text = title,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "★★★★★",
                        fontSize = 20.sp,
                        color = Color(0xFFFFBF00)
                    )
                }
            }
            
            MovieDetails(
                length = length,
                language = language,
                rating = rating,
                review = review,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 12.dp)
            )
        }
    }
}

@Composable
fun MovieDetails(
    length: String,
    language: String,
    rating: Double,
    review: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        DetailColumn(label = "Length", value = length)
        DetailColumn(label = "Lang",   value = language)
        DetailColumn(label = "Rating", value = rating.toString())
        DetailColumn(label = "Review", value = review)
    }
}

@Composable
fun DetailColumn(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DemoScreen() {
    MovieCard(
        headerImage = painterResource(id = R.drawable.endgame),
        smallerImage = painterResource(id = R.drawable.endgame),
        title = "Avengers Endgame",
        length = "3:01",
        language = "Eng",
        rating = 10.0,
        review = "99+"
    )
}