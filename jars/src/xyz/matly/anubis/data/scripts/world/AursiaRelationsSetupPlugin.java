package data.scripts.world;

import com.fs.starfarer.api.campaign.FactionAPI;
import com.fs.starfarer.api.campaign.RepLevel;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.impl.campaign.ids.Factions;

public class AursiaRelationsSetupPlugin implements RelationsSetupPlugin {
    @Override
    public void applyInitialValues(SectorAPI sectorAPI) {
        FactionAPI aursia = sectorAPI.getFaction("aursia");

        aursia.setRelationship(Factions.DIKTAT, RepLevel.WELCOMING);
        aursia.setRelationship(Factions.HEGEMONY, RepLevel.INHOSPITABLE);
        aursia.setRelationship(Factions.INDEPENDENT, RepLevel.WELCOMING);
        aursia.setRelationship(Factions.LUDDIC_CHURCH, RepLevel.INHOSPITABLE);
        aursia.setRelationship(Factions.LUDDIC_PATH, RepLevel.HOSTILE);
        aursia.setRelationship(Factions.PERSEAN, RepLevel.WELCOMING);
        aursia.setRelationship(Factions.PIRATES, RepLevel.HOSTILE);
        aursia.setRelationship(Factions.REMNANTS, RepLevel.HOSTILE);
        aursia.setRelationship(Factions.TRITACHYON, RepLevel.WELCOMING);

        // Third party

        // DME
        aursia.setRelationship("dassault_mikoyan", RepLevel.NEUTRAL);
        aursia.setRelationship("blade_breakers", RepLevel.HOSTILE);

        // Diable Avionics
        aursia.setRelationship("diableavionics", RepLevel.INHOSPITABLE);

        // Tiandong
        aursia.setRelationship("tiandong", RepLevel.WELCOMING);

        // Varya's Sector
        aursia.setRelationship("ashen_keepers", RepLevel.NEUTRAL);
        aursia.setRelationship("communist_clouds", RepLevel.NEUTRAL);
        aursia.setRelationship("science_fuckers", RepLevel.NEUTRAL);
        aursia.setRelationship("warhawk_republic", RepLevel.NEUTRAL);

    }
}
