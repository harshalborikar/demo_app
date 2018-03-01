package harshal.com.demoapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import harshal.com.demoapp.R;
import harshal.com.demoapp.model.MovieModel;

public class MovieListDetailsFragment extends Fragment {
    private Context mContext;
    private MovieModel movieModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_details_fragment_layout, container, false);
        ImageView mImageView = (ImageView) view.findViewById(R.id.image_view);
        TextView mMovieName = (TextView) view.findViewById(R.id.movie_name);
        TextView mYear = (TextView) view.findViewById(R.id.year);
        TextView mRated = (TextView) view.findViewById(R.id.rated);
        TextView mRunTime = (TextView) view.findViewById(R.id.runtime);
        TextView mDirector = (TextView) view.findViewById(R.id.director);
        TextView mLanguage = (TextView) view.findViewById(R.id.language);
        TextView mReleased = (TextView) view.findViewById(R.id.released);
        TextView mGenre = (TextView) view.findViewById(R.id.genre);
        TextView mWriters = (TextView) view.findViewById(R.id.writers);
        TextView mActors = (TextView) view.findViewById(R.id.actors);
        TextView mAwards = (TextView) view.findViewById(R.id.awards);
        TextView mPlot = (TextView) view.findViewById(R.id.plot);
        TextView mCountry = (TextView) view.findViewById(R.id.country);
        TextView mRating = (TextView) view.findViewById(R.id.ratings);
        TextView mType = (TextView) view.findViewById(R.id.type);
        TextView mImdbID = (TextView) view.findViewById(R.id.imdbId);
        TextView mImdbRating = (TextView) view.findViewById(R.id.imdbratings);
        TextView mImdbVotes = (TextView) view.findViewById(R.id.imdbvotes);
        TextView mDVD = (TextView) view.findViewById(R.id.dvd);
        TextView mProduction = (TextView) view.findViewById(R.id.production);
        TextView mWebsite = (TextView) view.findViewById(R.id.website);
        TextView mBoxOffice = (TextView) view.findViewById(R.id.boxoffice);
        TextView mMetascore = (TextView) view.findViewById(R.id.metascore);
        LinearLayout mLinearLayout = (LinearLayout) view.findViewById(R.id.linearlayout);

        Picasso.with(mContext).load(movieModel.getPoster()).resize(150, 200).into(mImageView);
        mMovieName.setText(movieModel.getTitle());
        mYear.setText(getResources().getString(R.string.year) + " : " + movieModel.getYear());
        mDirector.setText(getResources().getString(R.string.director) + " : " + movieModel.getDirector());
        mLanguage.setText(getResources().getString(R.string.language) + " : " + movieModel.getLanguage());
        mRated.setText(getResources().getString(R.string.rated) + " : " + movieModel.getRated());
        mRunTime.setText(getResources().getString(R.string.runtime) + " : " + movieModel.getRunTime());
        mReleased.setText(getResources().getString(R.string.released) + " : " + movieModel.getReleased());
        mActors.setText(getResources().getString(R.string.actors) + " : " + movieModel.getActors());
        mAwards.setText(getResources().getString(R.string.awards) + " : " + movieModel.getAwards());
        mCountry.setText(getResources().getString(R.string.country) + " : " + movieModel.getCountry());
        mWriters.setText(getResources().getString(R.string.writers) + " : " + movieModel.getWriters());
        mGenre.setText(getResources().getString(R.string.genre) + " : " + movieModel.getGenre());
        mPlot.setText(getResources().getString(R.string.plot) + " : " + movieModel.getPlot());
        mImdbID.setText(getResources().getString(R.string.imdbid) + " : " + movieModel.getImdbID());
        mImdbRating.setText(getResources().getString(R.string.imdbrating) + " : " + movieModel.getImdbRating());
        mImdbVotes.setText(getResources().getString(R.string.imdbvotes) + " : " + movieModel.getImdbVotes());
        mDVD.setText(getResources().getString(R.string.dvd) + " : " + movieModel.getDvd());
        mType.setText(getResources().getString(R.string.type) + " : " + movieModel.getType());
        mBoxOffice.setText(getResources().getString(R.string.boxoffice) + " : " + movieModel.getBoxOffice());
        mProduction.setText(getResources().getString(R.string.production) + " : " + movieModel.getProduction());
        mMetascore.setText(getResources().getString(R.string.metascore) + " : " + movieModel.getMetascore());
        mWebsite.setText(getResources().getString(R.string.website) + " : " + movieModel.getWebsite());
        mRating.setText(getResources().getString(R.string.rating) + " : ");

        for (int i = 0; i < movieModel.getRatings().size(); i++) {
            TextView textView = new TextView(getActivity());
            textView.setText("                    " + movieModel.getRatings().get(i).getSource() + " - " + movieModel.getRatings().get(i).getValue());
            mLinearLayout.addView(textView);
            textView.setId(i);
        }
        return view;
    }

    public MovieListDetailsFragment(Context mainActivity) {
        mContext = mainActivity;
    }

    public void setMovieDetailsData(MovieModel movieModel) {
        this.movieModel = movieModel;
    }
}
