package cn.yanhx.learnkotlin

import cn.yanhx.learnkotlin.entity.Lesson
import cn.yanhx.learnkotlin.http.EntityCallback
import cn.yanhx.learnkotlin.http.HttpClient
import cn.yanhx.learnkotlin.utils.Utils
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class LessonPresenter(private val activity: LessonActivity) {
    private var lessons: List<Lesson> = ArrayList()
    private val type: Type = object : TypeToken<List<Lesson?>?>() {}.type
    fun fetchData() {
        HttpClient.get(
            LESSON_PATH,
            type,
            object : EntityCallback<List<Lesson>> {
                override fun onSuccess(lessons: List<Lesson>) {
                    this@LessonPresenter.lessons = lessons
                    activity.runOnUiThread { activity.showResult(lessons) }
                }

                override fun onFailure(message: String?) {
                    activity.runOnUiThread { Utils.toast(message) }
                }

            })
    }

    fun showPlayback() {
        activity.showResult(lessons.filter { it.state === Lesson.State.PLAYBACK })
    }

    companion object {
        private const val LESSON_PATH = "lessons"
    }

}