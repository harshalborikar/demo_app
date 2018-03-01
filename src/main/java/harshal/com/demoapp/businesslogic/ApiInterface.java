package harshal.com.demoapp.businesslogic;

import harshal.com.demoapp.model.MovieModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("?i=tt3896198")
    Call<MovieModel> getMovieList(@Query("apikey") String apiKey);
}
