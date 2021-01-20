package com.wuk.jetpackdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * @author wuk
 * @date 2021/1/18
 */
class UserModel : ViewModel() {
    val mUserLiveData = MutableLiveData<User>()
    var myRepository:MyRepository
    init {
        myRepository = MyRepository();
        //模拟从网络加载用户信息
        mUserLiveData.postValue(User( "name1" ,1))
    }


    fun doSomething(){
        val user = mUserLiveData.value;
        user?.let {
            val doSomething = myRepository.doSomething(it.age)
            it.age = doSomething
            mUserLiveData.postValue(it)
        }


    }

//    fun getName(): String {
//        var name = ""
//        mUserLiveData.value.let {
//            name = mUserLiveData.value!!.name;
//        }
//
//
//        return name;
//    }

}