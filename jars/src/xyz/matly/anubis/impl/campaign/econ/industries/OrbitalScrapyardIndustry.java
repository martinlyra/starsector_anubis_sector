package xyz.matly.anubis.impl.campaign.econ.industries;

import com.fs.starfarer.api.impl.campaign.econ.impl.BaseIndustry;
import com.fs.starfarer.api.impl.campaign.ids.Commodities;

public class OrbitalScrapyardIndustry extends BaseIndustry {
    @Override
    public void apply() {
        super.apply(true);

        if (!isFunctional()) {
            supply.clear();
            demand.clear();
            return;
        }

        supply(Commodities.SHIPS, 3);
        supply(Commodities.METALS, 5);
        supply(Commodities.RARE_METALS, 5);

        demand(Commodities.CREW, 5);
        demand(Commodities.HEAVY_MACHINERY, 5);
        demand(Commodities.FUEL, 5);
    }

    @Override
    public boolean isAvailableToBuild() {
        return false;
    }

    @Override
    public boolean showWhenUnavailable() {
        return false;
    }
}
