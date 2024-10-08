package com.plcoding.supportallscreensizescompose
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun rememberWindowInfo(): WindowInfo {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val screenWidthInfo = when {
        screenWidth < 600.dp -> WindowInfo.WindowType.Compact
        screenWidth < 840.dp -> WindowInfo.WindowType.Medium
        else -> WindowInfo.WindowType.Expanded
    }

    val screenHeightInfo = when {
        screenHeight < 480.dp -> WindowInfo.WindowType.Compact
        screenHeight < 900.dp -> WindowInfo.WindowType.Medium
        else -> WindowInfo.WindowType.Expanded
    }

    return WindowInfo(
        screenWidthInfo = screenWidthInfo,
        screenHeightInfo = screenHeightInfo,
        screenWidth = screenWidth,
        screenHeight = screenHeight
    )
}

data class WindowInfo(
    val screenWidthInfo: WindowType,
    val screenHeightInfo: WindowType,
    val screenWidth: Dp,
    val screenHeight: Dp
) {
    sealed class WindowType {
        object Compact : WindowType()
        object Medium : WindowType()
        object Expanded : WindowType()
    }
}
