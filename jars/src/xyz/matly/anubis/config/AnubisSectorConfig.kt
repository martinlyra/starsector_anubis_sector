package xyz.matly.anubis.config

import org.json.JSONObject

/**
 * Config data model, created by AnubisSectorGlobal.java, use AnubisSectorGlobal.getConfig() to get the singleton.
 *
 * As an extra note, this class is initialized soon as this mod's jar is loaded by the game, specifically when the
 * SupportedMods interface's constants are initialized. Because these constants' constructor use the getConfig()
 * singleton function when adding themselves to the ThirdPartyModsConfig within AnubisSectorConfig. Do you wonder why?
 * Oh well then, too bad! Cause I don't have an answer!
 *
 * @project anubis_sector
 * @date 2020-07-13
 * @author matly
 */
class AnubisSectorConfig : JsonConfigurable {
    var crashOnIncompatibility : Boolean = false
    var alwaysUseVanillaRelations : Boolean = true
    var anubisFactionsEnabled : Boolean = true
    var anubisSystemsEnabled : Boolean = true
    
    val thirdPartyModsConfig = ThirdPartyModsConfig()

    override fun consumeJson(root : JSONObject) {
        alwaysUseVanillaRelations = root.getBoolean(ConfigKeys.ALWAYS_USE_VANILLA_RELATIONS)
        anubisFactionsEnabled = root.getBoolean(ConfigKeys.ENABLE_ANUBIS_FACTIONS)
        anubisSystemsEnabled = root.getBoolean(ConfigKeys.ENABLE_ANUBIS_SYSTEMS)

        crashOnIncompatibility = root.getBoolean(ConfigKeys.CRASH_ON_INCOMPATIBILITY)
        val modList = root.getJSONObject(ConfigKeys.THIRD_PARTY_MODS_CONFIG)
        thirdPartyModsConfig.consumeJson(modList);
    }
}
