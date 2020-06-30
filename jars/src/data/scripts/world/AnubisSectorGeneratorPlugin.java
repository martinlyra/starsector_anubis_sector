package data.scripts.world;

import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.SectorGeneratorPlugin;

import data.scripts.world.systems.PerculesSystemGenerator;

public class AnubisSectorGeneratorPlugin implements SectorGeneratorPlugin {
    @Override
    public void generate(SectorAPI sector) {
        new PerculesSystemGenerator().generate(sector);
    }
}
