package com.example.appjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appjetpackcompose.ui.theme.AppJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                topBar()
                secBar()
                thirdBar()
                MoviesSection(section = "Watch it Later")
                MoviesSection(section = "Drama Movies")
                MoviesSection(section = "Action Movies")
                MoviesSection(section = "New Release")
                MoviesSection(section = "Rommantic")
                MoviesSection(section = "Sci-Fi")
                MoviesSection(section = "Horror")
                MoviesSection(section = "Mystry")

            }

        }
    }
}

@Composable
@Preview
fun topBar() {
    Row(
        modifier= Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .padding(6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically


    ){
        Image(
            painter = painterResource(id = R.drawable.ic_netflix),
            contentDescription ="netflix Logo",
            modifier=Modifier.height(50.dp)



        )
        Row{
            Image(painter = painterResource(id = R.drawable.ic_search),
                contentDescription ="Search_icon",
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 12.dp)
                )
            Image(painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "Profile_icon",
                modifier = Modifier
                    .size(45.dp)
                    .padding(end = 6.dp)
            )
        }
    }
}


@Composable
fun secBar(){
    Row(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .height(28.dp)
            .padding(top = 10.dp, start = 35.dp, end = 35.dp)
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(text = "TV Shows",
            color =Color.LightGray,
            fontSize = 15.sp

        )
        Text(text = "Movies",
                color =Color.LightGray,
            fontSize = 15.sp
        )
        Row(
            modifier = Modifier
        ) {
            Text(text = "Caterogies",
                color =Color.LightGray,
                fontSize = 15.sp
            )
            Image(painter = painterResource(id = R.drawable.ic_down), contentDescription = "drop down icon")
        }

    }
}

@Composable
fun thirdBar(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        
    ) {
        Image(painter = painterResource(id = R.drawable.series),
            contentDescription ="Series Image",
            modifier = Modifier.size(370.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, start = 40.dp, end = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(text = "Adventure",color=Color.White)
            Text(text = "Fiction",color=Color.White)
            Text(text = "Fantasy",color=Color.White)


        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 60.dp, end = 60.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {


            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.plus),
                    contentDescription = "plus icon",
                    modifier = Modifier.size(20.dp)
                    )
                Text(text = "My List",color =Color.White)

            }


            Button(onClick = {  },
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(text = "Play",color =Color.Black, fontWeight = FontWeight.ExtraBold)

            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.info),
                    contentDescription = "plus icon",
                    modifier = Modifier.size(22.dp)
                )
                Text(text = "Info",color =Color.White)

            }



        }


    }
}
@Composable
fun MoviesSection(section:String){

    Column(
        modifier=Modifier.padding(top = 18.dp)
    ) {
        Text(text = section,
            color = Color.White, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp,
            modifier =Modifier.padding(start = 7.dp, bottom = 5.dp)

        )
        
        LazyRow(
            modifier =Modifier
        ){
            itemsIndexed(getShuffledList()){
                    index, item ->
                MoviesItemUiModel(image = item.image)
            }
        }
    }
   
}

@Composable
fun MoviesItemUiModel(
    image: Int
){
    Image(painter = painterResource(id = image), contentDescription ="movie" ,
        modifier = Modifier
            .height(200.dp)
            .width(150.dp)

    )
}

fun getShuffledList():List<Movieslist>{
    val listOfMovies = mutableListOf<Movieslist>()
    listOfMovies.add(Movieslist(R.drawable.image_1))
    listOfMovies.add(Movieslist(R.drawable.image_2))
    listOfMovies.add(Movieslist(R.drawable.image_3))
    listOfMovies.add(Movieslist(R.drawable.image_4))
    listOfMovies.add(Movieslist(R.drawable.image_5))
    listOfMovies.add(Movieslist(R.drawable.image_6))
    listOfMovies.add(Movieslist(R.drawable.image_7))
    listOfMovies.add(Movieslist(R.drawable.image_8))
    listOfMovies.add(Movieslist(R.drawable.image_9))
    listOfMovies.add(Movieslist(R.drawable.image_10))
    listOfMovies.add(Movieslist(R.drawable.image_11))
    listOfMovies.add(Movieslist(R.drawable.image_12))
    listOfMovies.add(Movieslist(R.drawable.image_13))
    listOfMovies.add(Movieslist(R.drawable.image_14))

    listOfMovies.shuffle()
    return listOfMovies
}

data class Movieslist(
    val image:Int
)