package org.apereo.cas.configuration.model.support.saml.idp.metadata;

import org.apereo.cas.configuration.model.core.util.EncryptionJwtSigningJwtCryptographyProperties;
import org.apereo.cas.configuration.model.support.mongo.SingleCollectionMongoDbProperties;
import org.apereo.cas.configuration.support.RequiresModule;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Configuration properties class mongodb service registry.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-saml-idp-metadata-mongo")
@Getter
@Setter
public class MongoDbSamlMetadataProperties extends SingleCollectionMongoDbProperties {

    private static final long serialVersionUID = -227092724742371662L;

    /**
     * The collection name that is responsible to hold
     * the identity provider metadata.
     */
    private String idpMetadataCollection;

    /**
     * Crypto settings that sign/encrypt the metadata records.
     */
    @NestedConfigurationProperty
    private EncryptionJwtSigningJwtCryptographyProperties crypto = new EncryptionJwtSigningJwtCryptographyProperties();

    public MongoDbSamlMetadataProperties() {
        setCollection("cas-saml-metadata");
    }
}
