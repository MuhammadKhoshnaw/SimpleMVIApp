package com.khoshnaw.gateway.gatewayImp

import com.khoshnaw.gateway.base.GatewayImp
import com.khoshnaw.gateway.localDataSource.MovieLocalDataSource
import com.khoshnaw.gateway.remoteDataSource.MovieRemoteDataSource
import com.khoshnaw.usecase.movie.gateway.MovieGateway
import javax.inject.Inject

class MovieGatewayImp @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
) : GatewayImp(), MovieGateway {

    override suspend fun updateMovieList() =
        movieLocalDataSource.updateMovieList(movieRemoteDataSource.loadMovieList())

    override suspend fun observeMovies() = movieLocalDataSource.observeMovies()

    override suspend fun loadMovieSize(): Int = movieLocalDataSource.loadMovieSize()

}
