package br.com.devfestsul.planetas.fragments;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.parceler.Parcels;

import br.com.devfestsul.planetas.R;
import br.com.devfestsul.planetas.activity.CollapsingToolbarActivity;
import br.com.devfestsul.planetas.domain.Planeta;
import br.com.devfestsul.planetas.utils.PaletteUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlanetaFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_planeta, container, false);

        final TextView text1 = (TextView) view.findViewById(R.id.text1);
        final TextView text2 = (TextView) view.findViewById(R.id.text2);
        final TextView text3 = (TextView) view.findViewById(R.id.text3);
        final TextView text4 = (TextView) view.findViewById(R.id.text4);
        final TextView text5 = (TextView) view.findViewById(R.id.text5);
        final TextView text6 = (TextView) view.findViewById(R.id.text6);

        Planeta p = Parcels.unwrap(getArguments().getParcelable(Planeta.INTENT_KEY));
        if (p != null) {

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), p.img);

            // Palleta cores
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    // Colore a AppBar com a cor extraída da paleta de cores
                    CollapsingToolbarLayout c = (CollapsingToolbarLayout) getActivity().findViewById(R.id.collapsing_toolbar);
                    c.setBackgroundColor(PaletteUtil.getPaletteColor(getActivity(),palette, R.color.colorPrimary));
                    c.setContentScrimColor(PaletteUtil.getPaletteColorDark(getActivity(), palette, R.color.colorPrimary));

                    // Brinca com a paleta de cores. Seta as cores em cada TextVIew
                    int defaultColor = PaletteUtil.getColor(getActivity(),R.color.colorPrimary);

                    int vibrant = palette.getVibrantColor(defaultColor);
                    int vibrantLight = palette.getLightVibrantColor(defaultColor);
                    int vibrantDark = palette.getDarkVibrantColor(defaultColor);
                    int muted = palette.getMutedColor(defaultColor);
                    int mutedLight = palette.getLightMutedColor(defaultColor);
                    int mutedDark = palette.getDarkMutedColor(defaultColor);


                    text1.setTextColor(vibrant);
                    text2.setTextColor(vibrantLight);
                    text3.setTextColor(vibrantDark);
                    text4.setTextColor(muted);
                    text4.setTextColor(mutedLight);
                    text5.setTextColor(mutedDark);
                }
            });

            // App Bar Img
            CollapsingToolbarActivity activity = (CollapsingToolbarActivity) getActivity();
            activity.setAppBarImage(p.img);
            activity.setAppBarTitle(p.nome);
        }

        return view;
    }
}
