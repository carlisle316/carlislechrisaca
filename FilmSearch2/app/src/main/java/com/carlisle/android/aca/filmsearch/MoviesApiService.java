package com.carlisle.android.aca.filmsearch;

/**
 * Created by chriscarlisle on 10/17/16.
 */

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesApiService {

    @GET("/3/movie/popular?api_key=7d408e614b0cd2a1f406e03aa86fe732")
    Call<Movie.MovieResult> getPopularMovies();
}
