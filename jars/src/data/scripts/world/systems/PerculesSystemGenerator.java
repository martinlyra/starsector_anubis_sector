package data.scripts.world.systems;

import com.fs.starfarer.api.campaign.*;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.impl.campaign.ids.*;
import data.scripts.world.AddMarketplace;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
public class PerculesSystemGenerator implements SectorGeneratorPlugin
{
    @Override
    public void generate(SectorAPI sector) {

        StarSystemAPI localSystem = sector.createStarSystem("Percules");
        localSystem.setBackgroundTextureFilename("graphics/backgrounds/background6.jpg");

        LocationAPI localHyper = sector.getHyperspace();

        PlanetAPI perculesStar = localSystem.initStar(
                "percules",
                "star_white",
                250f,
                150,
                3f,
                0.1f,
                1.0f);
        localSystem.setLightColor(new Color(237,250, 241));

        SectorEntityToken localGate = localSystem.addCustomEntity(
                "percules_gate",
                "Percules Gate",
                "inactive_gate",
                null
                );
        localGate.setCircularOrbit(perculesStar, 360*(float)Math.random(), 2000, 150f);

        /*
        Create inner belt
         */
        localSystem.addAsteroidBelt(perculesStar,
                20,
                1200,
                200,
                160,
                190,
                Terrain.ASTEROID_BELT,
                "Percules Inner Belt"
        );
        localSystem.addAsteroidBelt(perculesStar,
                20,
                1500,
                200,
                160,
                190,
                Terrain.ASTEROID_BELT,
                "Percules Inner Belt"
        );
        localSystem.addRingBand(perculesStar, "misc",
                "rings_asteroids0",
                256f,
                -3,
                Color.white,
                256f,
                1200,
                140
        );
        localSystem.addRingBand(perculesStar, "misc",
                "rings_dust0",
                256f,
                1,
                Color.white,
                256f,
                1100,
                140
        );
        localSystem.addRingBand(perculesStar, "misc",
                "rings_ice0",
                256f,
                1,
                Color.white,
                256f,
                1300,
                140
        );
        localSystem.addRingBand(perculesStar, "misc",
                "rings_dust0",
                256f,
                1,
                Color.white,
                256f,
                1400,
                140
        );
        localSystem.addRingBand(perculesStar, "misc",
                "rings_asteroids0",
                256f,
                0,
                Color.white,
                256f,
                1450,
                140
        );
        localSystem.addRingBand(perculesStar, "misc",
                "rings_dust0",
                256f,
                2,
                Color.white,
                256f,
                1500,
                140
        );
        localSystem.addRingBand(perculesStar,
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
        SectorEntityToken stationTim = localSystem.addCustomEntity("anubis_station_tim",
                "Lord Tim's Castle",
                "station_mining00",
                "pirates");
        stationTim.setCircularOrbitPointingDown(perculesStar, 220, 1050, 175);

        MarketAPI timMarket = AddMarketplace.addMarketplace(
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
        PlanetAPI planetEbba = localSystem.addPlanet("anubis_planet_ebba",
                perculesStar,
                "Ebba",
                "arid",
                220,
                100, 2700,
                190f);
        planetEbba.setCustomDescriptionId("anubis_planet_ebba_desc");

        SectorEntityToken stationYukon = localSystem.addCustomEntity("anubis_station_yukon",
                "Yukon Orbital",
                "station_side02",
                "independent");
        stationYukon.setCircularOrbitPointingDown(planetEbba,75, 180, 40);
        stationYukon.setCustomDescriptionId("anubis_station_yukon_desc");
        stationYukon.setInteractionImage("illustrations", "orbital");

        MarketAPI ebbaMarket = AddMarketplace.addMarketplace(
                "independent",
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

        /*
        Create Tarantula
         */
        PlanetAPI planetTarantula = localSystem.addPlanet("anubis_planet_tarantula",
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

        localSystem.addAsteroidBelt(planetTarantula,
                10,
                500,
                50,
                40,
                80);
        localSystem.addRingBand(planetTarantula,
                "misc",
                "rings_dust0",
                256f,
                0,
                Color.white,
                256f, 450, 50
                );
        localSystem.addRingBand(planetTarantula,
                "misc",
                "rings_ice0",
                256f,
                0,
                Color.white,
                256f, 500, 50
        );

        SectorEntityToken stationPorta = localSystem.addCustomEntity("anubis_station_porta",
                "Porta",
                "station_lowtech2",
                "independent");
        stationPorta.setCircularOrbitPointingDown(planetTarantula,75, 400, 40);
        stationPorta.setCustomDescriptionId("anubis_station_porta_desc");
        stationPorta.setInteractionImage("illustrations", "orbital");

        MarketAPI tarantulaMarket = AddMarketplace.addMarketplace(
                "independent",
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

        localSystem.addAsteroidBelt(perculesStar,
                150,
                6350,
                200,
                280,
                320,
                Terrain.ASTEROID_BELT,
                "Percules Midrim Belt"
        );
        localSystem.addRingBand(perculesStar,
                "misc",
                "rings_dust0",
                256f,
                3,
                Color.white,
                256f, 6000, 50
        );
        localSystem.addRingBand(perculesStar,
                "misc",
                "rings_asteroids0",
                256f,
                3,
                Color.white,
                256f, 6100, 50
        );
        localSystem.addRingBand(perculesStar,
                "misc",
                "rings_ice0",
                256f,
                3,
                Color.white,
                256f, 6200, 50
        );
        localSystem.addRingBand(perculesStar,
                "misc",
                "rings_ice0",
                256f,
                3,
                Color.white,
                256f, 6300, 50
        );
        localSystem.addRingBand(perculesStar,
                "misc",
                "rings_asteroids0",
                256f,
                1,
                Color.white,
                256f, 6400, 50
        );
        localSystem.addRingBand(perculesStar,
                "misc",
                "rings_asteroids0",
                256f,
                3,
                Color.white,
                256f, 6500, 50
        );
        localSystem.addRingBand(perculesStar,
                "misc",
                "rings_dust0",
                256f,
                1,
                Color.white,
                256f, 6600, 50
        );

        /*
        Create Atlas
         */
        PlanetAPI planetAtlas = localSystem.addPlanet("anubis_planet_atlas",
                perculesStar,
                "Atlas",
                "gas_giant",
                50,
                200,
                8250,
                450f
        );
        planetAtlas.setCustomDescriptionId("anubis_planet_rankuk_desc");

        localSystem.addAsteroidBelt(planetAtlas,
                10,
                600,
                100,
                40,
                80);
        localSystem.addRingBand(planetAtlas,
                "misc",
                "rings_ice0",
                256f,
                1,
                Color.white,
                256f, 600, 50
        );

        SectorEntityToken stationNevestapol = localSystem.addCustomEntity("anubis_station_nevestapol",
                "Nevestapol",
                "station_side02",
                "independent"
        );
        stationNevestapol.setCircularOrbitPointingDown(planetAtlas, 0, 450, 55f);

        MarketAPI nevestapolMarket = AddMarketplace.addMarketplace(
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

        localSystem.addAsteroidBelt(perculesStar,
                120,
                12500,
                300,
                410,
                470,
                Terrain.ASTEROID_BELT,
                "Percules Outer Belt"
        );
        localSystem.addRingBand(perculesStar,
                "misc",
                "rings_asteroids0",
                256f,
                2,
                Color.white,
                256f, 12500, 50
        );

        /*
        End of system generation
         */
        localSystem.autogenerateHyperspaceJumpPoints(true, true);
    }
}
