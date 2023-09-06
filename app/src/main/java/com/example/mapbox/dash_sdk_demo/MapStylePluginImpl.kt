package com.example.mapbox.dash_sdk_demo

import com.mapbox.dash.app.config.MapStyleTransformer
import com.mapbox.dash.app.plugin.style.MapStylePlugin
import com.mapbox.dash.plugin.api.PluginPropertyFactory

class MapStylePluginImpl : MapStylePlugin {

    override val styleTransformer = PluginPropertyFactory<MapStyleTransformer> {
        MapStyleTransformerImpl()
    }
}