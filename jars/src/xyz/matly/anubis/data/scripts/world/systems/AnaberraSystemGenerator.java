package data.scripts.world.systems;

import com.fs.starfarer.api.campaign.*;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.impl.campaign.ids.Conditions;
import com.fs.starfarer.api.impl.campaign.ids.Factions;
import com.fs.starfarer.api.impl.campaign.ids.Industries;
import com.fs.starfarer.api.impl.campaign.ids.Submarkets;
import data.scripts.world.utils.AddMarketplace;

import java.awt.*;
import java.util.Arrays;

@SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
public class AnaberraSystemGenerator implements CustomStarSystemGenerator
{
    @Override
    public void generate(SectorAPI sector) {
        StarSystemAPI systemAPI = sector.createStarSystem("anaberra");
        systemAPI.setBackgroundTextureFilename("graphics/backgrounds/background2.jpg");
        systemAPI.setLightColor(new Color(255, 243, 225));

        PlanetAPI anaberraStar = systemAPI.initStar(
                "anabeera",
                "star_yellow",
                600f,
                500,
                3f,
                0.3f,
                1.0f
        );

        /*
        Create Ganzola
         */
        PlanetAPI ganzolaPlanet = systemAPI.addPlanet(
                "anubis_planet_ganzola",
                anaberraStar,
                "Ganzola",
                "barren",
                60,
                60,
                1200,
                120
        );
        ganzolaPlanet.setCustomDescriptionId("anubis_planet_ganzola_desc");

        systemAPI.addRingBand(
                anaberraStar,
                "misc",
                "ring_dust0",
                256f,
                1,
                Color.white,
                256f,
                1400,
                130
        );

        /*
        Create Haven 'Yard
         */
        SectorEntityToken stationHaven = systemAPI.addCustomEntity(
                "anubis_station_haven",
                "Haven \'Yard",
                "station_midline2",
                data.campaign.ids.Factions.AURSIA
        );
        stationHaven.setCircularOrbitPointingDown(
                anaberraStar,
                160,
                1650,
                160
        );
        stationHaven.setCustomDescriptionId("anubis_station_haven_desc");

        MarketAPI havenMarket = AddMarketplace.addMarketplace(
                "aursia",
                stationHaven,
                null,
                stationHaven.getName(),
                5,
                Arrays.asList(
                        Conditions.POPULATION_5
                ),
                Arrays.asList(
                        Industries.POPULATION,
                        Industries.WAYSTATION,
                        Industries.PATROLHQ,
                        Industries.SPACEPORT,
                        Industries.BATTLESTATION_MID,

                        Industries.ORBITALWORKS
                ),
                Arrays.asList(
                        Submarkets.GENERIC_MILITARY,
                        Submarkets.SUBMARKET_OPEN,
                        Submarkets.SUBMARKET_BLACK,
                        Submarkets.SUBMARKET_STORAGE
                ),
                0.10f
        );

        /*
        Create Medina
         */
        PlanetAPI planetMedina = systemAPI.addPlanet(
                "anubis_sector_medina",
                anaberraStar,
                "Medina",
                "terran",
                120,
                120,
                1800,
                200
        );
        planetMedina.setCustomDescriptionId("anubis_sector_medina_desc");

        MarketAPI medinaMarket = AddMarketplace.addMarketplace(
                Factions.INDEPENDENT,

        )
    }
}
