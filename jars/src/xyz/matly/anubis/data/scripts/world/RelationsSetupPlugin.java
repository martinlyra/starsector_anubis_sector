package xyz.matly.anubis.data.scripts.world;

import com.fs.starfarer.api.campaign.SectorAPI;

public interface RelationsSetupPlugin {
    void applyInitialValues(SectorAPI sectorAPI);
}
