package ru.rougegibbons.jsge.engine.versions;

import org.jetbrains.annotations.NotNull;

/**
 * class holding methods to match {@link VersionInfo} objects.
 *
 * @author Kirill Cherkasov
 * @see VersionInfo
 * @since 0.0.1
 */
public final class VersionMatcher {
    private VersionMatcher() {

    }

    /**
     * check if two given {@link VersionInfo} are equal.
     *
     * @param lhs - first {@link VersionInfo}.
     * @param rhs - second {@link VersionInfo}.
     * @return true if versions match, false otherwise.
     */
    public static @NotNull Boolean areEqual(@NotNull VersionInfo lhs,
                                            @NotNull VersionInfo rhs) {
        return (lhs.getVersionMajor().equals(rhs.getVersionMajor()))
                && (lhs.getVersionMinor().equals(rhs.getVersionMinor()))
                && (lhs.getVersionBuild().equals(rhs.getVersionBuild()));
    }

    /**
     * check if one {@link VersionInfo} is newer than another.
     *
     * @param lhs - first {@link VersionInfo} (the one assumed to be newer).
     * @param rhs - second {@link VersionInfo}.
     * @return true if lhs is newer than rhs, false otherwise.
     */
    @SuppressWarnings("Duplicates")
    public static @NotNull Boolean isNewer(@NotNull VersionInfo lhs,
                                           @NotNull VersionInfo rhs) {
        if (lhs.getVersionMajor() > rhs.getVersionMajor()) {
            return true;
        } else if (lhs.getVersionMajor() < lhs.getVersionMajor()) {
            // we've to do this check in order to exclude returning true
            // when lhs' version major is less than rhs',
            // but lhs' version minor or build verison is greater than rhs' one.
            return false;
        }
        if (lhs.getVersionMinor() > rhs.getVersionMinor()) {
            return true;
        } else if (lhs.getVersionMinor() < rhs.getVersionMinor()) {
            // same reason as above.
            return false;
        }
        return lhs.getVersionBuild() > rhs.getVersionBuild();
    }

    /**
     * check if one {@link VersionInfo} instance is older than another.
     *
     * @param lhs - first {@link VersionInfo} instance (the one assumed to be older).
     * @param rhs - second {@link VersionInfo} instance.
     * @return true if lhs is older than rhs, false otherwise.
     */
    @SuppressWarnings("Duplicates")
    public static @NotNull Boolean isOlder(@NotNull VersionInfo lhs,
                                           @NotNull VersionInfo rhs) {
        if (lhs.getVersionMajor() < rhs.getVersionMajor()) {
            return true;
        } else if (lhs.getVersionMajor() > lhs.getVersionMajor()) {
            // we've to do this check in order to exclude returning true
            // when lhs' version major is greater than rhs',
            // but lhs' version minor or build verison is lesser than rhs' one.
            return false;
        }
        if (lhs.getVersionMinor() < rhs.getVersionMinor()) {
            return true;
        } else if (lhs.getVersionMinor() > rhs.getVersionMinor()) {
            // same reason as above.
            return false;
        }
        return lhs.getVersionBuild() < rhs.getVersionBuild();
    }
}
