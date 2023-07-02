package com.bp.library.ui.pages.dashboard

import android.os.Parcelable
import com.bp.library.ui.pages.dashboard.component.ScreenType
import kotlinx.parcelize.Parcelize
import javax.annotation.concurrent.Immutable

@Immutable
@Parcelize
data class DashboardState(
    val screenType: ScreenType = ScreenType.HOME
) : Parcelable
