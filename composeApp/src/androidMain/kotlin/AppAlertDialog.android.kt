import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
actual fun AppAlertDialog(
    modifier: Modifier,
    onDismissRequest: () -> Unit
) {
    ComposeAlertDialog(modifier, onDismissRequest)
}