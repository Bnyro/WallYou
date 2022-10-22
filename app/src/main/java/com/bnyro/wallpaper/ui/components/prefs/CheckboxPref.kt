package com.bnyro.wallpaper.ui.components.prefs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bnyro.wallpaper.util.PrefHolder

@Composable
fun CheckboxPref(
    prefKey: String,
    title: String,
    summary: String? = null,
    defaultValue: Boolean = false
) {
    var checked by remember {
        mutableStateOf(
            PrefHolder.Preferences.getBoolean(prefKey, defaultValue)
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        PreferenceItem(
            title = title,
            summary = summary
        )
        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = it
                PrefHolder.PrefEditor.putBoolean(prefKey, it).apply()
            }
        )
    }
}
