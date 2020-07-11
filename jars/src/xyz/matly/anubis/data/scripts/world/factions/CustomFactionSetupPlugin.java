package xyz.matly.anubis.data.scripts.world.factions;

import com.fs.starfarer.api.campaign.SectorAPI;

public abstract class CustomFactionSetupPlugin {
    public final void setupFaction(SectorAPI sector) {
        setupRelations(sector);
        setupData(sector);
    }

    protected abstract void setupData(SectorAPI sector);
    protected abstract void setupRelations(SectorAPI sector);
}
