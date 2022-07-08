package com.wonderful.todo.ui.dialog

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.wonderful.todo.R

/**
 * Describe: 提示弹窗
 * <p>
 * @author wonderful
 * @time 2022/7/1 17:33
 */

@Composable
fun TodoAlertDialog(
    title: String,
    msg: String,
    isShow: Boolean,
    onNoClick: () -> Unit,
    onYesClick: () -> Unit
) {
    if (isShow) {
        AlertDialog(
            title = {
                Text(
                    text = title,
                    fontSize = MaterialTheme.typography.h4.fontSize,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(
                    text = msg,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Normal
                )
            },
            confirmButton = {
                Button(onClick = {
                    onYesClick()
                }) {
                    Text(text = stringResource(id = R.string.yes))
                }
            },
            dismissButton = {
                Button(onClick = { onNoClick() }) {
                    Text(text = stringResource(id = R.string.no))
                }
            },
            onDismissRequest = { onNoClick() })
    }
}