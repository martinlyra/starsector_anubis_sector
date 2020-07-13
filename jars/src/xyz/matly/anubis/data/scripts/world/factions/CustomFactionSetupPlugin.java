package xyz.matly.anubis.data.scripts.world.factions;

import com.fs.starfarer.api.campaign.SectorAPI;
import xyz.matly.anubis.AnubisSectorGlobal;
import xyz.matly.anubis.SupportedMods;

public abstract class CustomFactionSetupPlugin {
    public final void setupFaction(SectorAPI sector) {
        if (!SupportedMods.NEXERELIN.isFound() || AnubisSectorGlobal.getConfig().getAlwaysUseVanillaRelations())
            setupRelations(sector);
        setupData(sector);
    }

    protected abstract void setupData(SectorAPI sector);
    protected abstract void setupRelations(SectorAPI sector);
}
