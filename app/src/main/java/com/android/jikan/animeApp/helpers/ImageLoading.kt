package com.android.jikan.animeApp.helpers


import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.android.jikan.animeApp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun loadImage(url: String, imageView: ImageView) {
    val circularProgressDrawable = CircularProgressDrawable(imageView.context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()
    CoroutineScope(Dispatchers.IO).launch {
        var builder :RequestBuilder<out Drawable>
        withContext(Dispatchers.IO){
            builder = Glide.with(imageView.context)
                .load(url)
                .transform(RoundedCorners(100))
                .placeholder(circularProgressDrawable)
                .error(R.drawable.baseline_error_24)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
        }
        withContext(Dispatchers.Main){
            builder.into(imageView)
        }
    }
}