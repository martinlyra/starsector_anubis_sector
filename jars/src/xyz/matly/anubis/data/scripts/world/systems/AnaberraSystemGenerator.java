package xyz.matly.anubis.data.scripts.world.systems;

import com.fs.starfarer.api.campaign.*;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.impl.campaign.ids.*;
import xyz.matly.anubis.data.scripts.world.utils.AddMarketplace;

import java.awt.*;
import java.util.Arrays;

@SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
public class AnaberraSystemGenerator implements CustomStarSystemGenerator
{
    @Override
    public void generate(SectorAPI sector) {
        StarSystemAPI systemAPI = sector.createStarSystem("Anaberra");
        systemAPI.setBackgroundTextureFilename("graphics/backgrounds/background2.jpg");
        systemAPI.setLightColor(new Color(255, 243, 225));

        PlanetAPI anaberraStar = systemAPI.initStar(
                "anaberra",
                "star_yellow",
                700f,
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
                1600,
                120
        );
        //ganzolaPlanet.setCustomDescriptionId("anubis_planet_ganzola_desc");

        systemAPI.addRingBand(
                anaberraStar,
                "misc",
                "rings_dust0",
                256f,
                1,
                Color.white,
                256f,
                2100,
                160
        );

        /*
        Create Haven 'Yard
         */
        SectorEntityToken stationHaven = systemAPI.addCustomEntity(
                "anubis_station_haven",
                "Haven \'Yard",
                "station_midline2",
                xyz.matly.anubis.impl.campaign.ids.Factions.AURSIA
        );
        stationHaven.setCircularOrbitPointingDown(
                anaberraStar,
                160,
                3450,
                200
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
                        Industries.GROUNDDEFENSES,

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
                "anubis_planet_medina",
                anaberraStar,
                "Medina",
                "terran",
                120,
                120,
                4250,
                260
        );
        planetMedina.setCustomDescriptionId("anubis_planet_medina_desc");

        MarketAPI medinaMarket = AddMarketplace.addMarketplace(
                Factions.INDEPENDENT,
                planetMedina,
                null,
                planetMedina.getName(),
                5,
                Arrays.asList(
                        Conditions.FARMLAND_POOR,
                        Conditions.ORGANICS_ABUNDANT,
                        Conditions.ORE_MODERATE,
                        Conditions.RARE_ORE_SPARSE,

                        Conditions.FREE_PORT,
                        Conditions.POPULATION_5,
                        Conditions.HABITABLE,
                        Conditions.TOXIC_ATMOSPHERE,
                        Conditions.DECIVILIZED_SUBPOP,
                        Conditions.RUINS_WIDESPREAD
                ),
                Arrays.asList(
                        Industries.GROUNDDEFENSES,
                        Industries.POPULATION,
                        Industries.GROUNDDEFENSES,
                        Industries.SPACEPORT,

                        Industries.FARMING,
                        Industries.MINING,
                        Industries.LIGHTINDUSTRY
                ),
                Arrays.asList(
                        Submarkets.SUBMARKET_OPEN,
                        Submarkets.SUBMARKET_STORAGE
                ),
                0.0f
        );

        SectorEntityToken relay = systemAPI.addCustomEntity(
                "anaberre_relay",
                null,
                "comm_relay_makeshift",
                xyz.matly.anubis.impl.campaign.ids.Factions.AURSIA
        );
        relay.setCircularOrbitPointingDown(anaberraStar, 0, 5100, 350);

        /*
        Create Marrus
         */
        PlanetAPI marrusPlanet = systemAPI.addPlanet(
                "anubis_planet_marrus",
                anaberraStar,
                "Marrus",
                "gas_giant",
                80,
                300,
                6600,
                450
        );

        PlanetAPI gladwellPlanet = systemAPI.addPlanet(
                "anubis_planet_gladwell",
                marrusPlanet,
                "Gladwell",
                "toxic",
                30,
                40,
                500,
                45
        );

        /*
        Create dust belt
         */
        systemAPI.addRingBand(
                anaberraStar,
                "misc",
                "rings_dust0",
                256f,
                2,
                Color.white,
                256f,
                7800,
                500
        );
        systemAPI.addRingBand(
                anaberraStar,
                "misc",
                "rings_dust0",
                256f,
                2,
                Color.white,
                256f,
                7900,
                505
        );
        systemAPI.addRingBand(
                anaberraStar,
                "misc",
                "rings_dust0",
                256f,
                3,
                Color.white,
                256f,
                8000,
                510
        );

        /*
        Create Anderson Orbital
         */
        SectorEntityToken andersonStation = systemAPI.addCustomEntity(
                "anubis_station_anderson",
                "Anderson Orbital",
                "station_side00",
                Factions.PIRATES
        );
        andersonStation.setCircularOrbitPointingDown(
                anaberraStar,
                150,
                8800,
                300f
        );
        andersonStation.setCustomDescriptionId("anubis_station_anderson_desc");
        andersonStation.setInteractionImage("illustrations", "pirate_station");

        MarketAPI andersonMarket = AddMarketplace.addMarketplace(
                andersonStation.getFaction().getId(),
                andersonStation,
                null,
                andersonStation.getName(),
                4,
                Arrays.asList(
                        Conditions.FREE_PORT,
                        Conditions.ORGANIZED_CRIME,
                        Conditions.STEALTH_MINEFIELDS,
                        Conditions.POPULATION_4
                ),
                Arrays.asList(
                        Industries.GROUNDDEFENSES,
                        Industries.POPULATION,
                        Industries.BATTLESTATION,
                        Industries.SPACEPORT,
                        Industries.PATROLHQ
                ),
                Arrays.asList(
                        Submarkets.SUBMARKET_OPEN,
                        Submarkets.SUBMARKET_BLACK,
                        Submarkets.SUBMARKET_STORAGE
                ),
                0.3f
        );

        /*
        End of system generation
         */
        systemAPI.autogenerateHyperspaceJumpPoints(true, true);
    }
}
