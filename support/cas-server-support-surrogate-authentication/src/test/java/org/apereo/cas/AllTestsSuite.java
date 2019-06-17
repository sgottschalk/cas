
package org.apereo.cas;

import org.apereo.cas.authentication.SurrogateAuthenticationExceptionHandlerActionTests;
import org.apereo.cas.authentication.SurrogateAuthenticationMetaDataPopulatorTests;
import org.apereo.cas.authentication.SurrogateAuthenticationPostProcessorTests;
import org.apereo.cas.authentication.SurrogatePrincipalElectionStrategyTests;
import org.apereo.cas.authentication.SurrogatePrincipalResolverTests;
import org.apereo.cas.authentication.audit.SurrogateAuditPrincipalIdProviderTests;
import org.apereo.cas.authentication.surrogate.JsonResourceSurrogateAuthenticationServiceTests;
import org.apereo.cas.authentication.surrogate.SimpleSurrogateAuthenticationServiceTests;
import org.apereo.cas.ticket.support.SurrogateSessionExpirationPolicyJsonSerializerTests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * This is {@link AllTestsSuite}.
 *
 * @author Auto-generated by Gradle Build
 * @since 6.0.0-RC3
 */
@SelectClasses({
    SurrogateAuthenticationPostProcessorTests.class,
    SurrogateAuthenticationMetaDataPopulatorTests.class,
    SurrogatePrincipalResolverTests.class,
    SurrogateAuditPrincipalIdProviderTests.class,
    SimpleSurrogateAuthenticationServiceTests.class,
    JsonResourceSurrogateAuthenticationServiceTests.class,
    SurrogatePrincipalElectionStrategyTests.class,
    SurrogateSessionExpirationPolicyJsonSerializerTests.class,
    SurrogateAuthenticationExceptionHandlerActionTests.class
})
@RunWith(JUnitPlatform.class)
public class AllTestsSuite {
}
