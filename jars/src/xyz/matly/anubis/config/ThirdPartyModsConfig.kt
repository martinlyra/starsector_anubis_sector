package xyz.matly.anubis.config

import org.json.JSONObject
import java.util.*

/**
 *
 * @project anubis_sector
 * @date 2020-07-13
 * @author matly
 */
class ThirdPartyModsConfig : JsonConfigurable {
    val modList = ArrayList<ThirdPartyModEntry>()

    fun getMod(modId: String?): ThirdPartyModEntry? {
        for (modEntry in modList)
            if (modEntry.defaultModId == modId)
                return modEntry
        return null
    }

    override fun consumeJson(jsonObject: JSONObject?) {
        if (jsonObject == null)
            return

        val array = jsonObject.names()
        for (idx in 0 .. array.length() - 1) {
            val key = array[idx] as String
            val entry = getOrCreate(key)
            entry.consumeJson(jsonObject.get(key) as JSONObject?)
        }
    }

    private fun getOrCreate(key : String) : ThirdPartyModEntry {
        for (modEntry in modList)
            if (modEntry.internalName == key)
                return modEntry

        return ThirdPartyModEntry(key, "", ModCompatibility.UNKNOWN)
    }
}