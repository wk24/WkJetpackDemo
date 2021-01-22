package com.wuk.jetpackdemo

import java.io.Serializable

/**
 * @author wuk
 * @date 2021/1/21
 */
data class BannerBean (var errorMsg:String,var errorCode:Int , var data:List<DataBean>) : Serializable {


}

data class DataBean (var desc:String,var id:Int,
                    var imagePath:String,var isVisible:Int,
                     var order : Int , var title:String,
                     var type : Int ,var url:String
) : Serializable {


}