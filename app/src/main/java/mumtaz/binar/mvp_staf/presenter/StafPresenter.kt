package mumtaz.binar.mvp_staf.presenter

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import mumtaz.binar.mvp_staf.model.GetAllStafResponseItem
import mumtaz.binar.mvp_staf.network.ApiClient
import mumtaz.binar.mvp_staf.view.DetailStafActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StafPresenter( val viewstaf : StafView){

    fun getDataStaf(){
        ApiClient.instance.getAllStaf()
            .enqueue(object : Callback<List<GetAllStafResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllStafResponseItem>>,
                    response: Response<List<GetAllStafResponseItem>>
                ) {
                    if (response.isSuccessful){
                        viewstaf.onSuccess(response.message(),response.body()!!)

                    }else{
                        viewstaf.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<GetAllStafResponseItem>>, t: Throwable) {
                    viewstaf.onError(t.message!!)
                }

            })
    }
}