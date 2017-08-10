package id.co.pln.plnweeeeew.api;

/**
 * Created by ahm on 11/05/17.
 */

import java.util.List;

import id.co.pln.plnweeeeew.model.Plnweeeeew;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface RetrofitArrayAPI {

    /*
     * Retrofit get annotation with our URL
     * And our method that will return us details of student.
    */
    @GET("script.php")
    Call<List<Plnweeeeew>> getPerizinanUnit();


}
