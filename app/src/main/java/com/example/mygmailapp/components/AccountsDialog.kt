package com.example.mygmailapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.mygmailapp.R

@Composable
fun AccountsDialog(openDialog:MutableState<Boolean>){
    Dialog(onDismissRequest = { openDialog.value=false }) {
        AccountsDialogUI()
    }
}

@Composable
fun AccountsDialogUI(modifier: Modifier=Modifier){
    Card() {
        Column(
            modifier
                .background(Color.White)
                .padding(bottom = 16.dp)) {
            Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "")
                }
                Image(painter = painterResource(id = R.drawable.google), contentDescription = "",
                    modifier
                        .size(30.dp)
                        .weight(2.0f)
                )
            }
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp)) {
                Image(painter = painterResource(id = R.drawable.tutorials), contentDescription = "profile",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
                Column(
                    modifier
                        .weight(2.0f)
                        .padding(start = 16.dp, bottom = 16.dp)) {
                    Text(text = "Tutorials Eu", fontWeight = FontWeight.SemiBold)
                    Text(text = "tutorial@eu.com")
                }
                Text(text = "99+",modifier=Modifier.padding(end = 16.dp))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 62.dp)
            ) {
                Card(
                    modifier = Modifier
                        .requiredWidth(150.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp,color=Color.Gray)

                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(8.dp)
                    ) {
                        Text(
                            text = "Google Account",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
            Divider(modifier.padding(top = 16.dp))

        }
    }
}

@Preview
@Composable
fun AccountsDialogUIPreview(){
    AccountsDialogUI()
}