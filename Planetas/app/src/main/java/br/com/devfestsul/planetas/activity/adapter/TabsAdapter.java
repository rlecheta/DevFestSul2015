package br.com.devfestsul.planetas.activity.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.devfestsul.planetas.R;
import br.com.devfestsul.planetas.fragments.PlanetaListFragment;

/**
 * Created by rlech on 11/6/2015.
 */
public class TabsAdapter extends FragmentPagerAdapter {
    private Context context;
    private Bundle extras;

    public TabsAdapter(Context context, FragmentManager fm, Bundle extras) {
        super(fm);
        this.context = context;
        this.extras = extras;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getString(R.string.planetas);
        }
        return context.getString(R.string.constelacoes);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        if (position == 0) {
            f = new PlanetaListFragment();
        } else if (position == 1) {
            f = new PlanetaListFragment();
        }
        if (extras != null) {
            f.setArguments(extras);
        }
        return f;
    }
}