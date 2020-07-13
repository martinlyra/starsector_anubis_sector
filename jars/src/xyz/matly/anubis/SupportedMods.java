package xyz.matly.anubis;

import xyz.matly.anubis.config.ModCompatibility;
import xyz.matly.anubis.config.ThirdPartyModEntry;

/**
 * Not a "whitelist", rather a list of mods that this mod make use of and implement for extra function & content.
 * Hardcoded to make these more accessible from the mod's own code. These should automatically add themselves to the
 * ThirdPartyModsConfig.
 *
 * @author matly
 * @project anubis_sector
 * @date 2020-07-13
 */
public interface SupportedMods {
    ThirdPartyModEntry LAZYLIB = new ThirdPartyModEntry(
            "LAZYLIB", "lw_lazylib", ModCompatibility.DEPENDENCY
    );
    ThirdPartyModEntry NEXERELIN = new ThirdPartyModEntry(
            "NEXERELIN","nexerelin", ModCompatibility.SUPPORTED
    );
    ThirdPartyModEntry VAYRAS_SECTOR = new ThirdPartyModEntry(
            "VAYRAS_SECTOR", "vayrasector", ModCompatibility.SUPPORTED
    );
}
