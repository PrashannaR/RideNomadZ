package com.ridenomad.ridenomadz.presentation.onboarding

import androidx.annotation.DrawableRes
import com.ridenomad.ridenomadz.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,

    ) {
    object First : OnBoardingPage(
        image = R.drawable.sample_image,
        title = "Find best house on wheels for your family"
    )

    object Second : OnBoardingPage(
        image = R.drawable.sample_image,
        title = "Use our tour guides customized for you."
    )
}
