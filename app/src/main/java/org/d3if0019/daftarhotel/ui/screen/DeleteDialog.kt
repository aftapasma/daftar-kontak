package org.d3if0019.daftarhotel.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.d3if0019.daftarhotel.R
import org.d3if0019.daftarhotel.ui.theme.DaftarKontakTheme

@Composable
fun ConfirmDialog(
    openDialog: Boolean,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
) {
    if (openDialog) {
        AlertDialog(
            text = { Text(text = stringResource(R.string.pesan_hapus)) },
            confirmButton = {
                Button(
                    onClick = { onConfirmation() },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = stringResource(R.string.hapus))
                }
            },
            dismissButton = {
                Button(
                    onClick = { onDismissRequest() },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = stringResource(R.string.batal))
                }
            },
            onDismissRequest = { onDismissRequest() },
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DeleteDialogPreview() {
    DaftarKontakTheme {
        ConfirmDialog(
            openDialog = true,
            onDismissRequest = { },
            onConfirmation = { },
        )
    }
}