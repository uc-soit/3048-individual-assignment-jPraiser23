package service

import androidx.lifecycle.MutableLiveData
import app.plantdiary.individualassignment3048q.RetrofitClientInstance
import app.plantdiary.individualassignment3048q.dao.IcountriesDAO
import app.plantdiary.individualassignment3048q.dto.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryService {
    public fun fetchCountries(countryName: String) : MutableLiveData<ArrayList<Country>> {

        var _countries = MutableLiveData<ArrayList<Country>>()
        val service = RetrofitClientInstance.retrofitInstance?.create(IcountriesDAO::class.java)
        val call = service?.getAllCountries()
        println(call.toString() + " 3")

        call?.enqueue(object: Callback<ArrayList<Country>> {
            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */

            override fun onResponse(

                call: Call<ArrayList<Country>>,
                response: Response<ArrayList<Country>>
            ) {
                _countries.value = response.body()
                println(response.body() )
            }

            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<ArrayList<Country>>, t: Throwable) {
                val j = 1 + 1;
                val i = 1 + 1;
            }

        })
        return _countries
    }


}