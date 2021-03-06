package com.qbeuvelet.onevalet_test.navigation

import java.io.Serializable

sealed class Destination : Serializable {
    object UP : Destination()
    class DETAIL_DEVICE(val deviceId: String) : Destination()
}