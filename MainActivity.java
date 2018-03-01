package harshal.com.demoapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import harshal.com.demoapp.R;
import harshal.com.demoapp.businesslogic.IMovieListClickListener;
import harshal.com.demoapp.fragment.MovieFragment;
import harshal.com.demoapp.fragment.MovieListDetailsFragment;
import harshal.com.demoapp.model.MovieModel;

public class MainActivity extends AppCompatActivity implements IMovieListClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDefaultFagment();
    }

    private void setDefaultFagment() {
        getSupportFragmentManager().beginTransaction().add(R.id.frame, new MovieFragment(MainActivity.this)).commit();
    }

    @Override
    public void onMovieNameClick(MovieModel movieModel) {
        MovieListDetailsFragment movieListDetailsFragment = new MovieListDetailsFragment(MainActivity.this);
        movieListDetailsFragment.setMovieDetailsData(movieModel);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, movieListDetailsFragment).addToBackStack(null).commit();
    }
}
