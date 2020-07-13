package xyz.matly.anubis.data.scripts.utils;

import com.fs.starfarer.api.combat.CombatEntityAPI;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.plugins.ShipSystemStatsScript;

/**
 * @author matly
 * @project anubis_sector
 * @date 2020-07-13
 */
public class HullSystemHelper {
    public static ShipAPI getShipAPIElseNull(MutableShipStatsAPI statsAPI) {
        CombatEntityAPI entityAPI = statsAPI.getEntity();
        if (entityAPI instanceof ShipAPI) return (ShipAPI) entityAPI;
        return null;
    }
}
