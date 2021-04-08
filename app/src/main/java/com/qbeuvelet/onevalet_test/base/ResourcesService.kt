package com.qbeuvelet.onevalet_test.base

import android.content.Context
import android.content.res.Resources
import javax.inject.Inject

class ResourcesService @Inject constructor(
    private val context: Context
): ResourcesServiceInterface {

    override fun getResources(): Resources {
        return context.resources
    }
}