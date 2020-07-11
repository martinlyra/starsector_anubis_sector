package xyz.matly.anubis.data.scripts.world.factions;

import com.fs.starfarer.api.campaign.FactionAPI;
import com.fs.starfarer.api.campaign.RepLevel;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.impl.campaign.ids.Factions;
import com.fs.starfarer.api.impl.campaign.shared.SharedData;

public final class AursiaSetupPlugin extends CustomFactionSetupPlugin {
    @Override
    protected void setupData(SectorAPI sector) {
       SharedData.getData().getPersonBountyEventData().addParticipatingFaction(xyz.matly.anubis.impl.campaign.ids.Factions.AURSIA);
    }

    @Override
    protected void setupRelations(SectorAPI sector) {
        FactionAPI aursia = sector.getFaction(xyz.matly.anubis.impl.campaign.ids.Factions.AURSIA);

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
