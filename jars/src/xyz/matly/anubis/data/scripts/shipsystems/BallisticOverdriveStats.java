package xyz.matly.anubis.data.scripts.shipsystems;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.*;
import com.fs.starfarer.api.impl.combat.BaseShipSystemScript;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

@SuppressWarnings("unused")
public class BallisticOverdriveStats extends BaseShipSystemScript {

    private final float BALLISTIC_RANGE_MODIFIER;
    private final float BALLISTIC_RATE_OF_FIRE_MULTIPLIER;
    private final float BALLISTIC_FLUX_COST_MODIFIER;

    public BallisticOverdriveStats() throws IOException, JSONException {
        super();

        JSONObject root = Global.getSettings().loadJSON("data/shipsystems/anubis_ballistic_overdrive.system");
        JSONObject mods = root.getJSONObject("modifiers");

        BALLISTIC_FLUX_COST_MODIFIER = (float) mods.getDouble("ballistic_flux_cost_mod");
        BALLISTIC_RANGE_MODIFIER = (float) mods.getDouble("ballistic_range_mod");
        BALLISTIC_RATE_OF_FIRE_MULTIPLIER = (float) mods.getDouble("ballistic_rof_mod");
    }

    @Override
    public void apply(MutableShipStatsAPI stats, String id, State state, float effectLevel) {
        stats.getBallisticRoFMult().modifyPercent(id, BALLISTIC_RATE_OF_FIRE_MULTIPLIER);
        stats.getBallisticWeaponFluxCostMod().modifyPercent(id, BALLISTIC_FLUX_COST_MODIFIER);
        stats.getBallisticWeaponRangeBonus().modifyPercent(id, BALLISTIC_RANGE_MODIFIER);
    }

    @Override
    public StatusData getStatusData(int index, State state, float effectLevel) {
        return super.getStatusData(index, state, effectLevel);
    }

    @Override
    public void unapply(MutableShipStatsAPI stats, String id) {
        stats.getBallisticRoFMult().unmodify(id);
        stats.getBallisticWeaponFluxCostMod().unmodify(id);
        stats.getBallisticWeaponRangeBonus().unmodify(id);
    }

}
