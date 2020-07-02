package xyz.matly.anubis;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;

import exerelin.campaign.SectorManager;

import org.json.JSONException;
import org.json.JSONObject;
import xyz.matly.anubis.data.scripts.AnubisSectorGeneratorPlugin;

import java.io.IOException;

public class AnubisSectorModPlugin extends BaseModPlugin {

    private final static String LOCAL_MOD_SETTINGS_PATH = "mod_settings.json";

    private boolean isNexerelinFound = false;

    private void loadJsonSettings() throws IOException, JSONException {
        JSONObject settings = Global.getSettings().loadJSON(LOCAL_MOD_SETTINGS_PATH);
    }

    @Override
    public void onApplicationLoad() throws Exception {
        try {
            loadJsonSettings();
        } catch (Exception e) {

        }
        isNexerelinFound = ThirdPartyModsUtils.findNexerelin(Global.getSettings());
    }

    @Override
    public void onGameLoad(boolean newGame) {

    }

    public boolean shouldGenerate() {
        if (isNexerelinFound && !SectorManager.getManager().isCorvusMode())
            return false;
        return true;
    }

    @Override
    public void onNewGame() {
        if (!shouldGenerate())  return;

        new AnubisSectorGeneratorPlugin().generate(Global.getSector());
    }
}
