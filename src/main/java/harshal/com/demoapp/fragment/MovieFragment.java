package harshal.com.demoapp.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import harshal.com.demoapp.R;
import harshal.com.demoapp.UtilityClasses.CommonMethods;
import harshal.com.demoapp.activity.MainActivity;
import harshal.com.demoapp.adapter.MovieListAdapter;
import harshal.com.demoapp.businesslogic.ApiClient;
import harshal.com.demoapp.businesslogic.ApiInterface;
import harshal.com.demoapp.businesslogic.IClickListener;
import harshal.com.demoapp.businesslogic.IMovieListClickListener;
import harshal.com.demoapp.businesslogic.RecyclerTouchListener;
import harshal.com.demoapp.model.MovieModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private Context mContext = getActivity();
    private MovieModel movieModel;
    private IMovieListClickListener iMovieMistClickListener;
    private ProgressDialog pDialog;

    public MovieFragment(MainActivity mainActivity) {

        iMovieMistClickListener = mainActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_fragment_layout, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        if (CommonMethods.checkInternetConnection(getActivity()))
            callMovieListService();
        else
            CommonMethods.Toast(getActivity(), getResources().getString(R.string.no_internet_connection));
        recyclerViewRegisterEvent();
        return view;
    }

    private void recyclerViewRegisterEvent() {
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(mContext, mRecyclerView, new IClickListener() {
            @Override
            public void onClick(View v, int position) {
                iMovieMistClickListener.onMovieNameClick(movieModel);
            }

            @Override
            public void onLongClick(View v, int position) {
            }
        }));
    }

    private void callMovieListService() {
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage(getActivity().getString(R.string.loading));
        pDialog.setCancelable(false);
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieModel> call = apiInterface.getMovieList(getResources().getString(R.string.api_key));
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                movieModel = response.body();
                callMovieListAdapter(movieModel);
                pDialog.dismiss();
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                Toast.makeText(mContext, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callMovieListAdapter(MovieModel movieModel) {
        MovieListAdapter dataAdapter = new MovieListAdapter(getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(dataAdapter);
        dataAdapter.setData(movieModel);
        dataAdapter.notifyDataSetChanged();
    }
}
