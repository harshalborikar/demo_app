package harshal.com.demoapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import harshal.com.demoapp.R;
import harshal.com.demoapp.model.MovieModel;


public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {
    private MovieModel data;
    private Context mContext;

    public MovieListAdapter(Context mContext) {

        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_adapter_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.with(mContext).load(data.getPoster()).resize(130,200).into(holder.mImageView);
        holder.mMovieName.setText(data.getTitle());
        holder.mMovieDirector.setText(data.getDirector());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public void setData(MovieModel data) {
        this.data = data;
    }

    public MovieModel getData() {
        return data;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {

        private final ImageView mImageView;
        private final TextView mMovieName, mMovieDirector;

        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image_view);
            mMovieName = (TextView) itemView.findViewById(R.id.movie_name);
            mMovieDirector = (TextView) itemView.findViewById(R.id.movie_director);
        }
    }
}
