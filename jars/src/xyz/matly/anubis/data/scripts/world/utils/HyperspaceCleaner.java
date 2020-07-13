package xyz.matly.anubis.data.scripts.world.utils;

import com.fs.starfarer.api.campaign.StarSystemAPI;
import com.fs.starfarer.api.impl.campaign.procgen.NebulaEditor;
import com.fs.starfarer.api.impl.campaign.terrain.HyperspaceTerrainPlugin;
import com.fs.starfarer.api.util.Misc;
import org.lwjgl.util.vector.Vector2f;

public class HyperspaceCleaner {
    public static void cleanUp(StarSystemAPI systemAPI) {
        cleanUp(systemAPI, 1.0f);
    }

    public static void cleanUp(StarSystemAPI systemAPI, float minimumClearanceMult) {
        HyperspaceTerrainPlugin hyperspaceTerrainPlugin =
                (HyperspaceTerrainPlugin) Misc.getHyperspaceTerrain().getPlugin();
        NebulaEditor nebulaEditor = new NebulaEditor(hyperspaceTerrainPlugin);
        float minRadius = hyperspaceTerrainPlugin.getTileSize() * minimumClearanceMult;

        float radius = systemAPI.getMaxRadiusInHyperspace();
        Vector2f location = systemAPI.getLocation();
        nebulaEditor.clearArc(
                location.x,
                location.y,
                0,
                radius + minRadius,
                0,
                360f
        );
        nebulaEditor.clearArc(
                location.x,
                location.y,
                0,
                radius + (minRadius * 2),
                0,
                360f,
                0.25f
        );
    }
}
