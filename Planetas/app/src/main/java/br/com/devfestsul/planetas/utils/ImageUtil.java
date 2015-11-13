package br.com.devfestsul.planetas.utils;

import android.content.Context;
import android.webkit.URLUtil;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageUtil {

    public static void setImage(Context context, String url_img, ImageView img) {
        if (url_img != null && url_img.trim().length() > 0 && URLUtil.isValidUrl(url_img)) {
            Picasso.with(context).load(url_img).into(img);
        }
    }
}
