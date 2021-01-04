package cn.yanhx.learnkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import cn.yanhx.learnkotlin.entity.User
import cn.yanhx.learnkotlin.utils.CacheUtils
import cn.yanhx.learnkotlin.utils.Utils
import cn.yanhx.learnkotlin.widget.CodeView

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private val usernameKey = "username"
    private val passwordKey = "password"

    private lateinit var et_username:EditText
    private lateinit var et_password:EditText
    private lateinit var et_code:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        et_code = findViewById(R.id.et_code)

        et_username.setText(CacheUtils.get(usernameKey))
        et_password.setText(CacheUtils.get(passwordKey))

        val btn_login = findViewById<Button>(R.id.btn_login)
        val code_view = findViewById<CodeView>(R.id.code_view)
        btn_login.setOnClickListener(this)
        code_view.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v is CodeView) {
            v.updateCode()
        } else if (v is Button){
            login()
        }
    }

    private fun login() {
        val username = et_username.text.toString()
        val password = et_password.text.toString()
        val code = et_code.text.toString()
        val user = User(username,password,code)
        fun verify():Boolean {
            if (user.username?.length ?: 0<4) {
                Utils.toast("用户名不合法")
                return false
            }
            if (user.password?.length ?: 0<4) {
                Utils.toast("密码不合法")
                return false
            }
            return true
        }
        if (verify()) {
            CacheUtils.save(usernameKey,username)
            CacheUtils.save(passwordKey,password)
            startActivity(Intent(this,LessonActivity::class.java))
        }
    }



}