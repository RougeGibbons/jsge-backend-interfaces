package ru.rougegibbons.jsge.engine.versions;

import org.jetbrains.annotations.NotNull;

/**
 * class storing engine part (instance, system, etc.) version data. Used in parsing config files.
 *
 * @author Kirill Cherkasov
 * @see Integer
 * @since 0.0.1
 */
public final class VersionInfo {
    public static final String VERSION_SEPARATOR = ".";
    public static final int DEFAULT_VERSION_VALUE = 0;

    private Integer versionBuild;
    private Integer versionMinor;
    private Integer versionMajor;

    /**
     * default constructor to instantiate new {@link VersionInfo} object with all versions set to default value.
     */
    public VersionInfo() {
        versionBuild = versionMinor = versionMajor = DEFAULT_VERSION_VALUE;
    }

    /**
     * default constructor used to create new instance by given version values.
     *
     * @param versionBuild - build version.
     * @param versionMinor - version minor.
     * @param versionMajor - version major.
     */
    public VersionInfo(@NotNull Integer versionBuild,
                       @NotNull Integer versionMinor,
                       @NotNull Integer versionMajor) {
        this.versionBuild = versionBuild;
        this.versionMinor = versionMinor;
        this.versionMajor = versionMajor;
    }

    /**
     * get build version.
     *
     * @return build version value.
     */
    public @NotNull Integer getVersionBuild() {
        return versionBuild;
    }

    /**
     * get version minor.
     *
     * @return version minor value.
     */
    public @NotNull Integer getVersionMinor() {
        return versionMinor;
    }

    /**
     * get version major.
     *
     * @return version major value.
     */
    public @NotNull Integer getVersionMajor() {
        return versionMajor;
    }

    /**
     * reset build version to default value.
     */
    public void resetVersionBuild() {
        versionBuild = DEFAULT_VERSION_VALUE;
    }

    /**
     * reset version minor to default value.
     */
    public void resetVersionMinor() {
        versionMinor = DEFAULT_VERSION_VALUE;
    }

    /**
     * increment bulid version by one.
     */
    public void incrementVersionBuild() {
        ++versionBuild;
    }

    /**
     * increment version minor. Also resets build version.
     */
    public void incrementVersionMinor() {
        ++versionMinor;
        resetVersionBuild();
    }

    /**
     * increment version major. Also resets minor and build versions.
     */
    public void incrementVersionMajor() {
        ++versionMajor;
        resetVersionMinor();
        resetVersionBuild();
    }

    /**
     * get version as {@link String}.
     *
     * @return version info as {@link String}.
     */
    @Override
    public @NotNull String toString() {
        return versionMajor.toString() + VERSION_SEPARATOR
                + versionMinor.toString() + VERSION_SEPARATOR
                + versionBuild.toString();
    }
}
