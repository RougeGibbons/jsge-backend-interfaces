package engine.versions;

import org.junit.jupiter.api.Test;
import ru.rougegibbons.jsge.engine.versions.VersionInfo;
import ru.rougegibbons.jsge.engine.versions.VersionMatcher;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test file covering {@link ru.rougegibbons.jsge.engine.versions} classes functionality.
 *
 * @author Kirill Cherkasov
 * @see VersionInfo
 * @since 0.0.1
 */
public final class VersionsTest {
    /**
     * test checking different {@link VersionInfo} constructors and getters.
     */
    @Test
    public void VersionInfoCreationTest() {
        final Random generator = new Random(System.currentTimeMillis());

        VersionInfo testInstance = new VersionInfo();
        assertEquals(VersionInfo.DEFAULT_VERSION_VALUE,
                testInstance.getVersionBuild().intValue(),
                "VersionInfo() test: build version shall be equal to DEFAULT_VERSION_VALUE("
                        + VersionInfo.DEFAULT_VERSION_VALUE + ").");
        assertEquals(VersionInfo.DEFAULT_VERSION_VALUE,
                testInstance.getVersionMinor().intValue(),
                "VersionInfo() test: version minor shall be equal to DEFAULT_VERSION_VALUE("
                        + VersionInfo.DEFAULT_VERSION_VALUE + ").");
        assertEquals(VersionInfo.DEFAULT_VERSION_VALUE,
                testInstance.getVersionMajor().intValue(),
                "VersionInfo() test: version major shall be equal to DEFAULT_VERSION_VALUE("
                        + VersionInfo.DEFAULT_VERSION_VALUE + ").");

        final Integer buildVersion = generator.nextInt();
        final Integer versionMinor = generator.nextInt();
        final Integer versionMajor = generator.nextInt();
        testInstance = new VersionInfo(buildVersion, versionMinor, versionMajor);
        assertEquals(buildVersion.intValue(), testInstance.getVersionBuild().intValue(),
                "VersionInfo(Integer, Integer, Integer) test: build version shall be " + buildVersion);
        assertEquals(versionMinor.intValue(), testInstance.getVersionMinor().intValue(),
                "VersionInfo(Integer, Integer, Integer) test: version minor shall be " + versionMinor);
        assertEquals(versionMajor.intValue(), testInstance.getVersionMajor().intValue(),
                "VersionInfo(Integer, Integer, Integer) test: version major shall be " + versionMajor);
    }

