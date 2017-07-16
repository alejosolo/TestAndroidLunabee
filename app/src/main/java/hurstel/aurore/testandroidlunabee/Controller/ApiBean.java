package hurstel.aurore.testandroidlunabee.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hurstel.aurore.testandroidlunabee.ApiRequestMethod;
import hurstel.aurore.testandroidlunabee.Class.User;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBean {

    private ApiRequestMethod apiService;

    public User user;
    public User[] users;

    public ApiBean() {
        initRetrofit();
    }

    public void initRetrofit() {

        final GsonBuilder gsonBuilder = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd' 'HH:mm:ss");

        Gson gson = gsonBuilder.create();

        final String BASE_URL = "https://randomuser.me/api/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiService = retrofit.create(ApiRequestMethod.class);
    }

//    public void getUser(){
//        User user = new User();
//        Call<User> call = apiService.createUser(user);
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                user = response.getUser();
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//            }
//    }
}
