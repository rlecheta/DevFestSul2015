package br.com.devfestsul.planetas.activity;

import android.os.Bundle;
import android.view.MenuItem;

import br.com.devfestsul.planetas.R;
import br.com.devfestsul.planetas.fragments.PlanetaFragment;

public class PlanetaActivity extends CollapsingToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_collapsing_toolbar);

        initViews();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(savedInstanceState == null) {
            PlanetaFragment frag = new PlanetaFragment();
            frag.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragContainer, frag, null).commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Up Navigation - voltando com animação
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
