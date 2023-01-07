package com.example.trainingboutons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trainingboutons.ui.theme.TrainingBoutonsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainingBoutonsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Body()
                }
            }
        }
    }
}

@Composable
fun Body() {

    val diffName = listOf<String>("Angélique", "Cyril", "Anthony", "Léa")
    var color by remember { mutableStateOf(Color.Black)}
    var count by remember { mutableStateOf(0) }
    var name by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Salut ${diffName.get(name)}\nCompteur: $count",
            color = color
        )
        Button(
            onClick = {
                color = if (color == Color.Black) {
                    Color.Green
                } else {
                    Color.Black
                }
            },
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
           Text(
               text = "Changer la couleur du texte",
               color = Color.White
           )
        }
        TextButton(
            onClick = { count++ },
            border = BorderStroke(width = 2.dp, color = Color.Black)
            ) {
            Text(text = "Incrémenter")
        }
        TextButton(
            onClick = { count-- },
            border = BorderStroke(width = 2.dp, color = Color.Black)
        ) {
            Text(text = "Décrémenter")
        }
        IconButton(onClick = { count = 0 }) {
            Row {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "remettre à zéro")
                Text(text = "Remettre le compteur à zéro")
            }
        }
        FloatingActionButton(onClick = { name = (diffName.indices).random() }) {
            Icon(imageVector = Icons.Default.Build, contentDescription = "changer de nom")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TrainingBoutonsTheme {
        Body()
    }
}