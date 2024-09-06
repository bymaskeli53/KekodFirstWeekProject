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

@Composable
fun GivingScreen() {
    // Set the background color to lime
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF00FF00)), // Lime color (or use your color resource)
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // TextView equivalent in Compose
            Text(
                text = "Happiness Fragment",
                fontFamily = FontFamily(Font(R.font.roboto_thin)),
                style = MaterialTheme.typography.bodyLarge // Use style similar to text_style_details
            )

            // Spacer for margin
            Spacer(modifier = Modifier.height(24.dp))

            // ImageView equivalent in Compose
            Image(
                painter = painterResource(id = R.drawable.happiness),
                contentDescription = "Happiness",
                modifier = Modifier
                    .size(100.dp)
            )
        }
    }
}