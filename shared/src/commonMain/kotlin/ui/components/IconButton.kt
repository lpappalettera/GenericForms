package ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.outlined.ChevronLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import theme.GenericFormsIcons

@Composable
fun ChevronLeftIconButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) = IconButton(
    modifier = modifier,
    enabled = enabled,
    onClick = onClick
) {
    Icon(imageVector = GenericFormsIcons.ChevronLeft, contentDescription = "Back")
}