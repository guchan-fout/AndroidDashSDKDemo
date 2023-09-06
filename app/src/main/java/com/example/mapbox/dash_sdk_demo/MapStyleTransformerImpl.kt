package com.example.mapbox.dash_sdk_demo

import com.mapbox.dash.app.config.MapStylePreference
import com.mapbox.dash.app.config.MapStyleTransformer
import com.mapbox.maps.extension.style.StyleContract
import com.mapbox.nav.gm.map.presentation.ui.getTerrainStyleExtension
import kotlinx.coroutines.flow.flowOf


class MapStyleTransformerImpl : MapStyleTransformer {

    override suspend fun transform(
        preference: MapStylePreference,
    ): kotlinx.coroutines.flow.Flow<StyleContract.StyleExtension> = with(preference) {
        val mapStyleUri = when {
            is3dMapEnabled -> MAP_3D_STYLE
            isSatelliteModeEnabled -> SATELLITE_MAP_STYLE
            theme.isNightTheme -> NIGHT_MAP_STYLE
            else -> DAY_MAP_STYLE
        }
        flowOf(getTerrainStyleExtension(mapStyleUri, isTerrainEnabled, is3dMapEnabled))
    }

    override val allStyles: List<String> = listOf(
        DAY_MAP_STYLE,
        NIGHT_MAP_STYLE,
        SATELLITE_MAP_STYLE,
        MAP_3D_STYLE,
    )

    private companion object {
        //Please replace your custom style into following parameters
        const val DAY_MAP_STYLE = "mapbox://styles/mapbox/navigation-day-v1"
        const val NIGHT_MAP_STYLE = "mapbox://styles/mapbox/navigation-night-v1"
        const val SATELLITE_MAP_STYLE = "mapbox://styles/mapbox/satellite-streets-v12"
        const val MAP_3D_STYLE = "mapbox://styles/mapbox/navigation-day-v1"

    }
}