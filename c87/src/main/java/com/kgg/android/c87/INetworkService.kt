package com.kgg.android.c87

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface INetworkService {
    @GET("api/users")
    fun doGetUserList(@Query("page") page: String): retrofit2.Call<UserListModel>
}