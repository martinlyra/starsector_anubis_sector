package xyz.matly.anubis;

/**
 * @author matly
 * @project anubis_sector
 * @date 2020-07-13
 */
public class AnubisMissingDependencyError extends Error {
    public AnubisMissingDependencyError (String dependencyName) {
        super(new StringBuilder()
                .append("Anubis Sector is dependent on '").append(dependencyName).append("' to work proper!")
                .toString()
        );
    }
}
