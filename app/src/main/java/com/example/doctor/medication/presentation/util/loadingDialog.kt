package com.example.doctor.medication.presentation.util

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun LoadingDialog(isLoading: Boolean) {
    if (isLoading) {
        Dialog(onDismissRequest = {

        },
        properties = DialogProperties(dismissOnClickOutside = false)
        ){
            Box(modifier = Modifier
                .width(200.dp)
                .clip(RoundedCornerShape(17.dp) )){
                CircularProgressIndicator(modifier = Modifier.padding(16.dp))
            }
        }
        }
    }