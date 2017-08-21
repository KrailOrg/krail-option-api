package uk.q3c.krail.option.test;

import uk.q3c.krail.i18n.test.MockLabelKey;
import uk.q3c.krail.option.Option;
import uk.q3c.krail.option.OptionContext;
import uk.q3c.krail.option.OptionKey;

/**
 * Created by David Sowerby on 21 Aug 2017
 */
public class MockOptionContext implements OptionContext<Object> {

    public static final OptionKey<Integer> optionKeyFlipFlop = new OptionKey<>(32, MockOptionContext.class, MockLabelKey.Yes, MockLabelKey.No);

    @Override
    public Option optionInstance() {
        return null;
    }

    @Override
    public void optionValueChanged(Object event) {

    }
}
