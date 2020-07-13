package xyz.matly.anubis;

import java.util.List;

/**
 * This sucks.
 *
 * @author matly
 * @project anubis_sector
 * @date 2020-07-13
 */
public class AnubisModIncompatibilityException extends Exception {
    public AnubisModIncompatibilityException(List<String> culprits) {
        super(makeMessage(culprits));
    }

    private static String makeMessage(List<String> culprits) {
        StringBuilder builder = new StringBuilder();
        builder.append("Anubis Sector mod is not compatible with these mod(s):\n");
        for (String culprit : culprits) {
            builder.append(" - ");
            builder.append(culprit);
            builder.append('\n');
        }
        builder.append("Please consider disabling this mod or those listed, or set 'crashOnIncompatibility' to 'false'"
                + " in Anubis Sector's 'mod_settings.json' to use them together on your own risk.");
        return builder.toString();
    }
}
