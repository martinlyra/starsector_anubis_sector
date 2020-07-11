package xyz.matly.anubis.data.scripts.world.utils;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.campaign.econ.EconomyAPI;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import java.util.List;
import java.util.Objects;

/**
 *
 */
public class MarketplaceHelper {

    /**
     * Shamelessly stolen from Dassault-Mikoyan's source code.
     *
     * With some changes:
     * -- It can take any implementation of List
     * -- If the conditions contain FREE_PORT, automatically set the market's free port status to true
     */
    public static MarketAPI addMarketplace(
            String factionID,
            SectorEntityToken primaryEntity,
            List<SectorEntityToken> connectedEntities,
            String name,
            int size,
            List<String> marketConditions,
            List<String> Industries,
            List<String> submarkets,
            float tariff
    ) {
        EconomyAPI globalEconomy = Global.getSector().getEconomy();
        String planetID = primaryEntity.getId();

        MarketAPI newMarket = Global.getFactory().createMarket(planetID, name, size);
        newMarket.setFactionId(factionID);
        newMarket.setPrimaryEntity(primaryEntity);
        newMarket.getTariff().modifyFlat("generator", tariff);

        if (null != submarkets){
            for (String market : submarkets){
                newMarket.addSubmarket(market);
            }
        }

        for (String condition : marketConditions) {
            if (Objects.equals(condition, Conditions.FREE_PORT)) // null-safe
            {
                newMarket.setFreePort(true);
                continue;
            }
            newMarket.addCondition(condition);
        }

        for (String industry : Industries) {
            newMarket.addIndustry(industry);
        }

        if (null != connectedEntities) {
            for (SectorEntityToken entity : connectedEntities) {
                newMarket.getConnectedEntities().add(entity);
            }
        }

        globalEconomy.addMarket(newMarket, true);
        primaryEntity.setMarket(newMarket);
        primaryEntity.setFaction(factionID);

        if (null != connectedEntities) {
            for (SectorEntityToken entity : connectedEntities) {
                entity.setMarket(newMarket);
                entity.setFaction(factionID);
            }
        }

        return newMarket;
    }
}