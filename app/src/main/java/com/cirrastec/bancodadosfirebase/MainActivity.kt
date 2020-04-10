package com.cirrastec.bancodadosfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var dao = DAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_enviar.setOnClickListener {
            var cirrasTec = cirrasTec()
            cirrasTec.site = main_site.text.toString()
            cirrasTec.blog = main_blog.text.toString()

            main_site.text = null
            main_blog.text = null

            dao.salvar(cirrasTec)

        }
    }

    override fun onResume() {
        super.onResume()
        dao.getCirrasTec {
            main_site.setText(it?.site?:"")
            main_blog.setText(it?.blog?:"")
        }
    }
}
