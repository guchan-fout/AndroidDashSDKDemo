package com.example.mapbox.dash_sdk_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commitNow
import com.mapbox.dash.app.DashNavigationFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //without this, navigation view's top will be covered
        supportActionBar?.hide()
    }

    override fun onStart() {
        super.onStart()
        supportFragmentManager.commitNow {
            replace(R.id.container, DashNavigationFragment.newInstance())
        }
    }
}