    /**
     * test checking {@link VersionInfo}.incrementXXX() methods work.
     */
    @Test
    public void VersionInfoIncrementsTest() {
        final VersionInfo testInstance = new VersionInfo();
        assertEquals(VersionInfo.DEFAULT_VERSION_VALUE,
                testInstance.getVersionBuild().intValue(),
                "VersionInfo.incrementVersionBuild() test:"
                        + " initial build version shall be equal to DEFAULT_VERSION_VALUE("
                        + VersionInfo.DEFAULT_VERSION_VALUE + ").");
        assertEquals(VersionInfo.DEFAULT_VERSION_VALUE,
                testInstance.getVersionMinor().intValue(),
                "VersionInfo.incrementVersionBuild() test:"
                        + " initial version minor shall be equal to DEFAULT_VERSION_VALUE("
                        + VersionInfo.DEFAULT_VERSION_VALUE + ").");
        assertEquals(VersionInfo.DEFAULT_VERSION_VALUE,
                testInstance.getVersionMajor().intValue(),
                "VersionInfo.incrementVersionBuild() test:"
                        + " initial version major shall be equal to DEFAULT_VERSION_VALUE("
                        + VersionInfo.DEFAULT_VERSION_VALUE + ").");

        testInstance.incrementVersionBuild();
        assertEquals(VersionInfo.DEFAULT_VERSION_VALUE + 1,
                testInstance.getVersionBuild().intValue(),
                "VersionInfo.incrementVersionBuild() test 1:"
                        + " build version after increment shall be equal to "
                        + (VersionInfo.DEFAULT_VERSION_VALUE + 1) + '.');
        assertEquals(VersionInfo.DEFAULT_VERSION_VALUE,
                testInstance.getVersionMinor().intValue(),
                "VersionInfo.incrementVersionBuild() test 1:"
                        + " version minor after increment shall be equal to DEFAULT_VERSION_VALUE("
                        + VersionInfo.DEFAULT_VERSION_VALUE + ").");
        assertEquals(VersionInfo.DEFAULT_VERSION_VALUE,
                testInstance.getVersionMajor().intValue(),
                "VersionInfo.incrementVersionBuild() test 1:"
                        + " version major after increment shall be equal to DEFAULT_VERSION_VALUE("
                        + VersionInfo.DEFAULT_VERSION_VALUE + ").");

        testInstance.incrementVersionMinor();
        assertEquals(VersionInfo.DEFAULT_VERSION_VALUE,
                testInstance.getVersionBuild().intValue(),
                "VersionInfo.incrementVersionMinor() test:"
                        + " build version after increment shall be reset to DEFAULT_VERSION_VALUE("
                        + VersionInfo.DEFAULT_VERSION_VALUE + ").");
        assertEquals(VersionInfo.DEFAULT_VERSION_VALUE + 1,
                testInstance.getVersionMinor().intValue(),
                "VersionInfo.incrementVersionMinor() test:"
                        + " version minor after increment shall be equal to "
                        + (VersionInfo.DEFAULT_VERSION_VALUE + 1) + '.');
        assertEquals(VersionInfo.DEFAULT_VERSION_VALUE,
                testInstance.getVersionMajor().intValue(),
                "VersionInfo.incrementVersionMinor() test:"
                        + " version major after increment shall be equal to DEFAULT_VERSION_VALUE("
                        + VersionInfo.DEFAULT_VERSION_VALUE + ").");

        testInstance.incrementVersionBuild();
        assertEquals(VersionInfo.DEFAULT_VERSION_VALUE + 1,
                testInstance.getVersionBuild().intValue(),
                "VersionInfo.incrementVersionBuild() test 2:"
                        + " build version after increment shall be equal to "
                        + (VersionInfo.DEFAULT_VERSION_VALUE + 1) + '.');
        assertEquals(VersionInfo.DEFAULT_VERSION_VALUE + 1,
                testInstance.getVersionMinor().intValue(),
                "VersionInfo.incrementVersionBuild() test 2:"
                        + " version minor after increment shall be equal to "
                        + (VersionInfo.DEFAULT_VERSION_VALUE + 1) + '.');
        assertEquals(VersionInfo.DEFAULT_VERSION_VALUE,
                testInstance.getVersionMajor().intValue(),
                "VersionInfo.incrementVersionBuild() test 2:"
                        + " version major after increment shall be equal to DEFAULT_VERSION_VALUE("
                        + VersionInfo.DEFAULT_VERSION_VALUE + ").");

        testInstance.incrementVersionMajor();
        assertEquals(VersionInfo.DEFAULT_VERSION_VALUE,
                testInstance.getVersionBuild().intValue(),
                "VersionInfo.incrementVersionMajor() test:"
                        + " build version after increment shall be reset to DEFAULT_VERSION_VALUE("
                        + VersionInfo.DEFAULT_VERSION_VALUE + ").");
        assertEquals(VersionInfo.DEFAULT_VERSION_VALUE,
                testInstance.getVersionMinor().intValue(),
                "VersionInfo.incrementVersionMajor() test:"
                        + " version minor after increment shall be reset to DEFAULT_VERSION_VALUE("
                        + VersionInfo.DEFAULT_VERSION_VALUE + ").");
        assertEquals(VersionInfo.DEFAULT_VERSION_VALUE + 1,
                testInstance.getVersionMajor().intValue(),
                "VersionInfo.incrementVersionMajor() test:"
                        + " version major after increment shall be equal to "
                        + (VersionInfo.DEFAULT_VERSION_VALUE + 1) + '.');
    }

    /**
     * test checking {@link VersionMatcher}.areEqual() method's work.
     */
    @Test
    public void VersionMatcherAreEqualTest() {
        final VersionInfo lhs = new VersionInfo();
        final VersionInfo rhs = new VersionInfo();

        assertTrue(VersionMatcher.areEqual(lhs, rhs), "two VersionInfo instances shall be equal.");

        lhs.incrementVersionBuild();
        assertFalse(VersionMatcher.areEqual(lhs, rhs),
                "two VersionInfo instances shall not be equal after one of them was incremented.");
        rhs.incrementVersionBuild();
        assertTrue(VersionMatcher.areEqual(lhs, rhs), "two VersionInfo instances shall again be equal.");
    }

    /**
     * test checking {@link VersionMatcher}.isNewer() method's vork.
     */
    @Test
    public void VersionMatcherIsNewerTest() {
        final VersionInfo lhs = new VersionInfo();
        final VersionInfo rhs = new VersionInfo();

        assertFalse(VersionMatcher.isNewer(lhs, rhs), "two VersionInfo instances are equal.");

        lhs.incrementVersionBuild();
        assertTrue(VersionMatcher.isNewer(lhs, rhs), "lhs shall be newer.");
        rhs.incrementVersionMinor();
        assertFalse(VersionMatcher.isNewer(lhs, rhs), "rhs shall be newer.");
        lhs.incrementVersionMajor();
        assertTrue(VersionMatcher.isNewer(lhs, rhs), "lhs shall be newer.");
    }

    /**
     * test checking {@link VersionMatcher}.isOlder() method's work.
     */
    @Test
    public void VersionMatcherIsOlderTest() {
        final VersionInfo lhs = new VersionInfo();
        final VersionInfo rhs = new VersionInfo();

        assertFalse(VersionMatcher.isOlder(lhs, rhs), "two VersionInfo instances are equal.");

        rhs.incrementVersionBuild();
        assertTrue(VersionMatcher.isOlder(lhs, rhs), "lhs shall be older.");
        lhs.incrementVersionMinor();
        assertFalse(VersionMatcher.isOlder(lhs, rhs), "rhs shall be older");
        rhs.incrementVersionMajor();
        assertTrue(VersionMatcher.isOlder(lhs, rhs), "lhs shall be older.");
    }
}
