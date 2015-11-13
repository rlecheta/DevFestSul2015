package br.com.devfestsul.planetas.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;

import br.com.devfestsul.planetas.R;

/**
 * Created by rlech on 12-Nov-15.
 */
public class PaletteUtil {
    public static int getPaletteColorDark(Context context, Palette palette, int defaultColor) {
        int color = getColor(context, defaultColor);

        int vibrant = palette.getVibrantColor(color);
        if(vibrant != color) {
            return vibrant;
        }

        int vibrantLight = palette.getLightVibrantColor(color);
        if(vibrantLight != color) {
            return vibrantLight;
        }

        int muted = palette.getMutedColor(color);
        if(muted != color) {
            return muted;
        }
        return color;
    }

    public static int getPaletteColor(Context context, Palette palette, int defaultColor) {
        int color = getColor(context, defaultColor);

        int vibrantLight = palette.getLightVibrantColor(color);
        if(vibrantLight != color) {
            return vibrantLight;
        }

        int vibrant = palette.getVibrantColor(color);
        if(vibrant != color) {
            return vibrant;
        }

        int muted = palette.getMutedColor(color);
        if(muted != color) {
            return muted;
        }
        return color;
    }

    public static int getColor(Context context, int color) {
        return ContextCompat.getColor(context, color);
    }
}
