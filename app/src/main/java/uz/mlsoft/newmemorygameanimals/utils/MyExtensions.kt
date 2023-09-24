package uz.mlsoft.newmemorygameanimals.utils

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import timber.log.Timber
import uz.mlsoft.newmemorygameanimals.R
import uz.mlsoft.newmemorygameanimals.data.CardData

fun ImageView.openCard(finishAnim: () -> Unit = {}) {
    this.animate()
        .setDuration(duration)
        .rotationY(89f)
        .withEndAction {
            this.setImageResource((tag as CardData).pic)
            this.rotationY = -91f
            this.animate()
                .setDuration(duration)
                .rotationY(0f)
                .withEndAction {
                    finishAnim.invoke()
                }.start()
        }.start()
}

fun ImageView.closeCard(finishAnim: () -> Unit = {}) {
    this.animate()
        .setDuration(duration)
        .rotationY(-91f)
        .withEndAction {
            this.setImageResource(android.R.color.transparent)
            this.rotationY = 89f
            this.animate()
                .setDuration(duration)
                .rotationY(0f)
                .withEndAction { finishAnim.invoke() }.start()
        }.start()
}

fun ImageView.hideCard(finishAnim: () -> Unit = {}) {
    this.animate()
        .setDuration(duration)
        .scaleX(0f)
        .scaleY(0f)
        .withEndAction {
            this.visibility = View.GONE
            finishAnim.invoke()
        }.start()
}

fun myTimber(message: String) {
    Timber.tag("TTT").d(message)
}

const val duration = 500L


fun Fragment.playStoreUrl() =
    "Hoziroq yuklab oling!: "  + "https://play.google.com/store/apps/details?id=${context?.applicationContext?.packageName}"


