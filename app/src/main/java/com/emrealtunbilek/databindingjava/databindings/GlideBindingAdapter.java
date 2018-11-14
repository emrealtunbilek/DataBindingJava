package com.emrealtunbilek.databindingjava.databindings;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.emrealtunbilek.databindingjava.R;

import androidx.databinding.BindingAdapter;

public class GlideBindingAdapter {

    @BindingAdapter("resimGoster")
    public static void resimGoster(ImageView imageView, int drawable){
        //imageView.setImageResource(drawable);

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        Context myContext = imageView.getContext();
        Glide.with(myContext)
                .setDefaultRequestOptions(options)
                .load(drawable)
                .into(imageView);

    }

    @BindingAdapter("resimGoster")
    public static void resimGoster(ImageView imageView, String resimUrl){
        //imageView.setImageResource(drawable);

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        Context myContext = imageView.getContext();
        Glide.with(myContext)
                .setDefaultRequestOptions(options)
                .load(resimUrl)
                .into(imageView);

    }

    @BindingAdapter({"requestListener","resimGoster"})
    public static void resimGosterListenerli(ImageView imageView, RequestListener requestListener, int drawable){
        //imageView.setImageResource(drawable);

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        Context myContext = imageView.getContext();
        Glide.with(myContext)
                .setDefaultRequestOptions(options)
                .load(drawable)
                .listener(requestListener)
                .into(imageView);

    }

}
