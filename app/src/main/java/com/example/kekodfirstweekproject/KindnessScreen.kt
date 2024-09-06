package com.example.kekodfirstweekproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun KindnessScreen() {
    // Set the background color to green
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green), // Replace with your color resource if needed
        contentAlignment = Alignment.Center
    ) {
        // Align items vertically
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // TextView equivalent in Compose
            Text(
                text = "Kindness Fragment",
                fontFamily = FontFamily(Font(R.font.roboto_thin)),
                fontSize = 30.sp,// Replace with your actual font
                style = MaterialTheme.typography.bodyLarge // Replace with your custom text_style_details if needed
            )

            // Spacer to add margin between Text and Image
            Spacer(modifier = Modifier.height(24.dp))

            // ImageView equivalent in Compose
            Image(
                painter = painterResource(id = R.drawable.kindness), // Replace with your actual drawable
                contentDescription = "Kindness",
                modifier = Modifier.size(100.dp)
            )
        }
    }
}
