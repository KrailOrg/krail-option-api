package uk.q3c.krail.option.persist

import com.google.inject.Provider
import spock.lang.Specification
import uk.q3c.krail.i18n.Translate
import uk.q3c.krail.i18n.persist.I18NPersistDescriptionKey
import uk.q3c.krail.i18n.persist.I18NPersistLabelKey
import uk.q3c.krail.i18n.test.MockTranslate

import static org.mockito.Mockito.*

/**
 * Created by David Sowerby on 19 Aug 2017
 */
class OptionPersistenceInfoTest extends Specification {

    class TestConfig extends OptionPersistenceInfo {
        TestConfig() {
            nameKey(I18NPersistLabelKey.Selected_Pattern_Targets)
            descriptionKey(I18NPersistDescriptionKey.Source_Order)
            connectionUrl("connection string")
        }
    }


    OptionPersistenceInfo info
    OptionPersistenceInfo config
    Translate translate
    Provider<Translate> translateProvider = mock(Provider)

    def setup() {
        config = new TestConfig()
        translate = new MockTranslate()
        when(translateProvider.get()).thenReturn(translate)
        info = new OptionPersistenceInfo(translateProvider, config)
    }

    def "key translation"() {
        expect:
        info.getNameKey() == I18NPersistLabelKey.Selected_Pattern_Targets
        info.getDescriptionKey() == I18NPersistDescriptionKey.Source_Order
        info.getConnectionUrl() == "connection string"
        info.getName() == "Selected Pattern Targets"
        info.getDescription() == "Source Order"
    }
}
