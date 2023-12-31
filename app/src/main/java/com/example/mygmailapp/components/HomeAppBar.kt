package com.example.mygmailapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mygmailapp.GmailApp
import com.example.mygmailapp.R
import com.example.mygmailapp.ui.theme.MyGmailAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeAppBar(scaffoldState: ScaffoldState,scope:CoroutineScope,openDialog:MutableState<Boolean>){
    Box(modifier = Modifier.padding(10.dp)) {
        Card(
            modifier =Modifier.requiredHeight(50.dp),
            shape = RoundedCornerShape(10.dp), elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                IconButton(onClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }){
                    Icon(Icons.Default.Menu,"Menu")

                }
                Text(text = "Search in emails", modifier = Modifier.weight(2.0f))
                Image(painter = painterResource(id = R.drawable.tutorials), contentDescription = "profile",
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
                    .clickable {
                        openDialog.value = true
                    }
                )
                if (openDialog.value){
                    AccountsDialog(openDialog)
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview(){
    MyGmailAppTheme {
        GmailApp()
    }
}