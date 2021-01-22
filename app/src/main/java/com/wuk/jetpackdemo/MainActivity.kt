package com.wuk.jetpackdemo

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.GsonBuilder
import com.wuk.jetpackdemo.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activityMainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)




        //构建ViewModel实例
        val userModeluserModel: UserModel = ViewModelProvider(this).get(UserModel::class.java)
        userModeluserModel.mUserLiveData.observe(this, Observer <User>{
            activityMainBinding.tv.setText(it.age.toString())
        })

        activityMainBinding.lifecycleOwner = this
        activityMainBinding.data = userModeluserModel

//        activityMainBinding.tv.setOnClickListener {
//            userModeluserModel.doSomething()
//        }

        supportFragmentManager.beginTransaction().add(R.id.fl_container,BlankFragment(),"BlankFragment").commitAllowingStateLoss()


        retrofitTest();

    }

    private fun retrofitTest() {
        // https://www.wanandroid.com
        val builder:Retrofit.Builder = Retrofit.Builder()
        val retrofit: Retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.wanandroid.com")
                .build()
        val retrofitApi: APIService = retrofit.create(APIService::class.java)

        val accessToken = retrofitApi.getAccessToken();
        accessToken.enqueue(object : Callback<BannerBean> {
            override fun onFailure(call: Call<BannerBean>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<BannerBean>, response: Response<BannerBean>) {

                val body = response.body()
                val imagePath = body?.data?.get(1)?.imagePath

                Log.e("TAG", "onResponse: "+ imagePath)
            }

        })
    }
}