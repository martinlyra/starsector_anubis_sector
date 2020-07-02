package data.scripts.world.systems;

import com.fs.starfarer.api.campaign.SectorAPI;

/**
 * Interface for star system generators. Copy of SectorGeneratorPlugin
 * Created separately just in case if the latter interface changes.
 */
public interface CustomStarSystemGenerator {
    void generate(SectorAPI sectorAPI);
}
