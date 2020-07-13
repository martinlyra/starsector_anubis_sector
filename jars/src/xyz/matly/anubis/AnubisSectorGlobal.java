package xyz.matly.anubis;

import xyz.matly.anubis.config.AnubisSectorConfig;

/**
 * Global values that are meant to be only used within Anubis Sector mod and not shared with other mods. Please make an
 * issue at the starsector_anubis_sector repo @ Github if you think that there are some stuff that should be exposed
 * to other mods. Thank you!
 *
 * @author matly
 * @project anubis_sector
 * @date 2020-07-13
 */
public class AnubisSectorGlobal {
    private static AnubisSectorConfig localConfig;

    public static AnubisSectorConfig getConfig() {
        if (localConfig == null)
            localConfig = new AnubisSectorConfig();
        return localConfig;
    }
}
