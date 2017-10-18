/*
 *
 *  * Copyright (c) 2016. David Sowerby
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 *  * the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 *  * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *  * specific language governing permissions and limitations under the License.
 *
 */

package uk.q3c.krail.option;

import org.junit.Test;
import uk.q3c.krail.i18n.I18NKey;
import uk.q3c.krail.option.mock.MockOptionContext;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionKeyTest {

    private Class<? extends OptionContext> contextClass = MockOptionContext.class;

    @Test
    public void compositeKey() {
        //given

        //when
        OptionKey<Integer> noQualifiers = new OptionKey<>(33, MockOptionContext.class, TestLabelKey.key1);
        OptionKey<Integer> oneQualifiers = new OptionKey<>(44, MockOptionContext.class, TestLabelKey.key1, "q1");
        OptionKey<Integer> twoQualifiers = new OptionKey<>(55, MockOptionContext.class, TestLabelKey.key1, "q1", "q2");
        //then
        assertThat(noQualifiers.compositeKey()).isEqualTo("MockOptionContext-key1");
        assertThat(oneQualifiers.compositeKey()).isEqualTo("MockOptionContext-key1-q1");
        assertThat(twoQualifiers.compositeKey()).isEqualTo("MockOptionContext-key1-q1-q2");
    }

    @Test(expected = NullPointerException.class)
    public void null_context() {
        //given
        Class<? extends OptionContext> clazz = null;
        //when
        OptionKey<Integer> noQualifiers = new OptionKey<>(22, clazz, TestLabelKey.key1);
        //then
        assertThat(true).isFalse();
    }

    @Test
    public void qualifiedWith() {
        //given
        OptionKey<Integer> noQualifiers = new OptionKey<>(22, MockOptionContext.class, TestLabelKey.key1);
        //when
        OptionKey qualified = noQualifiers.qualifiedWith("a", "b");
        //then
        assertThat(qualified.compositeKey()).isEqualTo("MockOptionContext-key1-a-b");
        //when
        OptionKey qualifiedAgain = qualified.qualifiedWith("c", "d");
        //then
        assertThat(qualifiedAgain.compositeKey()).isEqualTo("MockOptionContext-key1-a-b-c-d");
    }

    //@Ignore(value = "Constructor doesn't allow null name key without compile error")
    //    @Test(expected = NullPointerException.class)
    //    public void null_key() {
    //        //given
    //
    //        //when
    //        OptionKey<Integer>  noQualifiers = new OptionKey<>(22,LocaleContainer.class, LabelKey.Yes);
    //        //then
    //        assertThat(true).isFalse();
    //    }

    enum TestLabelKey implements I18NKey {
        key1
    }
}