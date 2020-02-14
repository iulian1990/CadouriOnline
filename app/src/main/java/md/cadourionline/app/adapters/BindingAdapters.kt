package md.cadourionline.app.adapters

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.os.CountDownTimer
import android.text.format.DateUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("imageFromUri")
fun bindImageFromUri(view: ImageView, uri: String?) {
    if (!uri.isNullOrBlank()) {
        Glide.with(view.context).load(uri).into(view)
    }
}

@BindingAdapter("roundedImageFromUri")
fun bindRoundedImageFromUri(view: ImageView, uri: String?) {
    if (!uri.isNullOrBlank()) {
        Glide.with(view.context)
            .load(uri)
            .apply(RequestOptions.circleCropTransform())
            .into(view)
    }
}

@BindingAdapter("strikethroughText")
fun bindStrikethroughText(view: TextView, text: String?) {
    if (!text.isNullOrBlank()) {
        view.text = text
        view.paintFlags = view.paintFlags or STRIKE_THRU_TEXT_FLAG
    }
}

@BindingAdapter("countDownTimerText")
fun bindCountDownTimerText(view: TextView, seconds: Long?) {
    if (seconds != null) {

        object : CountDownTimer(seconds * 1000, 1000) {

            override fun onTick(millisInFuture: Long) {
                view.text = DateUtils.formatElapsedTime(millisInFuture / 1000)
            }

            override fun onFinish() {
                view.text = "00:00"
            }
        }.start()
    }
}
