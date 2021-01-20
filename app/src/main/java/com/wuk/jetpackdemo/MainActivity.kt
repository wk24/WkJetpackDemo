package com.wuk.jetpackdemo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.wuk.jetpackdemo.databinding.ActivityMainBinding


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

    }
}