package xyz.matly.anubis.data.scripts;

import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.SectorGeneratorPlugin;

import xyz.matly.anubis.data.scripts.world.factions.AursiaSetupPlugin;
import xyz.matly.anubis.data.scripts.world.factions.CustomFactionSetupPlugin;
import xyz.matly.anubis.data.scripts.world.systems.AnaberraSystemGenerator;
import xyz.matly.anubis.data.scripts.world.systems.CustomStarSystemGenerator;
import xyz.matly.anubis.data.scripts.world.systems.PerculesSystemGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnubisSectorGeneratorPlugin implements SectorGeneratorPlugin {

    private final List<CustomStarSystemGenerator> SYSTEMS_TO_CREATE;
    private final List<CustomFactionSetupPlugin> FACTIONS_TO_SETUP;

    public AnubisSectorGeneratorPlugin() {
        SYSTEMS_TO_CREATE = Arrays.asList(
                new PerculesSystemGenerator(),
                new AnaberraSystemGenerator()
        );
        FACTIONS_TO_SETUP = new ArrayList<CustomFactionSetupPlugin>(Arrays.asList(
                new AursiaSetupPlugin()
        ));
    }

    @Override
    public void generate(SectorAPI sector) {
        for (CustomStarSystemGenerator starSystemGenerator : SYSTEMS_TO_CREATE)
            starSystemGenerator.generate(sector);

        for (CustomFactionSetupPlugin factionSetupPlugin : FACTIONS_TO_SETUP)
            factionSetupPlugin.setupFaction(sector);
    }
}
