package br.com.devfestsul.planetas.fragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.parceler.Parcels;

import java.util.List;

import br.com.devfestsul.planetas.R;
import br.com.devfestsul.planetas.activity.PlanetaActivity;
import br.com.devfestsul.planetas.domain.Planeta;
import br.com.devfestsul.planetas.fragments.adapter.PlanetaAdapter;

/**
 * Created by rlech on 11-Nov-15.
 */
public class PlanetaListFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private List<Planeta> planetas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planetas_list, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.setHasFixedSize(true);

        planetas = Planeta.getPlanetas();
        recyclerView.setAdapter(new PlanetaAdapter(getContext(), planetas, onClickPlaneta()));

        return view;
    }

    private PlanetaAdapter.PlanetaOnClickListener onClickPlaneta() {
        return new PlanetaAdapter.PlanetaOnClickListener() {
            @Override
            public void onClickPlaneta(PlanetaAdapter.PlanetasViewHolder holder, int idx) {

                Planeta p = planetas.get(idx);



                Intent intent = new Intent(getContext(), PlanetaActivity.class);
                intent.putExtra(Planeta.INTENT_KEY, Parcels.wrap(p));

                // Start activity com animação
                String key = getString(R.string.transition_key);
                ImageView img = holder.img;
                ActivityOptionsCompat opts = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), img, key);
                ActivityCompat.startActivity(getActivity(), intent, opts.toBundle());
            }
        };
    }


}
