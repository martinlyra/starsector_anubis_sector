package data.scripts;

import com.fs.starfarer.api.SettingsAPI;

class ThirdPartyModsUtils {
    private static Boolean isNexerelinFoundCache;
    static boolean findNexerelin(SettingsAPI settingsAPI) {
        if (isNexerelinFoundCache == null) {
            isNexerelinFoundCache = settingsAPI.getModManager().isModEnabled("nexerelin");
        }
        return isNexerelinFoundCache;
    }
}
