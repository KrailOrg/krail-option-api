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

package uk.q3c.krail.option.persist;

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.MapBinder;

import java.lang.annotation.Annotation;

/**
 * Utility class to help with some of the binding mechanics for handling  {@link OptionDaoDelegate} and {@link OptionPersistenceInfo}
 * <p>
 * Created by David Sowerby on 26/06/15.
 */
public class OptionPersistenceHelper {

    public static final String PROVIDE_OPTION_DAO = "ProvideOptionDao";

    public static TypeLiteral<Class<? extends Annotation>> annotationClassLiteral = new TypeLiteral<Class<? extends Annotation>>() {
    };
    public static TypeLiteral<Provider<OptionDaoDelegate>> optionTypeLiteral = new TypeLiteral<Provider<OptionDaoDelegate>>() {
    };
    public static TypeLiteral<OptionPersistenceInfo> persistenceInfoClassLiteral = new TypeLiteral<OptionPersistenceInfo>() {
    };

    public static MapBinder<Class<? extends Annotation>, OptionPersistenceInfo> optionDaoProviders(Binder binder) {
        return MapBinder.newMapBinder(binder, annotationClassLiteral, persistenceInfoClassLiteral);
    }


    public static TypeLiteral<Class<? extends Annotation>> annotationClassLiteral() {
        return annotationClassLiteral;
    }
}
