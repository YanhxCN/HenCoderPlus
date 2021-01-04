package cn.yanhx.learnkotlin

interface BaseView<T> {
    fun getPresenter(): T
}