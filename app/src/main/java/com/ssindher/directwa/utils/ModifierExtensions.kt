package com.ssindher.directwa.utils

import androidx.compose.ui.Modifier

inline fun Modifier.ifTrue(
    value: Boolean,
    builder: () -> Modifier,
) = then(if (value) builder() else Modifier)