package mumtaz.binar.mvp_staf.network

import mumtaz.binar.mvp_staf.model.GetAllStafResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("staf")
    fun getAllStaf() : Call<List<GetAllStafResponseItem>>
}