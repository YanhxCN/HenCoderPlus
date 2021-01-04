package cn.yanhx.learnkotlin.entity

data class User @JvmOverloads constructor(
    var username: String? = null,
    var password: String? = null,
    var code: String? = null
)