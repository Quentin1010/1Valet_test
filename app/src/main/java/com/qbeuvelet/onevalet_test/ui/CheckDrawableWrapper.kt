package com.qbeuvelet.onevalet_test.ui

import android.graphics.drawable.DrawableWrapper
import android.view.MenuItem

/** Fixes checked state being ignored by injecting checked state directly into drawable */
class CheckDrawableWrapper(private val menuItem: MenuItem) : DrawableWrapper(menuItem.icon) {
    override fun setState(stateSet: IntArray) = super.setState(
        if (menuItem.isChecked) stateSet + android.R.attr.state_checked else stateSet
    )
}

fun MenuItem.fixCheckStateOnIcon() = apply { icon = CheckDrawableWrapper(this) }