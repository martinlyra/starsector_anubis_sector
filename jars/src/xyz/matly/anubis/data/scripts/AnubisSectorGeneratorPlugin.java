package xyz.matly.anubis.data.scripts;

import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.SectorGeneratorPlugin;

import xyz.matly.anubis.data.scripts.world.AursiaRelationsSetupPlugin;
import xyz.matly.anubis.data.scripts.world.systems.AnaberraSystemGenerator;
import xyz.matly.anubis.data.scripts.world.systems.CustomStarSystemGenerator;
import xyz.matly.anubis.data.scripts.world.systems.PerculesSystemGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnubisSectorGeneratorPlugin implements SectorGeneratorPlugin {

    private final List<CustomStarSystemGenerator> SYSTEMS_TO_CREATE;

    public AnubisSectorGeneratorPlugin() {
        SYSTEMS_TO_CREATE = new ArrayList<>(
                Arrays.asList(
                        new PerculesSystemGenerator(),
                        new AnaberraSystemGenerator()
                )
        );
    }

    @Override
    public void generate(SectorAPI sector) {
        for (CustomStarSystemGenerator starSystemGenerator : SYSTEMS_TO_CREATE)
            starSystemGenerator.generate(sector);

        new AursiaRelationsSetupPlugin().applyInitialValues(sector);
    }
}
