package xyz.matly.anubis.config;

import org.json.JSONObject;

/**
 * @author matly
 * @project anubis_sector
 * @date 2020-07-13
 */
public interface JsonConfigurable {
    void consumeJson(JSONObject jsonObject);
}
