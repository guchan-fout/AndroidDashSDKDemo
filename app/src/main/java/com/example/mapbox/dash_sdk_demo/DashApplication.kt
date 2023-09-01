package com.example.mapbox.dash_sdk_demo

import android.app.Application
import com.mapbox.dash.app.DashSdk
import com.mapbox.dash.app.plugin.auth.MapboxPlugin
import com.mapbox.dash.plugin.api.PluginPropertyFactory
import com.mapbox.dash.plugin.api.model.ResourceSecret
import com.mapbox.dash.plugin.api.model.Secret

class DashApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize SDKs, plugins, and other global state here
        DashSdk.getInstance(isDebug = BuildConfig.DEBUG).init(context = this) {
            declare(MapboxPluginImpl())
        }
    }
}

internal class MapboxPluginImpl : MapboxPlugin {
    override val accessToken = PluginPropertyFactory<Secret> {
        ResourceSecret(R.string.mapbox_access_token)
    }
}