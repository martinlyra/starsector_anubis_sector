package xyz.matly.anubis.data.scripts;

import com.fs.starfarer.api.SettingsAPI;

public class ThirdPartyModsUtils {
    private static Boolean isNexerelinFoundCache;
    static boolean findNexerelin(SettingsAPI settingsAPI) {
        if (isNexerelinFoundCache == null) {
            isNexerelinFoundCache = settingsAPI.getModManager().isModEnabled("nexerelin");
        }
        return isNexerelinFoundCache;
    }
}
