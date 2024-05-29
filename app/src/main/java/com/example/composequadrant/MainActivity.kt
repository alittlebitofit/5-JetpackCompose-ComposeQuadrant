package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.Card1
import com.example.composequadrant.ui.theme.Card2
import com.example.composequadrant.ui.theme.Card3
import com.example.composequadrant.ui.theme.Card4
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxSize()) {
        Row(modifier = modifier.weight(1f)) {
            QuadrantCard(
                text = stringResource(id = R.string.text_composable),
                description = stringResource(id = R.string.text_composable_description),
                quadrantColor = Card1,
                modifier = modifier
            )
            QuadrantCard(
                text = stringResource(id = R.string.image_composable),
                description = stringResource(id = R.string.image_composable_description),
                quadrantColor = Card2,
                modifier = modifier
            )
        }

        Row(modifier = modifier.weight(1f)) {
            QuadrantCard(
                text = stringResource(id = R.string.row_composable),
                description = stringResource(id = R.string.row_composable_description),
                quadrantColor = Card3,
                modifier = modifier
            )
            QuadrantCard(
                text = stringResource(id = R.string.column_composable),
                description = stringResource(id = R.string.column_composable_description),
                quadrantColor = Card4,
                modifier = modifier
            )
        }
    }
}

@Composable
private fun RowScope.QuadrantCard(
    text: String,
    description: String,
    quadrantColor: Color,
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(quadrantColor)
            .padding(16.dp)
            .weight(1f)
    ) {
        Text(
            text,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(bottom = 16.dp),
            style = TextStyle(
                color = Color.Black
            )
        )
        Text(
            description,
            textAlign = TextAlign.Justify,
            style = TextStyle(
                color = Color.Black
            )
        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Greeting()
    }
}