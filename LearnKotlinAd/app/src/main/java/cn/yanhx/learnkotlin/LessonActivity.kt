package cn.yanhx.learnkotlin

import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import cn.yanhx.learnkotlin.entity.Lesson


class LessonActivity : AppCompatActivity(), BaseView<LessonPresenter?>,
    Toolbar.OnMenuItemClickListener {
    override val presenter: LessonPresenter by lazy {
        LessonPresenter(this)
    }

    private val lessonAdapter: LessonAdapter = LessonAdapter()
    private lateinit var refreshLayout: SwipeRefreshLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu_lesson)
        toolbar.setOnMenuItemClickListener(this)
        findViewById<RecyclerView>(R.id.list).run {
           layoutManager = LinearLayoutManager(this@LessonActivity)
           adapter = lessonAdapter
           addItemDecoration(DividerItemDecoration(this@LessonActivity, LinearLayout.VERTICAL))
        }


        findViewById<SwipeRefreshLayout>(R.id.swipe_refresh_layout).run {
           setOnRefreshListener { presenter.fetchData() }
           isRefreshing = true
        }

        presenter.fetchData()
    }

    fun showResult(lessons: List<Lesson>) {
        lessonAdapter.updateAndNotify(lessons)
        refreshLayout.isRefreshing = false
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        presenter.showPlayback()
        return false
    }
}