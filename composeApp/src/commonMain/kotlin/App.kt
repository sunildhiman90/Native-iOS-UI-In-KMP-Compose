import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {

    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        Box(modifier = Modifier.fillMaxSize()) {
            AppAlertDialog(
                Modifier.fillMaxWidth().padding(4.dp).align(Alignment.Center)
            ) {
                println("onDismissRequest")
                showDialog = false
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextButton(onClick = {
            showDialog = true
        }) {
            Text("Show Alert", style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Composable
fun ComposeAlertDialog(modifier: Modifier, onDismissRequest: () -> Unit) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            //Called when the user tries to dismiss the Dialog by clicking outside or pressing the back button
            onDismissRequest()
        },
        confirmButton = {
            TextButton(onClick = {
                onDismissRequest()
            }) {
                Text("Ok")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onDismissRequest()
            }) {
                Text("Cancel")
            }
        },
        title = {
            Text(text = "Compose Alert")
        },
        text = {
            Text(text = "I am Pure Compose Alert")
        },
    )
}