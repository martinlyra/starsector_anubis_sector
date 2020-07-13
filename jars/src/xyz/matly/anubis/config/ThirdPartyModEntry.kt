package xyz.matly.anubis.config

import com.fs.starfarer.api.Global
import com.fs.starfarer.api.ModSpecAPI
import com.fs.starfarer.api.SettingsAPI
import org.json.JSONObject
import xyz.matly.anubis.AnubisSectorGlobal

/**
 *
 * @project anubis_sector
 * @date 2020-07-13
 * @author matly
 */
class ThirdPartyModEntry (
        val internalName : String,
        val defaultModId : String,
        var compatibility: ModCompatibility
) : JsonConfigurable {

    init {
        AnubisSectorGlobal.getConfig().thirdPartyModsConfig.modList.add(this)
    }

    private var isFoundInternal : Boolean? = null
    private var modSpecAPI : ModSpecAPI? = null
    var overrideModId : String? = null

    fun isFound() : Boolean {
        if (isFoundInternal == null)
            find(Global.getSettings())
        return isFoundInternal as Boolean
    }

    private fun tryGetMod(modId : String, settings: SettingsAPI) : Boolean {
        var result = settings.modManager.isModEnabled(modId)
        if (result)
            modSpecAPI = settings.modManager.getModSpec(modId)
        return result
    }

    fun find(settings : SettingsAPI) : Boolean {
        if (isFoundInternal == null) {
            var result : Boolean
            if (overrideModId != null) {
                result = tryGetMod(overrideModId as String, settings)
                if (!result)
                    isFoundInternal = tryGetMod(defaultModId, settings)
                else isFoundInternal = result
            }
            else
                isFoundInternal = tryGetMod(defaultModId, settings)
        }
        return isFoundInternal as Boolean
    }

    fun getSpecifications() : ModSpecAPI? {
        return modSpecAPI
    }

    fun getModId() : String {
        if (overrideModId != null)
            return overrideModId as String
        return defaultModId;
    }

    override fun consumeJson(jsonObject: JSONObject?) {
        if (jsonObject == null) return

        overrideModId = jsonObject.get("modId") as String?
        compatibility = ModCompatibility.valueOf(jsonObject.get("compatibility") as String)
    }
}