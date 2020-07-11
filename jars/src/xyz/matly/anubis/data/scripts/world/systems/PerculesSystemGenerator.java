package xyz.matly.anubis.data.scripts.world.systems;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.*;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.impl.campaign.ids.*;
import com.fs.starfarer.api.util.Misc;
import xyz.matly.anubis.data.scripts.world.utils.MarketplaceHelper;
import xyz.matly.anubis.data.scripts.world.utils.HyperspaceCleaner;

import java.awt.*;
import java.util.Arrays;

@SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
public class PerculesSystemGenerator implements CustomStarSystemGenerator
{
    @Override
    public void generate(SectorAPI sector) {

        StarSystemAPI systemAPI = sector.createStarSystem("Percules");
        systemAPI.setBackgroundTextureFilename("graphics/backgrounds/background6.jpg");

        //LocationAPI localHyper = sector.getHyperspace();

        PlanetAPI perculesStar = systemAPI.initStar(
                "percules",
                "star_white",
                250f,
                250,
                3f,
                0.1f,
                1.0f);
        systemAPI.setLightColor(new Color(237,250, 241));

        JumpPointAPI innerJumpPoint = Global.getFactory().createJumpPoint(
                "percules_jp_inner",
                "Inner Jump-point"
        );
        innerJumpPoint.setCircularOrbit(perculesStar, 40, 800, 175);
        systemAPI.addEntity(innerJumpPoint);

        SectorEntityToken localGate = systemAPI.addCustomEntity(
                "percules_gate",
                "Percules Gate",
                "inactive_gate",
                null
                );
        localGate.setCircularOrbit(perculesStar, 360*(float)Math.random(), 2000, 150f);

        /*
        Create inner belt
         */
        systemAPI.addAsteroidBelt(perculesStar,
                20,
                1200,
                200,
                160,
                190,
                Terrain.ASTEROID_BELT,
                "Percules Inner Belt"
        );
        systemAPI.addAsteroidBelt(perculesStar,
                20,
                1500,
                200,
                160,
                190,
                Terrain.ASTEROID_BELT,
                "Percules Inner Belt"
        );
        systemAPI.addRingBand(perculesStar, "misc",
                "rings_asteroids0",
                256f,
                -3,
                Color.white,
                256f,
                1200,
                140
        );
        systemAPI.addRingBand(perculesStar, "misc",
                "rings_dust0",
                256f,
                1,
                Color.white,
                256f,
                1100,
                140
        );
        systemAPI.addRingBand(perculesStar, "misc",
                "rings_ice0",
                256f,
                1,
                Color.white,
                256f,
                1300,
                140
        );
        systemAPI.addRingBand(perculesStar, "misc",
                "rings_dust0",
                256f,
                1,
                Color.white,
                256f,
                1400,
                140
        );
        systemAPI.addRingBand(perculesStar, "misc",
                "rings_asteroids0",
                256f,
                0,
                Color.white,
                256f,
                1450,
                140
        );
        systemAPI.addRingBand(perculesStar, "misc",
                "rings_dust0",
                256f,
                2,
                Color.white,
                256f,
                1500,
                140
        );
        systemAPI.addRingBand(perculesStar,
                "misc",
                "rings_dust0",
                256f,
                1,
                Color.white,
                256f, 1600, 50
        );

        /*
        Create Lord Tim's Castle
         */
        SectorEntityToken stationTim = systemAPI.addCustomEntity("anubis_station_tim",
                "Lord Tim's Castle",
                "station_mining00",
                Factions.PIRATES);
        stationTim.setInteractionImage("illustrations", "pirate_station");
        stationTim.setCircularOrbitPointingDown(perculesStar, 220, 1050, 175);
        stationTim.setCustomDescriptionId("anubis_station_tim_desc");

        MarketAPI timMarket = MarketplaceHelper.addMarketplace(
                stationTim.getFaction().getId(),
                stationTim,
                null,
                stationTim.getName(),
                4,
                Arrays.asList(
                        Conditions.FREE_PORT,
                        Conditions.STEALTH_MINEFIELDS,
                        Conditions.ORGANIZED_CRIME,
                        Conditions.POPULATION_4
                ),
                Arrays.asList(
                        Industries.BATTLESTATION_MID,
                        Industries.WAYSTATION,
                        Industries.SPACEPORT,
                        Industries.MINING,
                        Industries.MILITARYBASE,
                        Industries.POPULATION,
                        Industries.GROUNDDEFENSES
                ),
                Arrays.asList(
                        Submarkets.GENERIC_MILITARY,
                        Submarkets.SUBMARKET_BLACK,
                        Submarkets.SUBMARKET_OPEN,
                        Submarkets.SUBMARKET_STORAGE
                ),
                0.10f
        );

        /*
        Create Ebba
         */
        PlanetAPI planetEbba = systemAPI.addPlanet("anubis_planet_ebba",
                perculesStar,
                "Ebba",
                "arid",
                220,
                100, 2700,
                190f);
        planetEbba.setCustomDescriptionId("anubis_planet_ebba_desc");
        planetEbba.setInteractionImage("illustrations", "mine");

        SectorEntityToken stationYukon = systemAPI.addCustomEntity("anubis_station_yukon",
                "Yukon Orbital",
                "station_side02",
                xyz.matly.anubis.impl.campaign.ids.Factions.AURSIA
        );
        stationYukon.setCircularOrbitPointingDown(planetEbba,75, 180, 40);
        stationYukon.setCustomDescriptionId("anubis_station_yukon_desc");
        stationYukon.setInteractionImage("illustrations", "orbital");

        MarketAPI ebbaMarket = MarketplaceHelper.addMarketplace(
                stationYukon.getFaction().getId(),
                planetEbba,
                Arrays.asList(stationYukon),
                planetEbba.getName(),
                6,
                Arrays.asList(
                        Conditions.ORE_RICH,
                        Conditions.RARE_ORE_SPARSE,
                        Conditions.ORGANICS_TRACE,
                        Conditions.FARMLAND_POOR,

                        Conditions.FREE_PORT,
                        Conditions.POPULATION_6,
                        Conditions.HOT,
                        Conditions.HABITABLE
                ),
                Arrays.asList(
                        Industries.POPULATION,
                        Industries.MEGAPORT,
                        Industries.GROUNDDEFENSES,
                        Industries.BATTLESTATION_HIGH,
                        Industries.WAYSTATION,
                        Industries.PATROLHQ,
                        Industries.MINING,
                        Industries.LIGHTINDUSTRY,
                        Industries.REFINING,
                        Industries.FUELPROD
                ),
                Arrays.asList(
                        Submarkets.SUBMARKET_OPEN,
                        Submarkets.SUBMARKET_BLACK,
                        Submarkets.SUBMARKET_STORAGE
                ),
                0.05f
        );

        systemAPI.addRingBand(perculesStar,
                "misc",
                "rings_dust0",
                256f,
                2,
                Color.white,
                256f, 3100, 120
        );

        SectorEntityToken midRelay = systemAPI.addCustomEntity("percules_aursia_relay",
                null,
                "comm_relay",
                xyz.matly.anubis.impl.campaign.ids.Factions.AURSIA);
        midRelay.setCircularOrbitPointingDown(perculesStar, 180, 3100, 120);

        SectorEntityToken midBuoy = systemAPI.addCustomEntity("percules_aursia_buoy",
                null,
                "nav_buoy",
                xyz.matly.anubis.impl.campaign.ids.Factions.AURSIA);
        midBuoy.setCircularOrbitPointingDown(perculesStar, 0, 3100, 120);

        /*
        Create Tarantula
         */
        PlanetAPI planetTarantula = systemAPI.addPlanet("anubis_planet_tarantula",
                perculesStar,
                "Tarantula",
                "tundra",
                120,
                150, 4500,
                220f);
        planetTarantula.getSpec().setCloudRotation(30f);
        planetTarantula.applySpecChanges();
        planetTarantula.setCustomDescriptionId("anubis_planet_tarantula_desc");
        planetTarantula.setInteractionImage("illustrations", "city_from_above");

        systemAPI.addAsteroidBelt(planetTarantula,
                10,
                500,
                50,
                40,
                80);
        systemAPI.addRingBand(planetTarantula,
                "misc",
                "rings_dust0",
                256f,
                0,
                Color.white,
                256f, 450, 50
                );
        systemAPI.addRingBand(planetTarantula,
                "misc",
                "rings_ice0",
                256f,
                0,
                Color.white,
                256f, 500, 50
        );

        SectorEntityToken stationPorta = systemAPI.addCustomEntity("anubis_station_porta",
                "Porta",
                "station_lowtech2",
                xyz.matly.anubis.impl.campaign.ids.Factions.AURSIA);
        stationPorta.setCircularOrbitPointingDown(planetTarantula,75, 400, 40);
        stationPorta.setCustomDescriptionId("anubis_station_porta_desc");
        stationPorta.setInteractionImage("illustrations", "orbital");

        MarketAPI tarantulaMarket = MarketplaceHelper.addMarketplace(
                stationPorta.getFaction().getId(),
                planetTarantula,
                Arrays.asList(stationPorta),
                planetTarantula.getName(),
                8,
                Arrays.asList(
                        Conditions.ORE_RICH,
                        Conditions.RARE_ORE_ULTRARICH,
                        Conditions.VOLATILES_DIFFUSE,
                        Conditions.ORGANICS_PLENTIFUL,
                        Conditions.FARMLAND_POOR,

                        Conditions.FREE_PORT,
                        Conditions.POPULATION_8,
                        Conditions.HABITABLE,
                        Conditions.COLD
                ),
                Arrays.asList(
                        Industries.POPULATION,
                        Industries.MEGAPORT,
                        Industries.HEAVYBATTERIES,
                        Industries.STARFORTRESS_HIGH,
                        Industries.WAYSTATION,
                        Industries.HIGHCOMMAND,
                        Industries.FARMING,
                        Industries.MINING,
                        Industries.LIGHTINDUSTRY,
                        Industries.REFINING
                ),
                Arrays.asList(
                        Submarkets.GENERIC_MILITARY,
                        Submarkets.SUBMARKET_OPEN,
                        Submarkets.SUBMARKET_BLACK,
                        Submarkets.SUBMARKET_STORAGE
                ),
                0.05f
        );
        tarantulaMarket.addIndustry(Industries.ORBITALWORKS, Arrays.asList(Items.PRISTINE_NANOFORGE));

        /*
        Create mid-belt
         */

        systemAPI.addAsteroidBelt(perculesStar,
                150,
                6350,
                200,
                280,
                320,
                Terrain.ASTEROID_BELT,
                "Percules Midrim Belt"
        );
        systemAPI.addRingBand(perculesStar,
                "misc",
                "rings_dust0",
                256f,
                2,
                Color.white,
                256f, 5600, 150
        );
        systemAPI.addRingBand(perculesStar,
                "misc",
                "rings_asteroids0",
                256f,
                3,
                Color.white,
                256f, 5700, 160
        );
        systemAPI.addRingBand(perculesStar,
                "misc",
                "rings_dust0",
                256f,
                3,
                Color.white,
                256f, 5800, 170
        );
        systemAPI.addRingBand(perculesStar,
                "misc",
                "rings_dust0",
                256f,
                3,
                Color.white,
                256f, 6000, 180
        );
        systemAPI.addRingBand(perculesStar,
                "misc",
                "rings_asteroids0",
                256f,
                3,
                Color.white,
                256f, 6100, 190
        );
        systemAPI.addRingBand(perculesStar,
                "misc",
                "rings_ice0",
                256f,
                3,
                Color.white,
                256f, 6200, 200
        );
        systemAPI.addRingBand(perculesStar,
                "misc",
                "rings_ice0",
                256f,
                3,
                Color.white,
                256f, 6300, 210
        );
        systemAPI.addRingBand(perculesStar,
                "misc",
                "rings_asteroids0",
                256f,
                1,
                Color.white,
                256f, 6400, 220
        );
        systemAPI.addRingBand(perculesStar,
                "misc",
                "rings_asteroids0",
                256f,
                3,
                Color.white,
                256f, 6500, 230
        );
        systemAPI.addRingBand(perculesStar,
                "misc",
                "rings_dust0",
                256f,
                1,
                Color.white,
                256f, 6600, 240
        );

        SectorEntityToken beltSensors = systemAPI.addCustomEntity("percules_aursia_sensors",
                null,
                "sensor_array_makeshift",
                xyz.matly.anubis.impl.campaign.ids.Factions.AURSIA);
        beltSensors.setCircularOrbitPointingDown(perculesStar, 40, 6300, 440);

        /*
        Create Atlas
         */
        PlanetAPI planetAtlas = systemAPI.addPlanet("anubis_planet_atlas",
                perculesStar,
                "Atlas",
                "gas_giant",
                1900,
                300,
                8250,
                450f
        );
        //planetAtlas.setCustomDescriptionId("anubis_planet_atlas_desc");

        systemAPI.addAsteroidBelt(planetAtlas,
                10,
                600,
                100,
                40,
                80);
        systemAPI.addRingBand(planetAtlas,
                "misc",
                "rings_ice0",
                256f,
                1,
                Color.white,
                256f, 600, 50
        );

        SectorEntityToken stationNevestapol = systemAPI.addCustomEntity("anubis_station_nevestapol",
                "Nevestapol",
                "station_side02",
                Factions.INDEPENDENT
        );
        stationNevestapol.setCircularOrbitPointingDown(planetAtlas, 0, 450, 55f);
        stationNevestapol.setCustomDescriptionId("anubis_station_nevestapol_desc");

        SectorEntityToken giantRelay = systemAPI.addCustomEntity("percules_atlas_relay",
                null,
                "comm_relay",
                Factions.INDEPENDENT);
        giantRelay.setCircularOrbitPointingDown(planetAtlas, 180, 700, 440);

        MarketAPI nevestapolMarket = MarketplaceHelper.addMarketplace(
                stationNevestapol.getFaction().getId(),
                stationNevestapol,
                null,
                stationNevestapol.getName(),
                6,
                Arrays.asList(
                        Conditions.ORE_MODERATE,
                        Conditions.RARE_ORE_MODERATE,
                        Conditions.VOLATILES_ABUNDANT,

                        Conditions.FREE_PORT,
                        Conditions.POPULATION_6
                ),
                Arrays.asList(
                        Industries.POPULATION,
                        Industries.MEGAPORT,
                        Industries.HEAVYBATTERIES,
                        Industries.STARFORTRESS,
                        Industries.WAYSTATION,
                        Industries.PATROLHQ,
                        Industries.MINING,
                        Industries.LIGHTINDUSTRY,
                        Industries.REFINING
                ),
                Arrays.asList(
                        Submarkets.GENERIC_MILITARY,
                        Submarkets.SUBMARKET_OPEN,
                        Submarkets.SUBMARKET_BLACK,
                        Submarkets.SUBMARKET_STORAGE
                ),
                0.10f
        );
        nevestapolMarket.addIndustry(Industries.ORBITALWORKS, Arrays.asList(Items.DECAYED_NANOFORGE));

        /*
        Create outer-belt
         */

        systemAPI.addAsteroidBelt(perculesStar,
                120,
                12500,
                300,
                410,
                470,
                Terrain.ASTEROID_BELT,
                "Percules Outer Belt"
        );
        systemAPI.addRingBand(perculesStar,
                "misc",
                "rings_asteroids0",
                256f,
                3,
                Color.white,
                256f, 12400, 50
        );
        systemAPI.addRingBand(perculesStar,
                "misc",
                "rings_asteroids0",
                256f,
                2,
                Color.white,
                256f, 12500, 50
        );
        systemAPI.addRingBand(perculesStar,
                "misc",
                "rings_dust0",
                256f,
                3,
                Color.white,
                256f, 12600, 50
        );

        SectorEntityToken fringeSensors = systemAPI.addCustomEntity("percules_pirate_relay",
                null,
                "comm_relay_makeshift",
                Factions.PIRATES);
        fringeSensors.setCircularOrbitPointingDown(perculesStar, 250, 12850, 440);

        /*
        Create Junara + Castillo
         */

        PlanetAPI planetJunara = systemAPI.addPlanet("anubis_planet_junara",
                perculesStar,
                "Junara",
                "ice_giant",
                300,
                250,
                13500,
                480
        );
        //planetJunara.setCustomDescriptionId("anubis_planet_junara_desc");

        Misc.initConditionMarket(planetJunara);
        MarketAPI junaraMarket = planetJunara.getMarket();
        junaraMarket.addCondition(Conditions.VERY_COLD);
        junaraMarket.addCondition(Conditions.EXTREME_WEATHER);
        junaraMarket.addCondition(Conditions.HIGH_GRAVITY);
        junaraMarket.addCondition(Conditions.VOLATILES_ABUNDANT);

        PlanetAPI planetCastillo = systemAPI.addPlanet("anubis_planet_castillo",
                planetJunara,
                "Castillo",
                "frozen1",
                10,
                80,
                600,
                45
        );
        planetCastillo.setCustomDescriptionId("anubis_planet_castillo_desc");
        planetCastillo.setInteractionImage("illustrations", "vacuum_colony");

        SectorEntityToken stationAmanda = systemAPI.addCustomEntity("anubis_station_amanda",
                "Amanda Orbital",
                "station_mining00",
                Factions.PIRATES
        );
        stationAmanda.setCustomDescriptionId("anubis_station_amanda_desc");
        stationAmanda.setCircularOrbitPointingDown(planetCastillo, 0, 110, 55f);

        MarketAPI castilloMarket = MarketplaceHelper.addMarketplace(
                stationAmanda.getFaction().getId(),
                planetCastillo,
                Arrays.asList(stationAmanda),
                planetCastillo.getName(),
                5,
                Arrays.asList(
                        Conditions.ORGANIZED_CRIME,
                        Conditions.STEALTH_MINEFIELDS,
                        Conditions.FREE_PORT,
                        Conditions.THIN_ATMOSPHERE,
                        Conditions.VERY_COLD,
                        Conditions.POOR_LIGHT,
                        Conditions.POPULATION_5,

                        Conditions.ORE_MODERATE,
                        Conditions.RARE_ORE_MODERATE,
                        Conditions.VOLATILES_DIFFUSE
                ),
                Arrays.asList(
                        Industries.STARFORTRESS,
                        Industries.GROUNDDEFENSES,
                        Industries.POPULATION,
                        Industries.MINING,
                        //Industries.REFINING,
                        //Industries.LIGHTINDUSTRY,
                        Industries.PATROLHQ,
                        Industries.WAYSTATION
                ),
                Arrays.asList(
                        Submarkets.SUBMARKET_BLACK,
                        Submarkets.SUBMARKET_OPEN,
                        Submarkets.SUBMARKET_STORAGE
                ),
                0.10f
        );

        /*
        End of system generation
         */
        systemAPI.autogenerateHyperspaceJumpPoints(
                true,
                true,
                true
        );
        HyperspaceCleaner.cleanUp(systemAPI);
    }
}
