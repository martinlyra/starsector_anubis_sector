package xyz.matly.anubis;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;

import com.fs.starfarer.api.ModSpecAPI;
import exerelin.campaign.SectorManager;

import org.json.JSONException;
import org.json.JSONObject;
import xyz.matly.anubis.config.ModCompatibility;
import xyz.matly.anubis.config.ThirdPartyModEntry;
import xyz.matly.anubis.data.scripts.AnubisSectorGeneratorPlugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class AnubisSectorModPlugin extends BaseModPlugin {
    private final static String LOCAL_MOD_SETTINGS_PATH = "mod_settings.json";

    private void loadJsonSettings() throws IOException, JSONException {
        JSONObject settings = Global.getSettings().loadJSON(LOCAL_MOD_SETTINGS_PATH);
        if (settings == null)
            throw new JSONException(LOCAL_MOD_SETTINGS_PATH + " file contains no valid JSON. Did it get corrupt?");

        AnubisSectorGlobal.getConfig().consumeJson(settings);
    }

    @Override
    public void onApplicationLoad() throws IOException, JSONException, AnubisModIncompatibilityException {
        loadJsonSettings();

        compatibilityCheck();
    }

    private void compatibilityCheck() throws AnubisModIncompatibilityException {
        boolean incompatible = false;
        List<String> culprits = new ArrayList();

        for (ThirdPartyModEntry entry :
                AnubisSectorGlobal.getConfig().getThirdPartyModsConfig().getModList()) {
            if (entry.getCompatibility() == ModCompatibility.INCOMPATIBLE
                    && entry.isFound()) {
                incompatible = true;
                ModSpecAPI specAPI = entry.getSpecifications();
                if (specAPI == null) {
                    culprits.add("Mod with ID: '"+entry.getModId()+ "'");
                }
                else {
                    culprits.add(entry.getSpecifications().getName());
                }
            }
        }

        if (incompatible) {
            if (AnubisSectorGlobal.getConfig().getCrashOnIncompatibility()) {
                throw new AnubisModIncompatibilityException(culprits);
            }
        }
    }

    @Override
    public void onGameLoad(boolean newGame) {

    }

    @SuppressWarnings("RedundantIfStatement")
    private boolean shouldGenerate() {
        if (SupportedMods.NEXERELIN.isFound() && !SectorManager.getManager().isCorvusMode())
            return false;
        return true;
    }

    @Override
    public void onNewGame() {
        if (!shouldGenerate())  return;

        new AnubisSectorGeneratorPlugin().generate(Global.getSector());
    }
}
