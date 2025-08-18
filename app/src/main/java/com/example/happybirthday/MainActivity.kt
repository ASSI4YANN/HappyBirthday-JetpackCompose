package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {// affichage de la mise en page
            HappyBirthdayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    GreetingImage(message = stringResource(R.string.happy_birthday_text),from= stringResource(
                        R.string.signature_text
                    )
                    )
                }


                }
            }
        }
    }


@Composable// Fonction composable des textes
fun GreetingText(message:String,from:String,modifier:Modifier=Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, // Argument permettant de centrer le texte horizontalement
        verticalArrangement = Arrangement.Center, // Argument permettant de centrer le texte verticalement
        modifier = modifier.fillMaxSize() // le modificateur FillMaxSize pour que la colonne prend tout l'écran.
    ) {

            Text(// La fonction composable Text permet de créé un élément de texte
                text = message, // text est un argument qui permet de définir le texte à afficher
                fontSize = 100.sp, // fontSize est un argument qui permet de modifier la taille de la police
                lineHeight = 116.sp, // lineHeight est argument qui permet de modifier la taille des ligne
                textAlign = TextAlign.Center //
            )
            Text(
                text = from,
                fontSize = 36.sp,
                modifier = Modifier
                    .padding(16.dp)// Pour ajouter une marge intérieure au "from Emma"
                    .align(alignment = Alignment.CenterHorizontally) // .align(alignment = Alignment.End) // Pour aligner à droite

            )
        }
    }

@Composable// Fonction composable de l'image
fun GreetingImage(message: String,from:String,modifier:Modifier=Modifier){
    val image = painterResource(R.drawable.androidparty)
    Box() {// Box est une utliser pour empiler du texte sur une image
        Image( // La fonction composable Image permet de rendre visible l'image
            painter = image,// painter pour définir l'image
            contentDescription = null,// permet de définir un texte sur l'image
            contentScale = ContentScale.Crop,// Pour redimensionner les images de manière uniforme pour que leurs proportions en termes de largeur et de hauteur soient égales ou supérieures à celles de l'écran
            alpha = 0.5F // Pour  modifiez l'opacité de  l'image de fond

        )
        GreetingText(
            message = message,
            from= from,
            modifier= Modifier// c'est le modificateur du  message et du from
                .fillMaxSize()
                .padding(8.dp)
            )

    }
}


@Preview(showBackground = true)// pour afficher l'aperçu d'une fonction composable
@Composable // Fonction composable pour l'affichage
fun BirthdayCardPreview(){
    HappyBirthdayTheme{
        GreetingImage(message = "Happy Birthday Sam !",from="From Emma")

    }
}